package com.ivy.hm66.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ivy.hm66.R;
import com.loopj.android.image.SmartImageView;

/**
 * ��ʾ XXX ����
 * @author Ivy
 */
public class SmartImageViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_smartimageview);
	}
	
	public void click(View v){
		SmartImageView siv = (SmartImageView) findViewById(R.id.siv);
		siv.setImageUrl("http://192.168.5.9/hello1/1.jpg");
	}
}
