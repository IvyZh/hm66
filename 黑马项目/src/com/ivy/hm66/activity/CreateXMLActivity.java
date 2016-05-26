package com.ivy.hm66.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.xmlpull.v1.XmlSerializer;

import com.ivy.hm66.R;
import com.ivy.hm66.domain.SMS;
import com.ivy.hm66.utils.FileUtil;

import android.app.Activity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;

/**
 * 演示 XXX 界面
 * @author Ivy
 */
public class CreateXMLActivity extends Activity {

	private ArrayList<SMS> smsList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_createxml);
		

		smsList = new ArrayList<SMS>();
		for (int i = 0; i < 10; i++) {
			SMS sms = new SMS(i+"", System.currentTimeMillis()+"", "测试短信"+i, "10086-"+i, (i%2+1)+"");
			smsList.add(sms);
		}
		
	}
	
	public void backup(View v){
		System.out.println("backup...");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<smss>");
		
		for (SMS sms : smsList) {
			sb.append("<sms>");
			
			sb.append("<body>");
			sb.append(sms.getBody());
			sb.append("</body>");
			
			sb.append("<type>");
			sb.append(sms.getType());
			sb.append("</type>");
			
			sb.append("<time>");
			sb.append(sms.getTime());
			sb.append("</time>");
			
			sb.append("<address>");
			sb.append(sms.getAddress());
			sb.append("</address>");
			
			sb.append("</sms>");
		}
		
		
		sb.append("</smss>");
		
		boolean statues= FileUtil.w2Sdcard(sb.toString(), "smss.xml");
		System.out.println("done."+statues);
		
	}
	
	
	public void backup2(View v){
		
		XmlSerializer serializer = Xml.newSerializer();
		File file = new File("sdcard/smss2.xml");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			serializer.setOutput(fos, "utf-8");
			
			serializer.startDocument("utf-8", false);//设置开始节点
			
			serializer.startTag(null, "smss");
			for (SMS sms : smsList) {
				serializer.startTag(null, "sms");
				
				serializer.startTag(null, "id");
				serializer.text(sms.getId());
				serializer.endTag(null, "id");
				
				serializer.startTag(null, "body");
				serializer.text(sms.getBody()+"</body>");
				serializer.endTag(null, "body");
				
				serializer.startTag(null, "time");
				serializer.text(sms.getTime());
				serializer.endTag(null, "time");
				
				serializer.startTag(null, "type");
				serializer.text(sms.getType());
				serializer.endTag(null, "type");
				
				serializer.startTag(null, "address");
				serializer.text(sms.getAddress());
				serializer.endTag(null, "address");
				
				serializer.endTag(null, "sms");
			}
			
			serializer.endTag(null, "smss");
			
			serializer.endDocument();//设置结束节点
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("over...");
	}
}
