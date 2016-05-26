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
public class ContactsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_contacts);
		
		ListView lv = (ListView) findViewById(R.id.lv);
		
		final String[] objects = {"zk","kl","in","ja","as","ec","un","cs","ps","co","wmd"};//模拟数据
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.item_arraysimpleadapter, R.id.tv_name, objects));
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String data = objects[position];
				
				Intent intent = new Intent();
				intent.putExtra("name", data);
				setResult(0, intent);
				finish();
			}
		});
	}

}
