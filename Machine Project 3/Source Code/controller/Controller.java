package controller;

import java.util.ArrayList;
import model.ModelConfig;
import model.ModelTransaction;
import model.SlaveStatus;
import network.Client;
import view.AppView;

public class Controller {
    private AppView appView;
    private static Controller firstInstance = null;
    private SlaveStatus centralNode;
    private SlaveStatus palawanNode;
    private SlaveStatus marinduqueNode;
    private boolean isCentral = false;
    private String localNode;
    private boolean isCentralConnected = false;
    private boolean isPalConnected = false;
    private boolean isMarConnected = false;
    private boolean isRunning = false;
    private int pPortNo = 1000;
    private int cPortNo = 1001;
    private int mPortNo = 1002;
    private boolean serverRunning = false;
    private Client mClient = null, pClient = null, cClient = null;
    
    private Controller() {
        appView = new AppView(this);
    }
    
    public static Controller getInstance(){
        if(firstInstance == null)
            firstInstance = new Controller();       
        
        return firstInstance;
    }
    
    public boolean isCentral() {
        return isCentral;
    }
    
    public boolean isRunning(){
        return isRunning;
    }
    
    public String getLocalNode(){
        return localNode;
    }
    
    public boolean isCentralConnected() {
        return isCentralConnected;
    }

    public boolean isPalConnected() {
        return isPalConnected;
    }

    public boolean isMarConnected() {
        return isMarConnected;
    }
    
    public void configSlaves(boolean isCentral, String localNode){
        ArrayList<SlaveStatus> nodes = new ArrayList<SlaveStatus>();
        nodes = ModelConfig.slaveStatus();
        this.isCentral = isCentral;
        this.isRunning = true;
        
        if(this.isCentral){    
            for(int i = 1; i < nodes.size(); i++){
                if(nodes.get(i).getChannel_name().equals("master-2"))
                    palawanNode = nodes.get(i);
                else if(nodes.get(i).getChannel_name().equals("master-3"))
                    marinduqueNode = nodes.get(i);
            }
        } else{
            this.localNode = localNode;
            for(int i = 0; i < nodes.size(); i++){
                if(nodes.get(i).getChannel_name().equals("master-1"))
                    centralNode = nodes.get(i);
            }
        }
        
        if(this.isCentral){
            if(!palawanNode.getSlave_io_state().equals("Waiting for master to send event") ||
               !marinduqueNode.getSlave_io_state().equals("Waiting for master to send event")){
            
                palawanNode.startSlave();
                marinduqueNode.startSlave();
            } else if(palawanNode.getSlave_io_state().equals("") ||
                marinduqueNode.getSlave_io_state().equals("")){
                
                palawanNode.stopSlave();
                palawanNode.changeMaster();
                palawanNode.resetMaster();
                palawanNode.startSlave();

                marinduqueNode.stopSlave();
                marinduqueNode.changeMaster();
                marinduqueNode.resetMaster();
                marinduqueNode.startSlave();
            }
        } else {
            if(!centralNode.getSlave_io_state().equals("Waiting for master to send event")){
                centralNode.startSlave();
            } else if(!centralNode.getSlave_io_state().equals("")){
                centralNode.stopSlave();
                centralNode.changeMaster();
                centralNode.resetMaster();
                centralNode.startSlave();
            }
        }
        
        checkConnection();
    }
    
    public void checkConnection(){
        ArrayList<SlaveStatus> nodes = new ArrayList<SlaveStatus>();
        nodes = ModelConfig.slaveStatus();
        
        if(isCentral){    
            for(int i = 1; i < nodes.size(); i++){
                if(nodes.get(i).getChannel_name().equals("master-2"))
                    if(nodes.get(i).getSlave_io_state().equals("Waiting for master to send event"))
                        isPalConnected = true;
                    else isPalConnected = false;
                else if(nodes.get(i).getChannel_name().equals("master-3"))
                    if(nodes.get(i).getSlave_io_state().equals("Waiting for master to send event"))
                        isMarConnected = true;
                    else isMarConnected = false;
            }
        } else{
            for(int i = 0; i < nodes.size(); i++){
                if(nodes.get(i).getChannel_name().equals("master-1"))
                    if(nodes.get(i).getSlave_io_state().equals("Waiting for master to send event"))
                        isCentralConnected = true;
                    else isCentralConnected = false;
            }
        }
    }
    
    public void stopSlaves(){
        this.isRunning = false;
        
        if(isCentral){
            palawanNode.stopSlave();
            marinduqueNode.stopSlave();
        } else{
            centralNode.stopSlave();
        }
        
        checkConnection();
    }
    
    public void startTransaction(String node, int isolationType, int commitType, int transType, ArrayList<Integer> params, String others, Client client, boolean isGlobal){
        //Thread this shit pls :)
        //ModelTransaction.setTransaction(node, isolationType, commitType, transType, params, others);
        ModelTransaction mt = new ModelTransaction(node, isolationType, commitType, transType, params, others, client, isGlobal);
        Thread thread = new Thread(mt);
        thread.start();
    }
    
    public void updateTable(String node){
        appView.updateTable(ModelTransaction.getAll(node));
    }

    public SlaveStatus getCentralNode() {
        return centralNode;
    }

    public void setCentralNode(SlaveStatus centralNode) {
        this.centralNode = centralNode;
    }

    public SlaveStatus getPalawanNode() {
        return palawanNode;
    }

    public void setPalawanNode(SlaveStatus palawanNode) {
        this.palawanNode = palawanNode;
    }

    public SlaveStatus getMarinduqueNode() {
        return marinduqueNode;
    }

    public void setMarinduqueNode(SlaveStatus marinduqueNode) {
        this.marinduqueNode = marinduqueNode;
    }
    
    public void globalTransaction(String query)
    {
        ModelTransaction.globalTransaction(query);
    }
    
    public void startServer()
    {
        if(!this.serverRunning){
            if(!this.isCentral && this.localNode.equals("master-2")){
                network.Server palServer = new network.Server(this.pPortNo);
                Thread palThread = new Thread(palServer);
                palThread.start();

            } else if (!this.isCentral && this.localNode.equals("master-3")){
                network.Server marServer = new network.Server(this.mPortNo);
                Thread marThread = new Thread(marServer);
                marThread.start();
            } else {
                network.Server cenServer = new network.Server(this.cPortNo);
                Thread cenThread = new Thread(cenServer);
                cenThread.start();
            }
            this.serverRunning = true;
        }
    }
    
    public Client startCentralClient()
    {
        this.cClient = new network.Client(this.getCentralNode().getMaster_host(), cPortNo);    
        return cClient;
    }
    
    public Client startMarinduqueClient()
    {
        this.mClient = new network.Client(this.getMarinduqueNode().getMaster_host(), mPortNo);
        return mClient;
    }
    
    public Client startPalawanClient()
    {
        this.pClient = new network.Client(this.getPalawanNode().getMaster_host(), pPortNo);
        return pClient;
    }
}
