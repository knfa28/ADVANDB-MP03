package managers;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class LogHandler {
    private static File logFile = new File("logFile.txt");
    private static LogHandler logHandler = new LogHandler();
    
    private LogHandler(){
        try{
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static LogHandler getInstance(){	 
        return logHandler; 
    }
    
    public static void writeToFile(String toBeWritten)
    {
        
        try{
        FileWriter fw = new FileWriter(logFile.getAbsoluteFile(), true);
	BufferedWriter bw = new BufferedWriter(fw);
        bw.write(toBeWritten + "\n");
        bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
