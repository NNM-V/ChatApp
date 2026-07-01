package com.chat.service.dto;

public class OutputMessage {
	private String sender;
	private String text;

	public OutputMessage() {}
	
	public OutputMessage(String sender, String text) {
		this.sender = sender;
		this.text = text;
	}
	
	public String getSender() {
		System.out.println(sender);
		return sender;
	}
	
	public String getText() {
		System.out.println(text);
		return text;
	}
}
