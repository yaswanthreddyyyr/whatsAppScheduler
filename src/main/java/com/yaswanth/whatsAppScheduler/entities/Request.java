package com.yaswanth.whatsAppScheduler.entities;

import javax.validation.constraints.NotEmpty;


//Entity for Request Format

public class Request {
	
	@NotEmpty(message="Message Cannot be Null")
	private String message;
	
	@NotEmpty(message="Phone Number Cannot be Null")
	private String destinationPhone;
	
	@NotEmpty(message="Schedule Time Cannot be Null")
	
	private String scheduleTime;
	
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
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	
	
	public Request(String message, String destinationPhone, String scheduleTime) {
		super();
		this.message = message;
		this.destinationPhone = destinationPhone;
		this.scheduleTime = scheduleTime;
		
	}
	@Override
	public String toString() {
		return "Request [message=" + message + ", destinationPhone=" + destinationPhone + ", scheduleTime="
				+ scheduleTime + "]";
	}
	

}
