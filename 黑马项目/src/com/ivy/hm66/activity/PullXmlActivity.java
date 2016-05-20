package com.ivy.hm66.activity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.TextView;

import com.ivy.hm66.R;
import com.ivy.hm66.activity.domain.Weather;

/**
 * 演示 Pull解析XMl  界面
 * @author Ivy
 */
public class PullXmlActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_pullxml);
	}
	
	public void pull(View v){
		
		ArrayList<Weather> list = null;
		//把放在src根目录下面的weather.xml读出来
		InputStream is = getClassLoader().getResourceAsStream("weather.xml");
		XmlPullParser parser = Xml.newPullParser();
		try {
			parser.setInput(is, "utf-8");
			int type = parser.getEventType();
			System.out.println(type);
			Weather weather = null;
			while(type!=XmlPullParser.END_DOCUMENT){
				
				switch (type) {
				case XmlPullParser.START_TAG:
					if("weather".equals(parser.getName())){
						list = new ArrayList<Weather>();
					}else if("city".equals(parser.getName())){
						weather = new Weather();
					}else if("name".equals(parser.getName())){
						weather.setName(parser.nextText());
					}else if("temp".equals(parser.getName())){
						weather.setTemp(parser.nextText());
					}else if("pm25".equals(parser.getName())){
						weather.setPm25(parser.nextText());
					}
					break;
				case XmlPullParser.END_TAG:
					if("city".equals(parser.getName())){
						list.add(weather);
					}
					break;
				}
				type = parser.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("--------------");
		
		
		StringBuffer sb = new StringBuffer();
		for (Weather weather : list) {
			System.out.println(weather);
			sb.append(weather+"\n");
		}
		
		TextView tvResult = (TextView) findViewById(R.id.tv_result);
		tvResult.setText(sb.toString());
	}
}
