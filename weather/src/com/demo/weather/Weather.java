package com.demo.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Weather extends ActionBarActivity implements OnClickListener {

	private ImageView ivCurrent;
	private EditText etLocation;
	private Button btnLocation;
	private TextView lblTemp;
	private TextView lblHumi;
	private TextView lblCond;
	private TextView tvCurdate;
	private TextView tvCurday;
	
	private ImageView ivDay1;
	private ImageView ivDay2;
	private ImageView ivDay3;
	private ImageView ivDay4;
	private ImageView ivDay5;
	
	private final static String MSN = "";
	private final static String MSN_WEATHER = "http://weather.service.msn.com/data.aspx?weasearchstr=";
	
	private void init(){
		ivCurrent = (ImageView) findViewById(R.id.ivCurrent);
		etLocation = (EditText) findViewById(R.id.etLocation);
		btnLocation = (Button) findViewById(R.id.btnLocation);
		lblTemp = (TextView) findViewById(R.id.lblTemp);
		lblHumi = (TextView) findViewById(R.id.lblHumi);
		lblCond = (TextView) findViewById(R.id.lblCond);
		tvCurdate = (TextView) findViewById(R.id.tvDate);
		tvCurday = (TextView) findViewById(R.id.tvDay);
		
		ivDay1 = (ImageView) findViewById(R.id.ivDay1);
		ivDay2 = (ImageView) findViewById(R.id.ivDay2);
		ivDay3 = (ImageView) findViewById(R.id.ivDay3);
		ivDay4 = (ImageView) findViewById(R.id.ivDay4);
		btnLocation.setOnClickListener(this);
		ivDay1.setOnClickListener(this);
		ivDay2.setOnClickListener(this);
		ivDay3.setOnClickListener(this);
		ivDay4.setOnClickListener(this);
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather);
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		/*
		 * if (id == R.id.about) { return true; }
		 */

		switch (id) {
		case R.id.about:
			Intent about = new Intent("android.intent.action.ABOUT");
			startActivity(about);
			break;
		case R.id.settings:
			Intent setting = new Intent("android.intent.action.SETTING");
			startActivity(setting);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onClick(View v) {
		
		String location = etLocation.getText().toString();
		switch (v.getId()) {
		case R.id.btnLocation:
			InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
		    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
			setDayView(location,0);
			break;
		case R.id.ivDay1:
			setDayView(location,0);
			break;
		case R.id.ivDay2:
			setDayView(location,2);
			break;
		case R.id.ivDay3:
			setDayView(location,3);
			break;
		case R.id.ivDay4:
			setDayView(location,4);
			break;
		case R.id.ivDay5:
			setDayView(location,5);
			break;

		default:
			break;
		}
		
	}


	private void setDayView(String location, int index) {
		try {
			URL url = new URL(MSN_WEATHER + location);
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader reader = sp.getXMLReader();
			WeatherHandler handler = new WeatherHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(url.openStream()));
			ArrayList<DayWeather> dws = handler.getDws();
			lblTemp.setText(dws.get(index).getTempC());
			lblHumi.setText(dws.get(index).getHumi());
			tvCurdate.setText(dws.get(index).getDate());
			tvCurday.setText(dws.get(index).getDay());
			lblCond.setText(dws.get(index).getCond());
			System.out.println(handler.getMSN_Img());
			loadIcon(handler.getMSN_Img() ,dws.get(index).getIcon(), ivCurrent);
			loadIcon(handler.getMSN_Img() ,dws.get(1).getIcon(), ivDay1);
			loadIcon(handler.getMSN_Img() ,dws.get(2).getIcon(), ivDay2);
			loadIcon(handler.getMSN_Img() ,dws.get(3).getIcon(), ivDay3);
			loadIcon(handler.getMSN_Img() ,dws.get(4).getIcon(), ivDay4);
			loadIcon(handler.getMSN_Img() ,dws.get(5).getIcon(), ivDay5);
			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
			etLocation.requestFocus();
		}
	}


	private void loadIcon(String msn_Img, String icon, ImageView ivCurrent2) throws MalformedURLException, IOException {
		
		InputStream is = (InputStream) new URL(msn_Img + icon).getContent();
		if(is==null)
		{
			return;
		}
		Drawable drawable = Drawable.createFromStream(is, "weather icon");
		ivCurrent2.setImageDrawable(drawable );
	}


}
