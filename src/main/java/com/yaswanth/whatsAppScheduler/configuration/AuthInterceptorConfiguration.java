package com.yaswanth.whatsAppScheduler.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yaswanth.whatsAppScheduler.interceptor.AuthInterceptor;

//Configuration Class to add Interceptor to the application

@Configuration
public class AuthInterceptorConfiguration implements WebMvcConfigurer {
	@Autowired
	private AuthInterceptor authInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(authInterceptor);
//		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
	

}
