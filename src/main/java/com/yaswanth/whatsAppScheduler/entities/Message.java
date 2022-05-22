package com.yaswanth.whatsAppScheduler.entities;

import org.springframework.stereotype.Component;

@Component
public class Message {
	
	private long messageId;
	private long clientId;
	private String message;
	private String destinationPhone;
	private int messageStatus;
	private String scheduleTime;
	private String gupshupMessageId;
	public long getMessageId() {
		return messageId;
	}
	public Message(long messageId, long clientId, String message, String destinationPhone, int messageStatus,
			String scheduleTime, String gupshupMessageId) {
		super();
		this.messageId = messageId;
		this.clientId = clientId;
		this.message = message;
		this.destinationPhone = destinationPhone;
		this.messageStatus = messageStatus;
		this.scheduleTime = scheduleTime;
		this.gupshupMessageId = gupshupMessageId;
		
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", clientId=" + clientId + ", message=" + message
				+ ", destinationPhone=" + destinationPhone + ", messageStatus=" + messageStatus + ", scheduleTime="
				+ scheduleTime + ", gupshupMessageId=" + gupshupMessageId + "]";
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDestinationPhone() {
		return destinationPhone;
	}
	public void setDestinationPhone(String destinationPhone) {
		this.destinationPhone = destinationPhone;
	}
	public int getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(int messageStatus) {
		this.messageStatus = messageStatus;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public String getGupshupMessageId() {
		return gupshupMessageId;
	}
	public void setGupshupMessageId(String gupshupMessageId) {
		this.gupshupMessageId = gupshupMessageId;
	}



}
