package model;

public class SlaveStatus {
    private String slave_io_state;
    private String master_host;
    private int master_port;
    private String slave_io_running;
    private String slave_sql_running;
    private String channel_name;

    public SlaveStatus(String slave_io_state, String master_host, int master_port, String slave_io_running, String slave_sql_running, String channel_name) {
        this.slave_io_state = slave_io_state;
        this.master_host = master_host;
        this.master_port = master_port;
        this.slave_io_running = slave_io_running;
        this.slave_sql_running = slave_sql_running;
        this.channel_name = channel_name;
    }
    
    public void changeMaster(){
        ModelConfig.changeMaster(master_host, master_port, channel_name);
    }
    
    public void resetMaster(){
        ModelConfig.resetMaster();
    }
    
    public void stopSlave(){
        ModelConfig.stopSlave(channel_name);
    }
    
    public void startSlave(){
        ModelConfig.startSlave(channel_name);
    }

    public String getSlave_io_state() {
        return slave_io_state;
    }

    public void setSlave_io_state(String slave_io_state) {
        this.slave_io_state = slave_io_state;
    }

    public String getMaster_host() {
        return master_host;
    }

    public void setMaster_host(String master_host) {
        this.master_host = master_host;
    }

    public int getMaster_port() {
        return master_port;
    }

    public void setMaster_port(int master_port) {
        this.master_port = master_port;
    }

    public String getSlave_io_running() {
        return slave_io_running;
    }

    public void setSlave_io_running(String slave_io_running) {
        this.slave_io_running = slave_io_running;
    }

    public String getSlave_sql_running() {
        return slave_sql_running;
    }

    public void setSlave_sql_running(String slave_sql_running) {
        this.slave_sql_running = slave_sql_running;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    
}
