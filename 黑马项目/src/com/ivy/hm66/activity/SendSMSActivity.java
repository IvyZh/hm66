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
 * ���ŷ���������
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
	 * ���Ͷ����߼�
	 * @param v
	 */
	public void send(View v){
		EditText etPhoneNumber = (EditText) findViewById(R.id.et_phone);
		EditText etSmsContext = (EditText) findViewById(R.id.et_sms_context);
		String phoneNumber = etPhoneNumber.getText().toString().trim();
		String smsContext = etSmsContext.getText().toString().trim();
		
		//���Ͷ��ţ�ע��ʹ�绰��һ�����ϲ�Ӧ�ÿ���ֱ�ӵ��÷����ŵ�api
		
		SmsManager smsManager = SmsManager.getDefault();
		
		//�ѳ����Žسɶ̶��ţ�Ȼ����for��Ϣ����
		ArrayList<String> messages = smsManager.divideMessage(smsContext);
		
		for (String msg : messages) {
			// Ҫ�����ĵ绰���룬�������ĵ�ַ���Դ�null,�������ݣ��㲥�����ŷ��ͳɹ���ʧ�ܣ����Դ�null�����㲥�����ŷ��ͳɹ���ʧ�ܣ����Դ�null��
			smsManager.sendTextMessage(phoneNumber, null, msg, null, null);
		}
		
									
		
		// *#*#4636#*#*
		
		
		
	}
}
