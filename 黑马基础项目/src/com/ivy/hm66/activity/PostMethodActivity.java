package com.ivy.hm66.activity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.ivy.hm66.R;
import com.ivy.hm66.cons.Constant;
import com.ivy.hm66.utils.FileUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 演示 Get方式提交数据 界面
 * 
 * @author Ivy
 */
public class PostMethodActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_getmethod);
	}

	public void click(View v) {
		System.out.println("click...");
		
		EditText etUserName = (EditText) findViewById(R.id.et_username);
		EditText etPwd = (EditText) findViewById(R.id.et_pwd);
		
		String username = etUserName.getText().toString().trim();
		String pwd = etPwd.getText().toString().trim();
		
		final String path = Constant.Login;
		final String context = "username1="+URLEncoder.encode(username)+"&pwd1="+pwd;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("POST");
					conn.setReadTimeout(8000);
					conn.setConnectTimeout(8000);
					
					//设置请求头信息，经测试可以不加
					conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
					conn.setRequestProperty("Content-Length", context.length()+"");
					
					System.out.println(context.length()+"--长度");
					
					
					//打开流对象
					conn.setDoOutput(true);
					OutputStream os = conn.getOutputStream();
					os.write(context.getBytes());
					
					int code = conn.getResponseCode();
					if(code == 200){
						InputStream is = conn.getInputStream();
						final String text = FileUtil.getTextFromIs(is);
						System.out.println(text);
						
						runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								Toast.makeText(PostMethodActivity.this, text, 0).show();
							}
						});
						
					}else{
						System.out.println("请求失败");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		}).start();
		
		
		
	}
}
