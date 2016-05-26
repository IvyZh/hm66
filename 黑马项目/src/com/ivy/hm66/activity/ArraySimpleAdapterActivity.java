package com.ivy.hm66.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.ivy.hm66.R;
import com.ivy.hm66.db.MyOpenHelper;
import com.ivy.hm66.domain.Person;

/**
 * —› æ XXX ΩÁ√Ê
 * @author Ivy
 */
public class ArraySimpleAdapterActivity extends Activity {

	private ArrayList<Person> personList;
	private ArrayList<String> nameList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showdata2);
		
		
		MyOpenHelper oh = new MyOpenHelper(this);
		SQLiteDatabase db = oh.getWritableDatabase();
		Cursor cursor = db.query("person", null, null, null, null, null, null);
//		personList = new ArrayList<Person>();
		nameList = new ArrayList<String>();
		while(cursor.moveToNext()){
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String phone = cursor.getString(cursor.getColumnIndex("phone"));
			int salary = cursor.getInt(cursor.getColumnIndex("salary"));
//			Person person = new Person(name, salary, phone);
//			personList.add(person);
			nameList.add(name);
		}
		
		ListView lv = (ListView) findViewById(R.id.lv);
		
//		int size = nameList.size();
//		String[] objects = (String[]) nameList.toArray(new String[size]);
//		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.item_arraysimpleadapter, R.id.tv_name, objects));
		
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		for (String name : nameList) {
			System.out.println("add..."+name);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", name);
			if(name.endsWith("4")){
				map.put("photo", R.drawable.ic_launcher);
			}else{
				map.put("photo", R.drawable.robot);
			}
			data.add(map);
		}
		
		lv.setAdapter(new SimpleAdapter(this, data, R.layout.item_arraysimpleadapter, new String[]{"name","photo"}, new int[]{R.id.tv_name,R.id.iv_photo}));
	
	}
}
