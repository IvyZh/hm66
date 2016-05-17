package com.ivy.hm66.activity;

import java.io.File;

import com.ivy.hm66.R;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.text.style.BulletSpan;
import android.view.View;
import android.widget.TextView;

/**
 * SDCard存储情况 界面
 * @author Ivy
 */
public class SDCardStorageActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_sdstoraget);
		
		TextView tvStorage = (TextView) findViewById(R.id.tv_storage);
		
		
		File file = Environment.getExternalStorageDirectory();
		StatFs statFs = new StatFs(file.getPath());
		
		String info = "";
		//判断当前手机版本是否4.3
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR2){
			long size = statFs.getBlockSizeLong();
			long availableBlocksLong = statFs.getAvailableBlocksLong();
			long allBlocksLong = statFs.getBlockCountLong();
			
			String allSize = Formatter.formatFileSize(this, size * allBlocksLong);
			String availableSize = Formatter.formatFileSize(this, size * availableBlocksLong);
			
			info = "SDCard\n总共存储："+allSize+"\n可用容量："+availableSize;
		}else{
			int size = statFs.getBlockSize();
			int availableBlocksLong = statFs.getAvailableBlocks();
			int allBlocksLong = statFs.getBlockCount();
			
			String allSize = Formatter.formatFileSize(this, size * allBlocksLong);
			String availableSize = Formatter.formatFileSize(this, size * availableBlocksLong);
			info = "SDCard\n 总共存储："+allSize+"\n可用容量："+availableSize;
		}
		
		tvStorage.setText(info);
	}

}
