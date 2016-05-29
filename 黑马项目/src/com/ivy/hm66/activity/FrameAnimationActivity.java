package com.ivy.hm66.activity;

import com.ivy.hm66.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * ��ʾ XXX ����
 * 
 * @author Ivy
 */
public class FrameAnimationActivity extends Activity {

	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_frameanimation);
		
		iv = (ImageView) findViewById(R.id.imageView1);
	}

	public void click(View v) {
		System.out.println("click...");
		
		
		iv.setBackgroundResource(R.drawable.drawableanimation);
		AnimationDrawable ad = (AnimationDrawable) iv.getBackground();
		
		ad.start();
		
		
	}
}
