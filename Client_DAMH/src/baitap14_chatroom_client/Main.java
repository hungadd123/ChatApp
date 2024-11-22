/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap14_chatroom_client;

/**
 *
 * @author Desktop
 */
import java.awt.Image;

import javax.swing.ImageIcon;

public class Main {

	public static frmClient connectServerScreen;
	public static Chatfrm mainScreen;
	public static SocketController socketController;

	public static void main(String arg[]) {
		connectServerScreen = new frmClient();
                connectServerScreen.setVisible(true);
	}

	public static ImageIcon getScaledImage(String path, int width, int height) {
		Image img = new ImageIcon(Main.class.getResource(path)).getImage();
		Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}
}
