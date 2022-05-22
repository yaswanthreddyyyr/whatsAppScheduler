package com.yaswanth.whatsAppScheduler.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.yaswanth.whatsAppScheduler.entities.Client;
import com.yaswanth.whatsAppScheduler.entities.Response;
import com.yaswanth.whatsAppScheduler.service.AuthService;


@Component
public class AuthInterceptor implements HandlerInterceptor{
	@Autowired
	AuthService authService;


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("In Interceptor");
		Gson gson = new Gson();
		Response res=new Response();
		
		try {
			String token=request.getHeader("token");
			System.out.println("Token ----> "+token);
			if(token==null) {
				response.setContentType("application/json");
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				
				res.setResponseCode(401);
				res.setResponseMessage("Unauthorized");
				response.getWriter().write(gson.toJson(res));
				return false;
			}
			
			Client client=authService.validateToken(token);
			if(client==null ) {
				response.setContentType("application/json");
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				res.setResponseCode(401);
				res.setResponseMessage("Unauthorized");
				response.getWriter().write(gson.toJson(res));

				
				return false;
				
			}
			else {
				request.setAttribute("client", client);
				System.out.println("Client ----> "+client);
				return true;
			}
		}
			catch(Exception e) {
				response.setContentType("application/json");
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				res.setResponseCode(401);
				res.setResponseMessage("Unauthorized");
				response.getWriter().write(gson.toJson(res));
				
				return false;
			}
		}
		
		
		
		
		
	

	
	
	
	

}
