package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import managers.LogHandler;
import network.Client;

public class ModelTransaction implements Runnable{
    private String node, others, destination;
    private int isolationType, commitType, transType;
    private ArrayList<Integer> params;
    private Client client;
    private boolean isGlobal;
    
    public ModelTransaction(String node, int isolationType, int commitType, int transType, ArrayList<Integer> params, String others, Client client, boolean isGlobal){
        this.node = node;
        this.isolationType = isolationType;
        this.commitType = commitType;
        this.transType = transType;
        this.params = params;
        this.others = others;
        this.client = client;
        this.isGlobal = isGlobal;
    }
    
    public static ArrayList<TransactionQuery> getAll(String node){
        ArrayList<TransactionQuery> objectList = new ArrayList<TransactionQuery>();
        String table;
 
        switch(node){
            case "master-2": table = "db_hpq_palawan.hpq_death\n"; break;
            case "master-3": table = "db_hpq_marinduque.hpq_death\n"; break;
            default: table = "hpq_death\n"; break;
        }
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT hpq_hh_id, id, mdeadsx, mdeadage, mdeady, mdeady_o\n" +
                                                           "FROM " + table + ";");
            while(rsList.next()) {
                objectList.add(new TransactionQuery(rsList.getInt("hpq_hh_id"),
                                                    rsList.getInt("id"),
                                                    rsList.getInt("mdeadsx"),
                                                    rsList.getInt("mdeadage"),
                                                    rsList.getInt("mdeady"),
                                                    rsList.getString("mdeady_o")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Result Set - " + objectList.size() + " rows");
        
        return objectList;
    }

    @Override
    public void run() {
        String start = "START TRANSACTION;\n";
        String isolation = "";
        String commit = "";
        String query =  "";      
        String table = "";
        
        switch(isolationType){
            case 0: isolation = "SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;\n"; break;
            case 1: isolation = "SET TRANSACTION ISOLATION LEVEL READ COMMITTED;\n"; break;
            case 2: isolation = "SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;\n"; break;
            case 3: isolation = "SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;\n"; break;
        }
        
        switch(commitType){
            case 0: commit = "COMMIT;"; break;
            case 1: commit = "ROLLBACK;"; break;
        }
 
        switch(node){
            case "master-2": table = "db_hpq_palawan.hpq_death"; break;
            case "master-3": table = "db_hpq_marinduque.hpq_death"; break;
            default: table = "hpq_death"; break;
        }
        
        switch(transType){
            //Read
            case 1: query = "SELECT hpq_hh_id, id, mdeadsx, mdeadage, mdeady, mdeady_o\n" +
                                "FROM " + table + "\n" +
                                "WHERE hpq_hh_id = "+ params.get(0) + ";\n";
                    break;
            //Delete
            case 2: query = "DELETE FROM " + table + "\n" +
                                "WHERE hpq_hh_id = " + params.get(0) + ";\n";
                    break;
            //Update
            case 3: if(params.get(2) == 1){
                        query = "UPDATE " + table + "\n" +
                                    "SET mdeady = " + params.get(3) + ", mdeady_o = NULL\n" +
                                    "WHERE hpq_hh_id = " + params.get(0) + 
                                    " AND id = " + params.get(1) + ";\n";
                    }else {
                        query = "UPDATE " + table + "\n" +
                                    "SET mdeady_o = '" + others + "', mdeady = 17\n" +
                                    "WHERE hpq_hh_id = " + params.get(0) +
                                    " AND id = " + params.get(1) + ";\n";
                    }
                    break;
            //Insert
            case 4: if(params.get(4) == 1){
                        query = "INSERT INTO " + table + "\n" +
                                    "VALUES (" + params.get(0) + "," +
                                    params.get(1) + ", 99, NULL, NULL," +
                                    params.get(2) + ", " + 
                                    params.get(3) + ", " +
                                    params.get(5) + ", NULL);\n";
                    }else {
                        query = "INSERT INTO " + table + "\n" +
                                    "VALUES (" + params.get(0) + "," +
                                    params.get(1) + ", 99, NULL, NULL, " +
                                    params.get(2) + ", " +
                                    params.get(3) + ", 17, '" +
                                    others + "');\n";
                    }
                    break;
        }
        
        System.out.println(isolation + "%" + start + "%" + query + "%" + commit);
        
        if(this.isGlobal){
            client.sendGlobalQuery(isolation + "#" + start + "#" + query + "#" + commit);
        }else {          
            MySQLConnector.executeStatement(isolation);
            MySQLConnector.executeStatement(start);
            MySQLConnector.executeStatement(query);
            MySQLConnector.executeStatement(commit);
            client.sendQuery(isolation + start + query + commit);
            LogHandler.writeToFile(isolation + start + query +commit);
        }
    }
    
    public static void globalTransaction(String query){    
        String[] tempArray = query.split("#");
        System.out.println(tempArray[0]);
        System.out.println(tempArray[1]);
        System.out.println(tempArray[2]);
        System.out.println(tempArray[3]);
        
        MySQLConnector.executeStatement(tempArray[0]);
        MySQLConnector.executeStatement(tempArray[1]);
        MySQLConnector.executeStatement(tempArray[2]);
        MySQLConnector.executeStatement(tempArray[3]);
    }
}
