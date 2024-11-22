/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap14_chatroom_server;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Desktop
 */
public class ClientHandler implements Runnable{

    public Socket getMySocket() {
        return mySocket;
    }

   
    public Socket mySocket;
    public ChatServer chatServer;
    public String id ;
    private InputStream input;
    private OutputStream output;

    public ClientHandler(Socket mySocket, String id, ChatServer chatServer) {
        this.mySocket = mySocket;
        this.id = id;
        this.chatServer = chatServer;
        try {
            this.input = mySocket.getInputStream();
            this.output = mySocket.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead= input.read(buffer))!=-1){
                String message = new String(buffer, 0, bytesRead);
                chatServer.sendMessageToPort(Integer.toString(mySocket.getLocalPort()) , message,this.id);
                //chatServer.broadcastMessage(this.id, message);
            }
        } catch (Exception e) {
        }
    }
    
    public void sendMessage(String message){
        try {
            DataOutputStream dataOutput = new DataOutputStream(mySocket.getOutputStream());
            dataOutput.writeUTF(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }
    public String getPort(){
        return  Integer.toString(mySocket.getLocalPort());
    }
   
    
}
