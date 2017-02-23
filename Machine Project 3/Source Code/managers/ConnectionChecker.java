package managers;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionChecker implements Runnable{

    private ResultSet rs;
    private final static String cCheckQuery = "SELECT * FROM information_schema.processlist where STATE = 'waiting for master to send event';";
    private String getMasterConnection = "START SLAVE for channel";
    
    public ConnectionChecker(String masterID)
    {
        getMasterConnection = getMasterConnection + "\'" + masterID + "';";
    }
    
    @Override
    public void run() {
        try {
            rs = MySQLConnector.executeQuery(cCheckQuery);
            if(!rs.next())
            {
                MySQLConnector.executeStatement(getMasterConnection);
            }
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
