				EncryChat 1.0 

EncryChat is a TCP multi-client chat system with AES encryption.
The following project includes a chat server, and a client.

Chat SERVER: EncryServer.java


To edit port, go to EncryServer.java, line 17, int PORT

When a client is connected server asks for 'NAME', line 65

If client responds with a name, server checks if the name already exists
in names HashSet(line 20) at line 74.

After name has been added successfully, server sends every online client
'JOINED<name>' to notify that a new client has joined, at line 88.

Client sends server command 'USERS' to ask for online user list, server
replies back with 'USERS<name1, name2>', line 107

When a client sends 'MESSAGE<msg> NAME<name>' server sends the same line
to every clients, the string handling is done from client.




Chat CLIENT: Main.java, Chatbox.java, Connection.java, AES.java

Main.java

Consists a GUI with 3 jTextFields[mIP, mPort, mName] and jButton [Connect]
Button assigns public strings [IP, name] and int [port] in Chatbox.java
and calls CallThread(); function from Chatbox.java to connect.

Chatbox.java

SendEncryptedMessage(String msg) //line 24
Send encrypted message to server using format MESSAGE<msg> NAME<name>
SendToSrv(String data) //line 29
Send commands to server such as USERS

Class trycon() //line 251
The client core: Sends to server name, asks for user list
and handles the strings received to show in GUI, such as messages.



Connection.java
Handles connection

AES.java
Edit keyValue, line 10, to set up your own key.
AES.encrypt(string) //returns encrypted string
AES.decrypt(string) //returns decrypted string


