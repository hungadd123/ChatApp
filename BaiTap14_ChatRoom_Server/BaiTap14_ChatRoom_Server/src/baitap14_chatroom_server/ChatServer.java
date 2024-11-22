/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap14_chatroom_server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Desktop
 */
public class ChatServer {
    ServerSocket serverSocket;
    public String serverName ="";
    public List<Client> connectedClient ;
    public List<Room> allRooms;
    public List<ClientHandler> clients = new ArrayList<>();
    public int port;
    List<String> availablePortsList = new ArrayList<>();
    

    public void startServer() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of ports to listen to:");
        int numberOfPorts = scanner.nextInt();
        
        
        for (int i = 0; i < numberOfPorts; i++) {
            System.out.println("Enter port number " + (i + 1) + ":");
            int port = scanner.nextInt();
            
            startServerThread(port);
            availablePortsList.add(Integer.toString(port));
        }
        
        scanner.close();
    }
    
    public void startMainServer(){
        startServerThread(8888);
    }

    public void startServerThread(int port) {
//        try {
//            ServerSocket serverSocket = new ServerSocket(port);
//            System.out.println("Server started. Listening on port: " + port);
//
//            while (true) {
//                Socket clientSocket = serverSocket.accept();
//                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
//
//                ClientHandler clientHandler = new ClientHandler(clientSocket, System.currentTimeMillis() + "", this);
//                clients.add(clientHandler);
//                new Thread(clientHandler).start();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//            new Thread(() -> {
//                       try {
//                           serverSocket = new ServerSocket(port);
//                           System.out.println("Server started. Listening on port: " + port);
//                           
//                            
//                           while (true) {
//                               Socket clientSocket = serverSocket.accept();
//                               System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
//                               DataOutputStream dataOutput = new DataOutputStream(clientSocket.getOutputStream());
//                                String availablePorts = String.join(" ", availablePortsList);
//                                dataOutput.writeUTF(availablePorts);
//                               
//                               ClientHandler clientHandler = new ClientHandler(clientSocket, System.currentTimeMillis() + "", this);
//                               clients.add(clientHandler);
//                               new Thread(clientHandler).start();
//                           }
//                       } catch (Exception e) {
//                           e.printStackTrace();
//                       }
//                   }).start();  
            
            try {
			serverSocket = new ServerSocket(port);
			
			

			new Thread(() -> {
				try {
                                    connectedClient = new ArrayList<Client>();
                                    allRooms = new ArrayList<Room>();    
					do {
						System.out.println("Waiting for client");

						Socket clientSocket = serverSocket.accept();

						ClientCommunicateThreadMain clientCommunicator = new ClientCommunicateThreadMain(clientSocket);
						clientCommunicator.start();

					} while (serverSocket != null && !serverSocket.isClosed());
				} catch (IOException e) {
					System.out.println("Server or client socket closed");
				}
			}).start();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void broadcastMessage(String id, String message) {
        for (ClientHandler client : clients) {
            if (!(client.getId().equals(id))){
                    client.sendMessage(id + " : " + message);
            }
                
        }
    }
    public void sendMessageToPort(String senderPort, String message, String id) {
        for (ClientHandler client : clients) {
            if (client.getPort().equals(senderPort) && !(client.getId().equals(id)))  {
                // Send the message to the client
                client.sendMessage( id + " : " + message);
            }
        }
    }
    
    public String getIPAddress() throws UnknownHostException{
        InetAddress ad = InetAddress.getLocalHost();
        byte[] s = ad.getAddress();
        String a ="";
        for(int j=0;j<s.length;j++){
            if(j>0){
                a+=".";
            }
            a+= s[j]&0xFF;
        }
        return a;
    }
    
    public void CloseSocket() {
		try {
			for (ClientHandler client : clients)
				client.mySocket.close();
                        serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    void updateClientTable() {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
