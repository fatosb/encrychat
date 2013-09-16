
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Connection {
       
   public BufferedReader in;
    public PrintWriter out;
  
    //simple tcp ip connection
    public void connectto(String name, String IP, int port) 
                                            throws IOException
    {
         
        Socket socket = new Socket(IP, port);
        
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

  
               
                    
        }
    }

