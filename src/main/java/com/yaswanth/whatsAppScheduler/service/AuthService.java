package com.yaswanth.whatsAppScheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaswanth.whatsAppScheduler.dao.ClientDao;
import com.yaswanth.whatsAppScheduler.entities.Client;

@Service
public class AuthService {
	@Autowired
	ClientDao clientdao;
	
	public Client validateToken(String token) {
		
		Client client=clientdao.getClient(token);
		
		return client;
		
		
	}
	
	

}
