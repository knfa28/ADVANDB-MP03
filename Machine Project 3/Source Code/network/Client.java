package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client{
    
    private DataInputStream dis;
    private DataOutputStream dos;
    
    public Client(String ipAddress, int portNo)
    {
        try{
            Socket cSock = new Socket(ipAddress, portNo);
            dis = new DataInputStream(cSock.getInputStream());
            dos = new DataOutputStream(cSock.getOutputStream());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void sendQuery(String toBeSent)
    {
        try{
            dos.writeUTF("NORMALQUERY%" + toBeSent);
            System.out.println(dis.readUTF());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void sendGlobalQuery(String toBeSent)
    {
        try{
            do{
                dos.writeUTF("GLOBALQUERY%" + toBeSent);
            }while(dis.readUTF().equals("UNSUCCESSFUL"));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
