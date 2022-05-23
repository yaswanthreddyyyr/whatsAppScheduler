package com.yaswanth.whatsAppScheduler;




import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.yaswanth.whatsAppScheduler.timer.CustomTimerTask;

//import com.yaswanth.whatsAppScheduler.service.TimerService;


@SpringBootApplication
public class WhatsAppSchedulerApplication {
	
	public Timer timer =new Timer();
	
	@Autowired
	public CustomTimerTask task;
	
	public static void main(String[] args) {
		SpringApplication.run(WhatsAppSchedulerApplication.class, args);
		
//		TimerService timerService =new TimerService();
		
	
//		timerService.callTaskWithFixedDelay();
		
	}
	@EventListener(ApplicationReadyEvent.class)
	public void startScheduling() {
		timer.schedule(task,60000,120000);
	}
	
	

}
