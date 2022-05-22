package com.yaswanth.whatsAppScheduler.entities;



public class Client {
	
	private long clientId;
	private String clientName;
	private String apiToken;
	public long getClientId() {
		return clientId;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(long clientId, String clientName, String apiToken) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.apiToken = apiToken;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getApiToken() {
		return apiToken;
	}
	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", apiToken=" + apiToken + "]";
	}
	
	
	

}
