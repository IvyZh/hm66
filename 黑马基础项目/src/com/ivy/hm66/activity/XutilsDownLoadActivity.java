package com.ivy.hm66.activity;

import java.io.File;

import com.ivy.hm66.R;
import com.ivy.hm66.utils.FileUtil;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * ��ʾ XXX ����
 * 
 * @author Ivy
 */
public class XutilsDownLoadActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_xutils);
	}

	public void click(View v) {
		System.out.println("click...");
		
		HttpUtils httpUtils = new HttpUtils();
		String path = "http://192.168.1.5/hello1/epp.exe";
		File file = new File(getCacheDir(), FileUtil.getNameFromPath(path));
		
		httpUtils.download(path, file.getAbsolutePath(), true, true, new RequestCallBack<File>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				Toast.makeText(XutilsDownLoadActivity.this, "onFailure", 0).show();
			}

			@Override
			public void onSuccess(ResponseInfo<File> arg0) {
				Toast.makeText(XutilsDownLoadActivity.this, "onSuccess"+arg0.result.getAbsolutePath(), 0).show();
			}
			
			@Override
			public void onLoading(long total, long current, boolean isUploading) {
				System.out.println("onLoading----"+current+" / "+total);
			}
		});
	}
}
