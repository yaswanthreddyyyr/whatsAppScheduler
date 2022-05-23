package com.yaswanth.whatsAppScheduler.timer;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yaswanth.whatsAppScheduler.entities.Message;
import com.yaswanth.whatsAppScheduler.service.MessageService;

@Component
public class CustomTimerTask extends TimerTask {
	
	@Autowired
MessageService msgService;
	
	public static String encodeParam(String data) {
		String result = "";
		try {
			result = URLEncoder.encode(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static byte[] getParamsByte(Map<String, Object> params) {
		byte[] result = null;
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (postData.length() != 0) {
				postData.append('&');
			}
			postData.append(encodeParam(param.getKey()));
			postData.append('=');
			postData.append(encodeParam(String.valueOf(param.getValue())));
		}
		try {
			result = postData.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		

		List<Message> messages=Collections.emptyList();
		try {
//			msgService.dummy();
			messages=msgService.getScheduledMessages();
//			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(messages.isEmpty()) {
			System.out.println("No Messages To Send");
			return;
		}
		Gson gson=new Gson();
		URL url = null;
		HttpURLConnection connection =null;
		
		for(Message message:messages) {
			
			System.out.println("Executing message with message ID = "+message.getMessageId());
			
			try {
				url = new URL("https://api.gupshup.io/sm/api/v1/msg");
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setUseCaches(false);
				connection.setDoInput(true);
				connection.setDoOutput(true);
				
				//Add Headers
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				connection.setRequestProperty("apikey", "re8ebijsyveg4wih4ziz1ysuulwyg3oi");
				connection.setRequestProperty("Accept", "application/json");
				
				OutputStream outputStream = connection.getOutputStream();
				
				HashMap<String, String> msg = new HashMap<String, String>();
				msg.put("type", "text");
				msg.put("text", message.getMessage());
				
				//Convert Message to JSON
				String jsonString = gson.toJson(msg);
				JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
				
				Map<String, Object> requestBody = new HashMap<>();
				requestBody.put("channel", "whatsapp");
				requestBody.put("source", "917834811114");
				requestBody.put("destination", message.getDestinationPhone());
				requestBody.put("message", jsonObject);
				requestBody.put("src.name", "whatsAppScheduler");
				
				//Adding body to Output Stream
				
				outputStream.write(getParamsByte(requestBody));
				System.out.println("outputstream ------> " + outputStream.toString());
				System.out.println(" response code here  -----> " + connection.getResponseCode());
				
				if(connection.getResponseCode() == HttpURLConnection.HTTP_ACCEPTED) {
					ObjectMapper objectMapper = new ObjectMapper();
					
					@SuppressWarnings("unchecked")
					Map<String,String> response = objectMapper.readValue(connection.getInputStream(),Map.class);
					System.out.println("Gupshup Message Id is ---> " + response.get("messageId"));
					System.out.println(response.toString());
					
					int queryResult = msgService.updateStatus(1, response.get("messageId"), message.getMessageId());
					if(queryResult < -1) {
						System.out.println("Message Update Failed for message id "+ message.getMessageId());
						
					}
					else {
						System.out.println("Message Updated Succesfully");
					}
					
				}
				else {
					System.out.println("Message Failed of Id"+ message.getMessageId());
					@SuppressWarnings("unused")
					int queryResult = msgService.updateStatus(-1,null, message.getMessageId());
					
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	

}
