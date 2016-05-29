package com.ivy.hm66.activity;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.ivy.hm66.R;

/**
 * 演示 XXX 界面
 * 
 * @author Ivy
 */
public class CameraActivity extends Activity {

	private ImageView iv;

	private String photoName = "sdcard/camera_" + 1 + ".jpg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_cameara);

		iv = (ImageView) findViewById(R.id.iv);

		setImage();
	}

	private void setImage() {
		Options options = new Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(photoName, options);
		int outHeight = options.outHeight;
		int outWidth = options.outWidth;

		int width = getWindow().getWindowManager().getDefaultDisplay()
				.getWidth();
		int height = getWindow().getWindowManager().getDefaultDisplay()
				.getHeight();
		System.out.println("---width--"+width);
		System.out.println("---height--"+height);
		int scale = 1;
		int h = outHeight / height;
		int w = outWidth / width;
		System.out.println("---outWidth--"+outWidth);
		System.out.println("---outHeight--"+outHeight);
		if (h > w && h > 1) {
			scale = h;
		} else if (w > h && w > 1) {
			scale = w;
		}
		System.out.println("---scale:" + scale);
		options.inJustDecodeBounds = false;
		options.inSampleSize = scale;
		Bitmap bitmap = BitmapFactory.decodeFile(photoName, options);
		iv.setImageBitmap(bitmap);

	}

	public void click(View v) {
		System.out.println("click...");

		// create Intent to take a picture and return control to the calling
		// application
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		File file = new File(photoName);
		// create a file to save the image
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
		// set the image file name
		// start the image capture Intent
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 0) {
			System.out.println("----拍摄完毕---");

		}
	}
}
