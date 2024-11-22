/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap14_chatroom_client;

/**
 *
 * @author sheam
 */
public class ServerData {
    	public String ip;
	public int port;
	public boolean isOpen;
	public int connectAccountCount;

	public ServerData(String ip, int port) {
		
		this.ip = ip;
		this.port = port;
		this.isOpen = false;
		this.connectAccountCount = 0;
	}

	public ServerData(String ip, int port, boolean isOpen, int connectAccountCount) {
		this.ip = ip;
		this.port = port;
		this.isOpen = isOpen;
		this.connectAccountCount = connectAccountCount;
	}
         public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

}
