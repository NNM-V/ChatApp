package com.chat.service.dto;

public class OutputMessage {
	private String sender;
	private String text;

	public OutputMessage() {}
	
	public OutputMessage(String sender, String text, String time) {
		this.sender = sender;
		this.text = text;
	}
	
	public String getSender() {
		return sender;
	}
	
	public String getText() {
		return text;
	}
}
