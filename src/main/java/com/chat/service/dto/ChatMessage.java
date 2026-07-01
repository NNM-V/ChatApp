package com.chat.service.dto;
import lombok.Data;

@Data
public class ChatMessage{
	private	String sender;
	private	String receiver;
	private String text;
}
