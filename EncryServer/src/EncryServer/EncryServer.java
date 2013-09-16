
package EncryServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Random;



public class EncryServer {

    private static final int PORT = 1357;
    //change port here

    private static HashSet<String> names = new HashSet<>();  
    //hashset containing names
    private static HashSet<PrintWriter> writers = new HashSet<>();
    //hashset containing all connected users printwriters

    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }


    private static class Handler extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public int randint(int max, int min)
        { //returns a random int between given values
          //used for adding random characters to users connected with same name
             Random rand = new Random();
            int randomNum = rand.nextInt((max - min) + 1) + min;
            return randomNum;
        }
        
        @Override
        public void run() {
            try {
                // Create character streams for the socket.
                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                //if a client is connected, ask for name using 'NAME' command
                while (true) {
                    out.println("NAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    //names configuration
                    //if the submitted name is in the 'names' list
                    //adds a random number after the name.
                    //else just adds the name to the list
                   synchronized (names){
                       if (names.contains(name)){
                           name += randint(1000,1);
                           names.add(name);
                       } else {
                           names.add(name);
                       }
                   }
                    break;                    
                }

              
             for (PrintWriter joined : writers)  { 
                 //alarm clients that user joined
                 joined.println("JOINED<" + name + ">");
             }
               //after alarming all users that client joined
               //adds socket's print writer to hashset of all writers
                 writers.add(out);
              
                 while (true) {
                    String input = in.readLine();
                    
                if (input.contains("MESSAGE")) {
                //Message handler
                //if server receives command ' MESSAGE<msg> NAME<name>'
                //outputs the same to all connected users
                //the string handling is done from the client
                    for (PrintWriter writer : writers) {
                  writer.println(input);  
                     }
                    } 
                
                     if (input.startsWith("USERS")){
                         //If the client is asking user list
                         //return 'USERS<name1, name2>'
                                String _names0 = names.toString().replace("[","<");
                                String _names1 = _names0.replace("]", ">");                               
                                out.println("USERS " + _names1);         
                    }
             }//end while
             
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                    //if client shuts down, clear everything and close socket
                if (name != null) {
                    names.remove(name);
                }
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}