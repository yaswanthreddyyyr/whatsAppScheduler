package com.yaswanth.whatsAppScheduler.testServices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yaswanth.whatsAppScheduler.dao.MessageDao;
import com.yaswanth.whatsAppScheduler.entities.Client;
import com.yaswanth.whatsAppScheduler.entities.Message;
import com.yaswanth.whatsAppScheduler.entities.Request;
import com.yaswanth.whatsAppScheduler.service.MessageService;

@SpringBootTest
public class TestMessageService {
	@Autowired
	MessageService messageService;
	
	@MockBean
	MessageDao messageDao;
	
	@Test
	public void testSaveMessages() throws SQLException{
		
		Client tempClient=new Client(1,"Yaswanth","testtoken"); 
		Request request =new Request("Test Message", "918688721990", "2022/05/27 09:10");
		when(messageDao.save(request, tempClient)).thenReturn(1);
		
		int actualValue=messageService.saveMessage(request, tempClient);
		assertThat(actualValue).isEqualTo(1);
		
		
	}
	
	@Test
	public void testUpdateMessageService() throws Exception{
		
		when(messageDao.updateStatus(1, "Some messageId", 50)).thenReturn(1);
		int actualValue=messageService.updateStatus(1, "Some messageId", 50);
		assertThat(actualValue).isEqualTo(1);
		
	}
	
	@Test
	public void testgetScheduledMessageService() throws SQLException{
		List<Message>  expectedList =Collections.emptyList();
		when(messageDao.getScheduledMessages()).thenReturn(expectedList);
		List<Message>actualList = messageService.getScheduledMessages();
		assertThat(expectedList).isEqualTo(actualList);
		
	}

}
