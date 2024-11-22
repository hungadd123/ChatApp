/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap14_chatroom_server;

import java.util.List;

/**
 *
 * @author hunga
 */
class Room {
    public static int currentRoomID = 1;

	public int id;
	public String name;
	public List<String> users;

	public Room(String name, List<String> users) {
		this.id = currentRoomID++;
		this.name = name;
		this.users = users;
	}

	public static Room findRoom(List<Room> roomList, int id) {
		for (Room room : roomList)
			if (room.id == id)
				return room;
		return null;
	}
}
