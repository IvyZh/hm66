package com.ivy.hm66.activity;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.ivy.hm66.R;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorInflater;
import com.nineoldandroids.animation.ObjectAnimator;

/**
 * 演示 XXX 界面
 * 
 * @author Ivy
 */
public class ObjectAnimationActivity extends Activity {
	private View imageView1;
	private ObjectAnimator oa;
	private ObjectAnimator oa1;
	private ObjectAnimator oa2;
	private ObjectAnimator oa3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_tween);

		imageView1 = findViewById(R.id.imageView1);
		imageView1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(ObjectAnimationActivity.this, "hahah", 0).show();
			}
		});
	}

	public void click(View v) {
		System.out.println("click...");

		oa = ObjectAnimator.ofFloat(imageView1, "translationX", 0,100);
		oa.setDuration(2000);
		oa.start();
	}

	public void click1(View v) {
		oa1 = ObjectAnimator.ofFloat(imageView1, "rotation", 0,100);
		oa1.setDuration(2000);
		oa1.start();

	}

	public void click2(View v) {
		System.out.println("click...");
		oa2 = ObjectAnimator.ofFloat(imageView1, "scaleY", 0,2);
		oa2.setDuration(2000);
		oa2.start();
		
	}

	public void click3(View v) {
		oa3 = ObjectAnimator.ofFloat(imageView1, "alpha", 0.1f,1);
		oa3.setDuration(2000);
		oa3.start();

	}

	public void click4(View v) {
		
		
//		oa = ObjectAnimator.ofFloat(imageView1, "translationX", 0,100);
//		oa3 = ObjectAnimator.ofFloat(imageView1, "alpha", 0.1f,1);
//		
//		oa2 = ObjectAnimator.ofFloat(imageView1, "scaleY", 0,2);
//		oa1 = ObjectAnimator.ofFloat(imageView1, "rotation", 0,100);
//		AnimatorSet as = new AnimatorSet();
//		as.setDuration(3000);
//		as.playSequentially(oa,oa1,oa2,oa3);
////		as.playTogether(oa,oa1,oa2,oa3);
//		as.start();
		
		
		
		//XML实现加载属性动画
		
		Animator animator = AnimatorInflater.loadAnimator(this, R.animator.propertyanimation);
		animator.setTarget(imageView1);
		
		animator.start();
		
	}
}
