package com.yaswanth.whatsAppScheduler.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
	
	
	private int parseHour(String dateAndTime) {
		String hour="";
		for(int i=0;i<dateAndTime.length();i++) {
			char c=dateAndTime.charAt(i);
			if(c==' ') {
				hour=hour+dateAndTime.charAt(i+1);
				if(dateAndTime.charAt(i+2)!=':') {
					hour=hour+dateAndTime.charAt(i+2);
				}
			}
			
		}
		
		return Integer.parseInt(hour);
	}
	
	private int parseMinute(String dateAndTime) {
		String min="";
		if(dateAndTime.charAt(dateAndTime.length()-2)!=':') {
			min=min+dateAndTime.charAt(dateAndTime.length()-2);
		}
		min=min+dateAndTime.charAt(dateAndTime.length()-1);
		
		return Integer.parseInt(min);
	}

	public boolean validatePhone(String phone) {
		
		if(phone.length()!=12)
			return false;
		if(phone.charAt(0)!='9' || phone.charAt(1)!='1')
			return false;
		if(phone.charAt(2)!='9' && phone.charAt(2)!='8' && phone.charAt(2)!='7' && phone.charAt(2)!='6')
			return false;
		
		return true;
	}
	

	public boolean validateDateAndTime(String dateAndTime) throws Exception  {
		//Date and Time Format  ----- YYYY-MM-DD HH24:MI:SS
		 SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd HH:mm");
		 String strToday=formatter.format(new Date());
		

		 
		 
		 
		 try {
			Date today =new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(strToday);

			int hour=parseHour(dateAndTime);
			int min=parseMinute(dateAndTime);
			if(hour>23 || hour<0) {
				return false;
			}
			if(min>60 || min<0) {
				return false;
			}
			
			Date scheduleDate=new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(dateAndTime);
			
			if(today.compareTo(scheduleDate)>0) {
				System.out.println("Invalid Date");
				return false;
			}
			return true;
		}
		catch(Exception e) {
			
			return false;
		}
		
		
	}
	public boolean validateMessage(String message) {
		if(message.length()==0) {
			System.out.println("Message Can't be Empty");
			return false;
		}
		return true;
	}
}
