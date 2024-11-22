/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap14_chatroom_client;

/**
 *
 * @author sheam
 */
public class MessageData {
	public String whoSend;
	public String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
	public String content;

	public MessageData(String whoSend, String type, String content) {
		this.whoSend = whoSend;
		this.type = type;
		this.content = content;
	}
}