package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModelConfig {
    public static void changeMaster(String ip_address, int port, String channel){
        MySQLConnector.executeStatement("CHANGE MASTER TO\n" +
                                        "MASTER_HOST = '" + ip_address +"',\n" +
                                        "master_port = " + port +",\n" +
                                        "master_user = 'replicator2',\n" +
                                        "master_password = 'root',\n" +
                                        "master_auto_position = 1 \n" +
                                        "for channel '" + channel + "';");
    }
    
    public static void resetMaster(){
        MySQLConnector.executeStatement("RESET MASTER;");
    }
    
    public static void stopSlave(String channel){
        MySQLConnector.executeStatement("STOP SLAVE FOR CHANNEL '" + channel + "';");
    }
    
    public static void startSlave(String channel){
        MySQLConnector.executeStatement("START SLAVE FOR CHANNEL '" + channel + "';");
    }
    
    public static ArrayList<SlaveStatus> slaveStatus(){
        ArrayList<SlaveStatus> objectList = new ArrayList<SlaveStatus>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SHOW SLAVE STATUS;");
            while(rsList.next()) {
                objectList.add(new SlaveStatus(rsList.getString("Slave_IO_State"),
                                 rsList.getString("Master_Host"),
                                 rsList.getInt("Master_Port"),
                                 rsList.getString("Slave_IO_Running"),
                                 rsList.getString("Slave_SQL_Running"),
                                 rsList.getString("Channel_Name")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Result List - " + objectList.size() + " rows");
        return objectList;
    }
}
