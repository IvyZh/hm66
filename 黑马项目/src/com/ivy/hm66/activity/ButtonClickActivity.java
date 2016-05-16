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
 * ��ʾButton����¼�����
 * @author Ivy
 *
 */
public class ButtonClickActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_buttonclick);
		
		Button btClick1 = (Button) findViewById(R.id.bt_click1);
		Button btClick2 = (Button) findViewById(R.id.bt_click2);
		Button btClick3 = (Button) findViewById(R.id.bt_click3);
		
		
		btClick1.setOnClickListener(new MyListener());
		
		btClick2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(ButtonClickActivity.this, "�����ڲ���ʵ�ֵ��", 0).show();
				
			}
		});
		
		
		btClick3.setOnClickListener(this);
		
		
	}
	
	class MyListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			Toast.makeText(ButtonClickActivity.this, "�̳нӿ�ʵ��", 0).show();
		}
		
	}

	@Override
	public void onClick(View v) {//OnClickListener
		Toast.makeText(ButtonClickActivity.this, "ʹ�õ�ǰ��̳�OnClickListener����ʵ��", 0).show();
	}
	
	public void btClick(View v){
		Toast.makeText(ButtonClickActivity.this, "Android���еĵ���¼�", 0).show();
	}
	
}
