package com.ivy.hm66.activity;

import com.ivy.hm66.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * ��ʾ ͼƬ���� ����
 * 
 * @author Ivy
 */
public class ImageLoadActivity extends Activity {

	private ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_imageload);
		
		iv = (ImageView) findViewById(R.id.iv);
	}

	public void click(View v) {
		System.out.println("click...");
		Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile("sdcard/dog.jpg",options);
		
		int width = options.outWidth;
		int height = options.outHeight;
		System.out.println("w:"+width+"--h:"+height);
		
		int w2 = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		int h2 = getWindow().getWindowManager().getDefaultDisplay().getHeight();
		System.out.println("w2:"+w2+"--h2:"+h2);
		
		int wScale = width/w2;
		int hScale = height/h2;
		
		int scale = 1;
		
		System.out.println("wScale:"+wScale+"--hScale:"+hScale);
		
		if(wScale>hScale && wScale>1){
			scale = wScale;
		}else if(hScale >wScale && hScale>1){
			scale = hScale;
		}
		
		options.inJustDecodeBounds = false;
		options.inSampleSize = scale;
		
//		iv.setImageBitmap(bitmap);
		Bitmap bitmap = BitmapFactory.decodeFile("sdcard/dog.jpg",options);
		iv.setImageBitmap(bitmap);
	}
	public void click1(View v) {
		System.out.println("click...");
	}
	
}
