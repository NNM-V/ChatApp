package com.chat.service.dto;
import lombok.Data;

@Data
public class ChatMessage{
	private	String sender;
	private String text;
	private String receiver;
}
