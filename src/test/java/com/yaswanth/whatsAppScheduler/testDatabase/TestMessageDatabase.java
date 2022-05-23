package com.yaswanth.whatsAppScheduler.testDatabase;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yaswanth.whatsAppScheduler.dao.MessageDao;
import com.yaswanth.whatsAppScheduler.entities.Client;
import com.yaswanth.whatsAppScheduler.entities.Request;

@SpringBootTest
public class TestMessageDatabase {
	
	@Autowired
	MessageDao messageDao;
	
	@Test
	public void testInsert() throws SQLException  {
		
		Client tempClient=new Client(1,"Yaswanth","testtoken"); 
		Request request =new Request("Test Message", "918688721990", "2022/05/27 09:10");
		
		assertThat(messageDao.save(request, tempClient)).isEqualTo(1);
		
	}
	@Test
	public void testUpdate() throws Exception {
		assertThat(messageDao.updateStatus(1, "Some String", 50)).isEqualTo(1);
	}
	
	
	
}
