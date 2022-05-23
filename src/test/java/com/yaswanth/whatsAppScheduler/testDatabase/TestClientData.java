package com.yaswanth.whatsAppScheduler.testDatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yaswanth.whatsAppScheduler.dao.ClientDao;
import com.yaswanth.whatsAppScheduler.entities.Client;


@SpringBootTest
public class TestClientData {
	@MockBean
	ClientDao clientDao;
	
	
	@Test
	public void getClientWithInvalidToken() {
		
		Client actualResult=null;
		try {
			clientDao.getClient("Some Invalid Token");
			assertThat(actualResult).isEqualTo(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testClientWithValidToken() {
		Client expectedResult=new Client(1,"Yaswanth","testtoken");
		try {
			Client actualResult=clientDao.getClient("testtoken");
			assertThat(actualResult.toString()).isEqualTo(expectedResult.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
