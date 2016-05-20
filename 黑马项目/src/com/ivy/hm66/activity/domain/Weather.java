package com.ivy.hm66.activity.domain;

public class Weather {
	String temp;
	String name;
	String pm25;
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPm25() {
		return pm25;
	}
	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}
	@Override
	public String toString() {
		return "Weather [temp=" + temp + ", name=" + name + ", pm25=" + pm25
				+ "]";
	}
	
}
