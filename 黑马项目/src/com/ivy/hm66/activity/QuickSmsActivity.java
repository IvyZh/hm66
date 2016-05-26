package com.ivy.hm66.activity;

import com.ivy.hm66.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * ��ʾ XXX ����
 * 
 * @author Ivy
 */
public class QuickSmsActivity extends Activity {

	private EditText etUserName;
	private EditText etContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_quicksms);
		
		etUserName = (EditText) findViewById(R.id.et_phone1);
		etContext = (EditText) findViewById(R.id.et_context);
	}

	public void click1(View v) {
		System.out.println("contacts...");
		
		Intent intent = new Intent(this, ContactsActivity.class);
		
		startActivityForResult(intent, 0);
	}
	public void click2(View v) {
		System.out.println("context...");
		Intent intent = new Intent(this, SmsTempletActivity.class);
		
		startActivityForResult(intent, 1);
	}
	public void click3(View v) {
		System.out.println("send...");
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 0:
			String name = data.getStringExtra("name");
			System.out.println("name:"+name);
			etUserName.setText(name);
			break;
		case 1:
			String sms = data.getStringExtra("sms");
			System.out.println("sms:"+sms);
			etContext.setText(sms);
			break;

		}
		
	}
}
