package com.ivy.hm66.activity;

import com.ivy.hm66.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * �绰����������
 * @author Ivy
 *
 */
public class CallDemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_calldemo);
		
		Button btCall = (Button) findViewById(R.id.bt_call);
		btCall.setOnClickListener(new MyListener());
	}
	
	class MyListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			EditText etPhone = (EditText) findViewById(R.id.et_phone);
			String phoneNumber = etPhone.getText().toString().trim();
			Toast.makeText(CallDemoActivity.this, phoneNumber, 0).show();
			
			// ��绰�߼�
			
			//1. ����һ����ͼ
			Intent intent = new Intent();
			//2. �Ѷ�����װ����ͼ��
			intent.setAction(Intent.ACTION_CALL);
			//3. ���˭
			intent.setData(Uri.parse("tel:"+phoneNumber));
			//4. ����ϵͳ�ҵĶ���
			startActivity(intent);
			
		}
		
	}
}
