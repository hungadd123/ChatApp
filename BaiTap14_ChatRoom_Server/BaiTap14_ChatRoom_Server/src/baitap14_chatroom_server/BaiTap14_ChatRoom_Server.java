/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap14_chatroom_server;

import java.io.IOException;

/**
 *
 * @author Desktop
 */
public class BaiTap14_ChatRoom_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer();
        chatServer.startServer();
    }
    
}
