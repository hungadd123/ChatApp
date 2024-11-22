/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap14_chatroom_server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hunga
 */
public class ClientCommunicateThreadMain extends Thread{
    Client thisClient;


	public ClientCommunicateThreadMain(Socket clientSocket) {
		try {
			thisClient = new Client();
			thisClient.socket = clientSocket;
			OutputStream os = clientSocket.getOutputStream();
			thisClient.sender = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
			InputStream is = clientSocket.getInputStream();
			thisClient.receiver = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			thisClient.port = clientSocket.getPort();
		} catch (IOException e) {

		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				String header = thisClient.receiver.readLine();
				if (header == null)
					throw new IOException();

				System.out.println("Header: " + header);
				switch (header) {

				case "new login": {

					String clientUsername = thisClient.receiver.readLine();

					boolean userNameExisted = false;
                                        
                                           for (Client connectedClient : Main.chatserver.connectedClient) {
						if (connectedClient.userName.equals(clientUsername)) {
							userNameExisted = true;
							break;
						}
					
                                        }
					

					if (!userNameExisted) {
						thisClient.userName = clientUsername;
                                                
						Main.chatserver.connectedClient.add(thisClient);
						Main.mainScreen.updateClientTable1();

						thisClient.sender.write("login success");
						thisClient.sender.newLine();
						thisClient.sender.flush();

						thisClient.sender.write("" + (Main.chatserver.connectedClient.size() - 1));
						thisClient.sender.newLine();
						thisClient.sender.flush();
						for (Client client : Main.chatserver.connectedClient) {
							if (client.userName.equals(thisClient.userName))
								continue;
							thisClient.sender.write(client.userName);
							thisClient.sender.newLine();
							thisClient.sender.flush();
						}

						for (Client client : Main.chatserver.connectedClient) {
							if (client.userName.equals(thisClient.userName))
								continue;
							client.sender.write("new user online");
							client.sender.newLine();
							client.sender.write(thisClient.userName);
							client.sender.newLine();
							client.sender.flush();
						}
					} else {
						thisClient.sender.write("login failed");
						thisClient.sender.newLine();
						thisClient.sender.flush();
					}
					break;
				}

				case "get name": {
					thisClient.sender.write(Main.chatserver.serverName);
					thisClient.sender.newLine();
					thisClient.sender.flush();
					break;
				}

				case "get connected count": {
					thisClient.sender.write("" + Main.chatserver.connectedClient.size());
					thisClient.sender.newLine();
					thisClient.sender.flush();
					break;
				}

				case "request create room": {
					String roomName = thisClient.receiver.readLine();
					String roomType = thisClient.receiver.readLine();
					int userCount = Integer.parseInt(thisClient.receiver.readLine());
					List<String> users = new ArrayList<String>();
					for (int i = 0; i < userCount; i++)
						users.add(thisClient.receiver.readLine());

					Room newRoom = new Room(roomName, users);
					Main.chatserver.allRooms.add(newRoom);

					for (int i = 0; i < userCount; i++) {
						BufferedWriter currentClientSender = Client.findClient(Main.chatserver.connectedClient,
								users.get(i)).sender;
						currentClientSender.write("new room");
						currentClientSender.newLine();
						currentClientSender.write("" + newRoom.id);
						currentClientSender.newLine();
						currentClientSender.write(thisClient.userName);
						currentClientSender.newLine();
						if (roomType.equals("private")) {
							// private chat thì tên room của mỗi người sẽ là tên của người kia
							currentClientSender.write(users.get(1 - i)); // user 0 thì gửi 1, user 1 thì gửi 0
							currentClientSender.newLine();
						} else {
							currentClientSender.write(roomName);
							currentClientSender.newLine();
						}
						currentClientSender.write(roomType);
						currentClientSender.newLine();
						currentClientSender.write("" + users.size());
						currentClientSender.newLine();
						for (String userr : users) {
							currentClientSender.write(userr);
							currentClientSender.newLine();
						}
						currentClientSender.flush();
					}
					break;
				}

				case "text to room": {
					int roomID = Integer.parseInt(thisClient.receiver.readLine());
					String content = "";
					char c;
					do {
						c = (char) thisClient.receiver.read();
						if (c != '\0')
							content += c;
					} while (c != '\0');

					Room room = Room.findRoom(Main.chatserver.allRooms, roomID);
					for (String user : room.users) {
						System.out.println("Send text from " + thisClient.userName + " to " + user);
						Client currentClient = Client.findClient(Main.chatserver.connectedClient, user);
						if (currentClient != null) {
							currentClient.sender.write("text from user to room");
							currentClient.sender.newLine();
							currentClient.sender.write(thisClient.userName);
							currentClient.sender.newLine();
							currentClient.sender.write("" + roomID);
							currentClient.sender.newLine();
							currentClient.sender.write(content);
							currentClient.sender.write('\0');
							currentClient.sender.flush();
						}
					}
					break;
				}

				case "file to room": {
					int roomID = Integer.parseInt(thisClient.receiver.readLine());
					int roomMessagesCount = Integer.parseInt(thisClient.receiver.readLine());
					String fileName = thisClient.receiver.readLine();
					int fileSize = Integer.parseInt(thisClient.receiver.readLine());

					File filesFolder = new File("files");
					if (!filesFolder.exists())
						filesFolder.mkdir();

					int dotIndex = fileName.lastIndexOf('.');
					String saveFileName = "files/" + fileName.substring(0, dotIndex)
							+ String.format("%02d%03d", roomID, roomMessagesCount) + fileName.substring(dotIndex);

					File file = new File(saveFileName);
					byte[] buffer = new byte[1024];
					InputStream in = thisClient.socket.getInputStream();
					OutputStream out = new FileOutputStream(file);

					int receivedSize = 0;
					int count;
					while ((count = in.read(buffer)) > 0) {
						out.write(buffer, 0, count);
						receivedSize += count;
						if (receivedSize >= fileSize)
							break;
					}

					out.close();

					Room room = Room.findRoom(Main.chatserver.allRooms, roomID);
					for (String user : room.users) {
						Client currentClient = Client.findClient(Main.chatserver.connectedClient, user);
						if (currentClient != null) {
							currentClient.sender.write("file from user to room");
							currentClient.sender.newLine();
							currentClient.sender.write(thisClient.userName);
							currentClient.sender.newLine();
							currentClient.sender.write("" + roomID);
							currentClient.sender.newLine();
							currentClient.sender.write(fileName);
							currentClient.sender.newLine();
							currentClient.sender.flush();
						}
					}
					break;
				}

				

				case "request download file": {
					try {
						int roomID = Integer.parseInt(thisClient.receiver.readLine());
						int messageIndex = Integer.parseInt(thisClient.receiver.readLine());
						String fileName = thisClient.receiver.readLine();

						int dotIndex = fileName.lastIndexOf('.');
						fileName = "files/" + fileName.substring(0, dotIndex)
								+ String.format("%02d%03d", roomID, messageIndex) + fileName.substring(dotIndex);
						File file = new File(fileName);

						thisClient.sender.write("response download file");
						thisClient.sender.newLine();
						thisClient.sender.write("" + file.length());
						thisClient.sender.newLine();
						thisClient.sender.flush();

						byte[] buffer = new byte[1024];
						InputStream in = new FileInputStream(file);
						OutputStream out = thisClient.socket.getOutputStream();

						int count;
						while ((count = in.read(buffer)) > 0) {
							out.write(buffer, 0, count);
						}

						in.close();
						out.flush();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					break;
				}

				}
			}

		} catch (IOException e) {
			if (/*Main.chatserver.serverSocket.isClosed() &&*/ thisClient.userName != null) {

				try {
					for (Client client :Main.chatserver.connectedClient) {
						if (!client.userName.equals(thisClient.userName)) {
							client.sender.write("user quit");
							client.sender.newLine();
							client.sender.write(thisClient.userName);
							client.sender.newLine();
							client.sender.flush();
						}
					}

					for (Room room : Main.chatserver.allRooms)
						room.users.remove(thisClient.userName);

					thisClient.socket.close();

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Main.chatserver.connectedClient.remove(thisClient);
				Main.mainScreen.updateClientTable1();
			}
		}
	}
}
