package controller;
import db_connection.File;
import db_connection.TXTFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelConfig;
import model.ModelTransaction;
import model.SlaveStatus;
import model.TransactionQuery;

public class AppDriver {
    public static void main(String[] args) {
        File file = new TXTFile("src/db_connection/config.txt");
        
        if(file.getConnector().getConnection() != null){
            System.out.println("GUMANA AMPUTA");
            Controller.getInstance();
        }else{
            System.out.println("AYAW GUMANA AMPUTA");
            JOptionPane.showMessageDialog(null, "Error connecting to MySQL!", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
}
