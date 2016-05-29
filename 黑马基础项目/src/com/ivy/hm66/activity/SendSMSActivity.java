package com.ivy.hm66.activity;

import java.util.ArrayList;

import com.ivy.hm66.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 短信发送器界面
 * @author Ivy
 *
 */
public class SendSMSActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sendsms);
	}
	
	
	/**
	 * 发送短信逻辑
	 * @param v
	 */
	public void send(View v){
		EditText etPhoneNumber = (EditText) findViewById(R.id.et_phone);
		EditText etSmsContext = (EditText) findViewById(R.id.et_sms_context);
		String phoneNumber = etPhoneNumber.getText().toString().trim();
		String smsContext = etSmsContext.getText().toString().trim();
		
		//发送短信：注意和打电话不一样。上层应用可以直接调用发短信的api
		
		SmsManager smsManager = SmsManager.getDefault();
		
		//把长短信截成短短信，然后用for信息发送
		ArrayList<String> messages = smsManager.divideMessage(smsContext);
		
		for (String msg : messages) {
			// 要发给的电话号码，短信中心地址可以传null,短信内容，广播（短信发送成功或失败，可以传null），广播（短信发送成功或失败，可以传null）
			smsManager.sendTextMessage(phoneNumber, null, msg, null, null);
		}
		
									
		
		// *#*#4636#*#*
		
		
		
	}
}
