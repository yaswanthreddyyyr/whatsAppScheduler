package com.yaswanth.whatsAppScheduler.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yaswanth.whatsAppScheduler.entities.Client;
import com.yaswanth.whatsAppScheduler.entities.Request;
import com.yaswanth.whatsAppScheduler.entities.Response;
import com.yaswanth.whatsAppScheduler.service.MessageService;
import com.yaswanth.whatsAppScheduler.service.ValidationService;

@RestController
public class Controller {
	@Autowired
	MessageService messageService;
	
	@Autowired
	ValidationService validationService;
	Response res=null;
	

	
	@PostMapping("/schedule")
	public Response messageController(@RequestBody  Request requestBody ,HttpServletRequest request) {
		
		try {
			Client client =(Client) request.getAttribute("client"); 
			if(!validationService.validateMessage(requestBody.getMessage())||!validationService.validatePhone(requestBody.getDestinationPhone()) || !validationService.validateDateAndTime(requestBody.getScheduleTime()) ) {
				res=new Response(403,"Validation Error");
				return res;
			}
			
			int result= messageService.saveMessage(requestBody,client);
			System.out.println("Result = "+result);
			res=new Response(200,"Scheduled Successfully!!!");
			
		}
		catch (Exception e) {
			res=new Response(403,"Validation Error");
			return res;
			
		}
		
		
		return res;
		
	}
}
