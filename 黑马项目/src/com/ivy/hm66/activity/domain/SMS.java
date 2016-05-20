package com.ivy.hm66.activity.domain;

/**
 * 
 * 短信的业务Bean
 */
public class SMS {
	private String id;
	private String time;
	private String body;
	private String address;
	private String type;
	public SMS(String id, String time, String body, String address, String type) {
		super();
		this.id = id;
		this.time = time;
		this.body = body;
		this.address = address;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
