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
 * 演示Button点击事件界面
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
				Toast.makeText(ButtonClickActivity.this, "匿名内部类实现点击", 0).show();
				
			}
		});
		
		
		btClick3.setOnClickListener(this);
		
		
	}
	
	class MyListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			Toast.makeText(ButtonClickActivity.this, "继承接口实现", 0).show();
		}
		
	}

	@Override
	public void onClick(View v) {//OnClickListener
		Toast.makeText(ButtonClickActivity.this, "使用当前类继承OnClickListener方法实现", 0).show();
	}
	
	public void btClick(View v){
		Toast.makeText(ButtonClickActivity.this, "Android特有的点击事件", 0).show();
	}
	
}
