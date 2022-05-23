package com.yaswanth.whatsAppScheduler.testServices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yaswanth.whatsAppScheduler.dao.ClientDao;
import com.yaswanth.whatsAppScheduler.entities.Client;
import com.yaswanth.whatsAppScheduler.service.AuthService;

@SpringBootTest
public class TestAuthService {
	@Autowired
	AuthService authService;
	
	@MockBean
	ClientDao clientDao;
	@Test
	public void autheenticateWithValidToken() {
		Client expected=new Client(1,"Yaswanth","testtoken");
		when(clientDao.getClient("testtoken")).thenReturn(expected);
		assertThat(authService.validateToken("testtoken")).isEqualTo(expected);
	}
	
	@Test
	public void authenticateWithInvalidToken() {
		when(clientDao.getClient("Some Invalid or Incorrect Token")).thenReturn(null);
		assertThat(authService.validateToken("Some Invalid or Incorrect Token")).isNull();
		
	}
	
	

}
