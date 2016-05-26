package com.ivy.hm66.activity;

import com.ivy.hm66.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * 演示 联系人 界面
 * 
 * @author Ivy
 */
public class SmsTempletActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_contacts);
		
		ListView lv = (ListView) findViewById(R.id.lv);
		
		final String[] objects = new String[10];//模拟数据
		
		for (int i = 0; i < 10; i++) {
			objects[i] = "this is sms templet "+i;
		}
		
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.item_arraysimpleadapter, R.id.tv_name, objects));
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String data = objects[position];
				
				Intent intent = new Intent();
				intent.putExtra("sms", data);
				setResult(0, intent);
				finish();
			}
		});
	}

}
