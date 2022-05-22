package com.yaswanth.whatsAppScheduler.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yaswanth.whatsAppScheduler.entities.Client;

@Repository
public class ClientDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public Client getClient(String token) {
		
		
		String query="select * from client where apiToken = ?";
		return jdbc.query(query,new BeanPropertyRowMapper<Client>(Client.class),token).get(0);
		
		
		
		
	}
	
	

}
