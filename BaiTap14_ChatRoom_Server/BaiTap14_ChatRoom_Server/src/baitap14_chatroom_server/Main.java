/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap14_chatroom_server;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hunga
 */
public class Main {
        public static ChatServer chatserver;
	public static frmServer mainScreen;

	public static void main(String[] args) {
        try {
            mainScreen = new frmServer();
            mainScreen.setVisible(true);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

	}
}
