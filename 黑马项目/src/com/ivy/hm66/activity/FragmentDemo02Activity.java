package com.ivy.hm66.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ivy.hm66.R;
import com.ivy.hm66.fragment.Fragment01L;
import com.ivy.hm66.fragment.Fragment02L;
import com.ivy.hm66.fragment.Fragment03L;

/**
 * ��ʾ XXX ����
 * 
 * @author Ivy
 */
public class FragmentDemo02Activity extends FragmentActivity {

	private Fragment01L fragment01l;
	private Fragment02L fragment02l;
	private Fragment03L fragment03l;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_fragment);
		
		fragment01l = new Fragment01L();
		fragment02l = new Fragment02L();
		
		fragment03l = new Fragment03L();
	}

	public void click(View v) {
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		ft.replace(R.id.frame_id, fragment01l);
		ft.commit();

	}

	public void click1(View v) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		ft.replace(R.id.frame_id, fragment02l);
		ft.commit();

	}

	public void click2(View v) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		ft.replace(R.id.frame_id, fragment03l);
		ft.commit();
	}
	
	public void click4(View v) {
		EditText et = (EditText) findViewById(R.id.et);
		String text = et.getText().toString();
		
		
		fragment02l.setText(text);
	}
	
	
	public void setText(String text){
		TextView textView1 = (TextView) findViewById(R.id.textView1);
		textView1.setText(text);
	}
	
	
}
