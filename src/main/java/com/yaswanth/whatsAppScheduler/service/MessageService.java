package com.yaswanth.whatsAppScheduler.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaswanth.whatsAppScheduler.dao.MessageDao;
import com.yaswanth.whatsAppScheduler.entities.Client;
import com.yaswanth.whatsAppScheduler.entities.Message;
import com.yaswanth.whatsAppScheduler.entities.Request;

//Message Service to communicate with mesageDao

@Service
public class MessageService {
	
	@Autowired
	MessageDao msgDao;
	
	public int saveMessage(Request  requestbody,Client client) throws SQLException {
	
		return msgDao.save(requestbody, client);
		
		
	}
	
	
	public List<Message> getScheduledMessages() throws SQLException{
		return msgDao.getScheduledMessages();
	}
	
	public int updateStatus(int messageStatus,String gupshupMessageId,long messageId) throws Exception {
		
		
		return msgDao.updateStatus(messageStatus, gupshupMessageId, messageId);
		
	}

}
