package com.yaswanth.whatsAppScheduler.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

	public boolean validatePhone(String phone) {
		
		if(phone.length()!=12)
			return false;
		if(phone.charAt(0)!='9' || phone.charAt(1)!='1')
			return false;
		if(phone.charAt(2)!='9' && phone.charAt(2)!='8' && phone.charAt(2)!='7' && phone.charAt(2)!='6')
			return false;
		
		return true;
	}
	
	public boolean validateDateAndTime(String dateAndTime) {
		//Date and Time Format  ----- YYYY-MM-DD HH24:MI:SS
		 SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd HH:mm");
		 String strToday=formatter.format(new Date());
		 try {
			Date today =new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(strToday);
			Date scheduleDate=new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(dateAndTime);
			if(today.compareTo(scheduleDate)>0) {
				System.out.println("Invalid Date");
				return false;
			}
			return true;
		}
		catch(ParseException e) {
			e.printStackTrace();
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
