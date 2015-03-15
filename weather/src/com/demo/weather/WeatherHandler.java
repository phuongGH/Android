package com.demo.weather;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.R.integer;

public class WeatherHandler extends DefaultHandler {


	public String getMSN_Img() {
		return MSN_Img;
	}

	public ArrayList<DayWeather> getDws() {
		return dws;
	}

	DayWeather dw;
	ArrayList<DayWeather> dws = new ArrayList<DayWeather>();
	private String MSN_Img = "";
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(localName.equals("weather")){
			this.MSN_Img = (attributes.getValue("imagerelativeurl"));
		}
		String data = "";
		
		
		if(localName.equals("current")){
			dw = new DayWeather();
			dw.setDate(attributes.getValue("date"));
			dw.setDay(attributes.getValue("day"));
			dw.setTempF( attributes.getValue("temperature"));
			dw.setHumi("humidity: " + attributes.getValue("humidity") +"%");
			dw.setCond("skytext: " + attributes.getValue("skytext"));
			dw.setIcon(attributes.getValue("skycode")+".gif");
			dw.setTempC(tempFToC(dw.getTempF()));
			dws.add(dw);
		}
		else {
			if(localName.equals("forecast")){
				dw = new DayWeather();
				dw.setDate(attributes.getValue("date"));
				dw.setDay(attributes.getValue("day"));
				dw.setTempF(attributes.getValue("high"));
				dw.setHumi("0");
				dw.setCond(attributes.getValue("skytextday"));
				dw.setIcon(attributes.getValue("skycodeday")+".gif");
				dw.setTempC(tempFToC(dw.getTempF()));
				dws.add(dw);
			}
		}
			
	}
	
	private String tempFToC(String tempF){
		int tf = Integer.valueOf(tempF);
		return "temperature: " + String.valueOf(Math.round((tf-32)/1.8)) +"°C";
	}
	
	

}
