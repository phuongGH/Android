package com.demo.weather;

public class DayWeather {
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	private String date;
	private String tempF;
	private String tempC;
	private String humi;
	private String cond;
	private String icon;
	private String day;
	
	public DayWeather() {
		super();
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTempF() {
		return tempF;
	}
	public void setTempF(String tempF) {
		this.tempF = tempF;
	}
	public String getTempC() {
		return tempC;
	}
	public void setTempC(String tempC) {
		this.tempC = tempC;
	}
	public String getHumi() {
		return humi;
	}
	public void setHumi(String humi) {
		this.humi = humi;
	}
	public String getCond() {
		return cond;
	}
	public void setCond(String cond) {
		this.cond = cond;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}


}
