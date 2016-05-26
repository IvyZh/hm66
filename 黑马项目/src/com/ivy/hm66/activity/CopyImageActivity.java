package com.ivy.hm66.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ivy.hm66.R;

/**
 * ��ʾ XXX ����
 * 
 * @author Ivy
 */
public class CopyImageActivity extends Activity {

	private ImageView iv1;
	private ImageView iv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_copy);
		iv1 = (ImageView) findViewById(R.id.iv1);
		iv2 = (ImageView) findViewById(R.id.iv2);
	}

	public void click(View v) {
		Bitmap srcBitmap = BitmapFactory.decodeFile("sdcard/1.jpg");
		iv1.setImageBitmap(srcBitmap);
		
		Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(),srcBitmap.getConfig());
		
		Canvas canvas = new Canvas(copyBitmap);
		
		Paint paint = new Paint();
		
		Matrix matrix = new Matrix();
		
		canvas.drawBitmap(srcBitmap, matrix, paint);
		
		iv2.setImageBitmap(copyBitmap);
	}
	
	public void click1(View v){
		Bitmap srcBitmap = BitmapFactory.decodeFile("sdcard/1.jpg");
		iv1.setImageBitmap(srcBitmap);
		
		Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(),srcBitmap.getConfig());
		
		Canvas canvas = new Canvas(copyBitmap);
		
		Paint paint = new Paint();
		
		Matrix mt = new Matrix();
		mt.setScale(0.5f, 0.5f);
		canvas.drawBitmap(srcBitmap, mt, paint);
		
		iv2.setImageBitmap(copyBitmap);
	}
	
	public void click2(View v){
		Bitmap srcBitmap = BitmapFactory.decodeFile("sdcard/1.jpg");
		iv1.setImageBitmap(srcBitmap);
		
		Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(),srcBitmap.getConfig());
		
		Canvas canvas = new Canvas(copyBitmap);
		
		Paint paint = new Paint();
		
		Matrix mt = new Matrix();
		mt.setRotate(90, srcBitmap.getWidth()/2, srcBitmap.getHeight()/2);
		canvas.drawBitmap(srcBitmap, mt, paint);
		
		iv2.setImageBitmap(copyBitmap);
	}
	
	public void click3(View v){
		Bitmap srcBitmap = BitmapFactory.decodeFile("sdcard/1.jpg");
		iv1.setImageBitmap(srcBitmap);
		
		Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(),srcBitmap.getConfig());
		
		Canvas canvas = new Canvas(copyBitmap);
		
		Paint paint = new Paint();
		
		Matrix mt = new Matrix();
		mt.setTranslate(50, 50);
		canvas.drawBitmap(srcBitmap, mt, paint);
		
		iv2.setImageBitmap(copyBitmap);
	}
	
	public void click4(View v){
		Bitmap srcBitmap = BitmapFactory.decodeFile("sdcard/1.jpg");
		iv1.setImageBitmap(srcBitmap);
		
		Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(),srcBitmap.getConfig());
		
		Canvas canvas = new Canvas(copyBitmap);
		
		Paint paint = new Paint();
		
		Matrix mt = new Matrix();
		mt.setScale(-1, 1);
		mt.postTranslate(srcBitmap.getWidth(), 0);
		canvas.drawBitmap(srcBitmap, mt, paint);
		
		iv2.setImageBitmap(copyBitmap);
	}
	
	public void click5(View v){
		Bitmap srcBitmap = BitmapFactory.decodeFile("sdcard/1.jpg");
		iv1.setImageBitmap(srcBitmap);
		
		Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(),srcBitmap.getConfig());
		
		Canvas canvas = new Canvas(copyBitmap);
		
		Paint paint = new Paint();
		
		Matrix mt = new Matrix();
		mt.setScale(1, -1);
		mt.postTranslate(0, srcBitmap.getHeight());
		canvas.drawBitmap(srcBitmap, mt, paint);
		
		iv2.setImageBitmap(copyBitmap);
	}
	
	
	
	
}
