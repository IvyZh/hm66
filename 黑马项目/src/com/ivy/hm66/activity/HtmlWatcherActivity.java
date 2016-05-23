package com.ivy.hm66.activity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.ivy.hm66.R;
import com.ivy.hm66.activity.cons.Constant;
import com.ivy.hm66.activity.utils.FileUtil;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 演示 XXX 界面
 * 
 * @author Ivy
 */
public class HtmlWatcherActivity extends Activity {
	
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			
			switch (msg.what) {
			case 0:
				Toast.makeText(HtmlWatcherActivity.this, "请求失败", 0).show();
				break;
			case 1:
				String text = (String) msg.obj;
				TextView tv = (TextView) findViewById(R.id.tv);
				tv.setText(text);
				break;
			}
			
		};
	};
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_htmlwatcher);
	}

	public void click(View v) {

		
		new Thread(new Runnable() {
			
			@Override
			public void run() {

				String path = Constant.HOST_baidu;
				System.out.println(path);
				
				try {
					//1.通过地址构造url对象
					URL url = new URL(path);
					//2.打开连接器
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					//3. 设置一下请求属性
					//设置请求方式，注意大写
					conn.setRequestMethod("GET");
					//设置连接超时
					conn.setConnectTimeout(8000);
					//设置读取时间超时
					conn.setReadTimeout(8000);
					//4. 发送请求
					conn.connect();
					//5.获得响应码
					if(conn.getResponseCode()==200){
						//6.取得流信息
						InputStream is = conn.getInputStream();
						
						//7. 把流转成字符串形式
						String text = FileUtil.getTextFromIs(is);
						
						Message msg = Message.obtain();
						msg.obj = text;
						msg.what = 1;
						handler.sendMessage(msg);
						
					}else{
//						Message msg = Message.obtain();
//						msg.what = 0;
//						handler.sendMessage(msg);
						handler.sendEmptyMessage(0);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		}).start();
		
	
	}
}
