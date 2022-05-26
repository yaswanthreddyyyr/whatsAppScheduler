package com.yaswanth.whatsAppScheduler.dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yaswanth.whatsAppScheduler.entities.Client;
import com.yaswanth.whatsAppScheduler.entities.Message;
import com.yaswanth.whatsAppScheduler.entities.Request;


//Repository Class for Message

@Repository
public class MessageDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
	//Method to insert a new message into database
	public int save(Request requestBody,Client client) throws SQLException{
		int result=0;
		String query="insert into message(clientId,message,destinationPhone,messageStatus,scheduleTime,gupshupMessageId) values (?,?,?,?,?,?)";
		try {
			result=jdbc.update(query,client.getClientId(),requestBody.getMessage(),requestBody.getDestinationPhone(),0,requestBody.getScheduleTime(),null);
			return result;
		}
		catch(Exception e){
			
			throw new SQLException("Error while Inserting Data");
			
		}
		
		
		
	}
	
	//Method to get all messages with time less than current time
	
	public List<Message> getScheduledMessages() throws SQLException{
		
		String query="select * from message where scheduleTime < now() and messageStatus=0";
		List<Message> messages=Collections.emptyList();
		
		try {
			messages=jdbc.query(query, new BeanPropertyRowMapper<Message>(Message.class));
			
			return messages;
			
		}
		catch(Exception e) {
			throw new SQLException("Error while polling");
		}
		
		
		
	}
	
	//Method to update the status of the message
	public int updateStatus(int messageStatus,String gupshupMessageId,long messageId) throws Exception{
		
		String query="update message set messageStatus=?,gupshupMessageId=? where messageId=?";
		int result=0;
		try {
			result=jdbc.update(query,messageStatus,gupshupMessageId,messageId);
			System.out.println("Updated Status Successfully");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	

}
