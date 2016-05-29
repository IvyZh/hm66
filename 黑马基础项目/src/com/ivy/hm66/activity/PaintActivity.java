package com.ivy.hm66.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.ivy.hm66.R;

/**
 * 演示 XXX 界面
 * 
 * @author Ivy
 */
public class PaintActivity extends Activity {

	private ImageView iv;
	private Canvas canvas;
	private Paint paint;
	private Bitmap bitmap;
	private Bitmap copyBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_paint);

		iv = (ImageView) findViewById(R.id.iv);

		bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bg);
		reset();

		iv.setOnTouchListener(new OnTouchListener() {

			private int startX;
			private int startY;

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					startX = (int) event.getX();
					startY = (int) event.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					int endX = (int) event.getX();
					int endY = (int) event.getY();

					canvas.drawLine(startX, startY, endX, endY, paint);

					iv.setImageBitmap(copyBitmap);
					startX = endX;
					startY = endY;

					break;
				case MotionEvent.ACTION_UP:

					break;
				}
				return true;
			}
		});
	}

	public void click1(View v) {
		paint.setColor(Color.RED);
	}

	public void click2(View v) {
		paint.setStrokeWidth(8);

	}

	public void click3(View v) {
		reset();
	}

	private void reset() {
		copyBitmap = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), bitmap.getConfig());
		canvas = new Canvas(copyBitmap);
		paint = new Paint();
		paint.setColor(Color.BLACK);

		Matrix matrix = new Matrix();
		canvas.drawBitmap(bitmap, matrix, paint);
		iv.setImageBitmap(copyBitmap);
	}

	public void click(View v) {
		//Save
		
		File file = new File("sdcard/"+System.currentTimeMillis()+".jpg");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			copyBitmap.compress(CompressFormat.JPEG, 100, fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//发送广播
		
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
		intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
		sendBroadcast(intent);
		
		Toast.makeText(PaintActivity.this, "图片保存成功", 0).show();
		reset();
	}

}
