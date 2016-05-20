package com.ivy.hm66.activity;

import java.util.ArrayList;
import java.util.Iterator;

import com.ivy.hm66.R;
import com.ivy.hm66.activity.domain.Person;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 演示TextView显示数据库数据 界面
 * @author Ivy
 */
public class ShowDataActivity2 extends Activity {
	
	private ArrayList<Person> personList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_showdata2);
		
		
		MyOpenHelper oh = new MyOpenHelper(this);
		SQLiteDatabase db = oh.getWritableDatabase();
		Cursor cursor = db.query("person", null, null, null, null, null, null);
		personList = new ArrayList<Person>();
		while(cursor.moveToNext()){
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String phone = cursor.getString(cursor.getColumnIndex("phone"));
			int salary = cursor.getInt(cursor.getColumnIndex("salary"));
			Person person = new Person(name, salary, phone);
			personList.add(person);
		}
		
		ListView lv = (ListView) findViewById(R.id.lv);
		MyAdapter adapter = new MyAdapter();
		lv.setAdapter(adapter);
	}
	
	class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return personList.size();
		}

		
		//ListView的缓存
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = null;
			if(convertView==null){
				view = View.inflate(ShowDataActivity2.this, R.layout.item_showdata, null);
				
			}else{
				view = convertView;
			}
				
			TextView tvName = (TextView) view.findViewById(R.id.tv_name);
			TextView tvPhone = (TextView) view.findViewById(R.id.tv_phone);
			TextView tvSalary = (TextView) view.findViewById(R.id.tv_salary);
			
			Person person = personList.get(position);
			
			tvName.setText(person.getName());
			tvPhone.setText(person.getPhone());
			tvSalary.setText(person.getSalary()+"");
			return view;
		}
	
/*
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			System.out.println("getView()---"+position);
			
			//1. 使用TextView作为item
//			Person person = personList.get(position);
//			TextView tv = new TextView(ShowDataActivity2.this);
//			tv.setText(person.toString());
//			return tv;
			
			
			// 2. 使用
			// 把布局文件填充成View对象
			View view = View.inflate(ShowDataActivity2.this, R.layout.item_showdata, null);
			
			//其他两种获取布局填充器的方法
			
//			LayoutInflater inflater = LayoutInflater.from(ShowDataActivity2.this);
//			LayoutInflater inflater  = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE)
			
//			View view = inflater.inflate(R.layout.item_showdata, null);
			
			
			TextView tvName = (TextView) view.findViewById(R.id.tv_name);
			TextView tvPhone = (TextView) view.findViewById(R.id.tv_phone);
			TextView tvSalary = (TextView) view.findViewById(R.id.tv_salary);
			
			Person person = personList.get(position);
			
			tvName.setText(person.getName());
			tvPhone.setText(person.getPhone());
			tvSalary.setText(person.getSalary()+"");
			
			return view;
		}
		
		*/
		
		
		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}
	}
}
