
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashSet;
import javax.swing.JOptionPane;


public class Chatbox extends javax.swing.JFrame {
   public String IP; //public vars so they're accessed from main class
   public String name;
   public int port;
  
   
   HashSet<String> names = new HashSet<>(); //hashset containing names
   Connection con1 = new Connection();
   
   public void CallThread() {
               //calls thread that handles the connection
                Runnable r1 = new trycon();
                Thread t1 = new Thread(r1);
                t1.start();
   }
   private void SendEncryptedMessage(String msg) throws Exception {
       //send encrypted message function
       con1.out.println("MESSAGE<" + AES.encrypt(msg) 
                                          + "> NAME<" + name + ">");
   }
   private void SendToSrv(String data) { 
       //send commands to server
       con1.out.println(data);
   }
   private void addKeyListener(){ 
       //function to detect ENTER key to send message
       //if you want to use a send button just make it send to server
       //MESSAGE<AESencryptedMessage> NAME<name1>
       
       MessageTextBox.addKeyListener(
                new KeyAdapter() {
                    public void keyReleased ( KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER)
                        {
                       if (MessageTextBox.getText() == null){
                       }else { 
                           try {
                               SendEncryptedMessage (MessageTextBox.getText());
                           } catch (Exception ex) {
                              JOptionPane.showMessageDialog(null, ex);
                           }                        
                             }
                        MessageTextBox.setText(null);
                        }
                    }
                }
                );
   }
    public Chatbox() {
        initComponents();
        addKeyListener();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        recvMessageArea = new javax.swing.JTextArea();
        ulist = new java.awt.List();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        MessageTextBox = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        exitMenu = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem7.setText("jMenuItem7");

        jMenuItem9.setText("jMenuItem9");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(563, 473));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        recvMessageArea.setColumns(20);
        recvMessageArea.setLineWrap(true);
        recvMessageArea.setRows(5);
        jScrollPane2.setViewportView(recvMessageArea);

        ulist.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ulistActionPerformed(evt);
            }
        });

        MessageTextBox.setName("MessageTextBox"); // NOI18N

        jMenu6.setText("File");
        jMenu6.add(jSeparator4);

        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitMenuActionPerformed(evt);
            }
        });
        jMenu6.add(exitMenu);
        jMenu6.add(jSeparator3);

        jMenuBar1.add(jMenu6);

        jMenu5.setLabel("Help");

        aboutMenu.setText("About");
        aboutMenu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                aboutMenuActionPerformed(evt);
            }
        });
        jMenu5.add(aboutMenu);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(MessageTextBox)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(130, 130, 130)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(ulist, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 16, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(381, 381, 381)
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ulist, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MessageTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuActionPerformed
      JOptionPane.showMessageDialog(this, "EncryChat 1.0\n"
              + "MultiClient chat application with AES encryption.\n"
              + "Author: \t Fatos Bediu\n"
              + "e-mail: tosi.psy@gmail.com\n"
              + "GitHub: http://github.com/fatosb");
    }//GEN-LAST:event_aboutMenuActionPerformed

    private void ulistActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ulistActionPerformed
    {//GEN-HEADEREND:event_ulistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ulistActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitMenuActionPerformed
    {//GEN-HEADEREND:event_exitMenuActionPerformed
            System.exit(0);
            
    }//GEN-LAST:event_exitMenuActionPerformed

   
    
    
    public void main(String args[]) {      
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {    
            new Chatbox().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MessageTextBox;
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    public javax.swing.JTextArea recvMessageArea;
    private java.awt.List ulist;
    // End of variables declaration//GEN-END:variables
    public  class trycon implements Runnable {
    
        
        public trycon() {
        }
        @Override
        public void run() {
            try {
                setTitle("Encry Chat 1.0 - Status: Connecting to server..");
                con1.connectto(name,IP, port);
              
              
               
          
                while (true) {
            String line = con1.in.readLine();
           System.out.println(line);
            if (line.startsWith("NAME")) { //if server sends command 'NAME'
                SendToSrv(name);  //Reply back with a name
              
             SendToSrv("USERS"); //Ask for online users
            }
             if (line.startsWith("USERS")) //server replies with        
            {//                              USERS<name1, name2>
                 
              String _name0 = line.substring(4); //string handling to parse
              String _nameA[] = _name0.split("<");//user list in an array
              String _nameB[] = _nameA[1].split(">");
              String _nameC = _nameB[0].replace(" ", "");
              String _nameD[] = _nameC.split(",");
              //array _nameD[] contains user list
             for (int _n = 0; _n < _nameD.length; _n++){
                  ulist.add(_nameD[_n]); 
                  //add all names from array to awt list 'ulist'
             }
             
            setTitle("Encry Chat 1.0 - Status: Connected to server: " + IP + 
                     " || Name: " + name + " || Users online: " + 
                     Integer.toString(_nameD.length));   
            
            }if (line.startsWith("MESSAGE")) {
                //server handles messages by using command
                //MESSAGE<AESEncrypedMessage> NAME<name1>
                
                //string handling to get encrypted message and name
                 String[] _line = line.split(">");
                 String[] _message = _line[0].split("<");
                 String[] _name = _line[1].split("<");
          recvMessageArea.append("\n " + _name[1] + ": " +  AES.decrypt(_message[1]));
                                            }
            
            if (line.startsWith("JOINED")) {
                //server will send command 'JOINED <name1>'
                //if a client has joined
                String _joinedA[] = line.split("<");
                String _joinedB[] = _joinedA[1].split(">");
                recvMessageArea.append(_joinedB[0] + " has joined...\n");
                ulist.add(_joinedB[0]);
            }
                        
                }
                
            } catch (IOException ex) {
               JOptionPane.showMessageDialog(null,ex);
                
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null,ex); 
            }
//           
        }
    }
    

}
    
