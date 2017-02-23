package network;

import controller.Controller;
import db_connection.MySQLConnector;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import managers.LogHandler;
import model.ModelConfig;
import model.ModelTransaction;

public class Server implements Runnable{
        private Controller controller;
        private ServerSocket server;
    public Server(int portNo){
        try{
            server = new ServerSocket(portNo);
            this.controller = Controller.getInstance();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void run(){
        try{
            Socket client = null;
            while(true)
            {
                client = server.accept();
                System.out.println("Client: " + client.getInetAddress().getHostAddress() + " has connected.");
                DataInputStream dis = new DataInputStream(client.getInputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                ReadClient rc = new ReadClient(dis, dos);
                Thread thread = new Thread(rc);
                thread.start();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }    
    }
    
    class ReadClient implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        
        public ReadClient(DataInputStream dis, DataOutputStream dos)
        {
            this.dis = dis;
            this.dos = dos;
        }
        
        public void run(){
            try{
                while(true){
                    String fromClient = dis.readUTF();

                    String[] tempArray = fromClient.split("%");

                    switch(tempArray[0])
                    {
                        case "NORMALQUERY": LogHandler.writeToFile(tempArray[1]); dos.writeUTF("SUCCESSFUL"); break;
                        case "GLOBALQUERY": 
                                            if(controller.isRunning()) {
                                                controller.globalTransaction(tempArray[1]);
                                                dos.writeUTF("SUCCESSFUL");
                                            }
                                            else dos.writeUTF("UNSUCCESSFUL");
                                            break;
                        default: break;
                    }
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
