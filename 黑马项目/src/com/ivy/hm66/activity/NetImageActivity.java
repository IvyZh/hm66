package com.ivy.hm66.activity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ivy.hm66.R;
import com.ivy.hm66.activity.utils.FileUtil;

/**
 * 演示 XXX 界面
 * @author Ivy
 */
public class NetImageActivity extends Activity {
	
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			
			switch (msg.what) {
			case 0:
				Toast.makeText(NetImageActivity.this, "请求失败", 0).show();
				break;
			case 1:
				Bitmap bm = (Bitmap) msg.obj;
				ImageView iv = (ImageView) findViewById(R.id.iv);
				iv.setImageBitmap(bm);
				break;
			}
			
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_netimage);
	}
	
	/**
	 * 读取网络图片+缓存
	 * @param v
	 */
	public void click2(View v){
		
		final String path = "http://192.168.5.9/hello1/1.jpg";
		File file = new File(getCacheDir(),FileUtil.getNameFromPath(path));
		if(file.exists()&&file.length()>0){
			System.out.println("读取缓存图片："+FileUtil.getNameFromPath(path));
			Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath());
			ImageView iv = (ImageView) findViewById(R.id.iv);
			iv.setImageBitmap(bm);
			return;
		}
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("网络请求图片"+path);
				
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
//					conn.connect(); 这个方法也可以不要
					//5.获得响应码
					if(conn.getResponseCode()==200){
						//6.取得流信息
						InputStream is = conn.getInputStream();
						
						byte[] b = new byte[1024];
						int len;
						File file = new File(getCacheDir(),FileUtil.getNameFromPath(path));
						FileOutputStream fos = new FileOutputStream(file);
						while((len = is.read(b))!=-1){
							fos.write(b, 0, len);
						}
						fos.close();
						
						
						//7.因为流已经读取完成了，接下来如果再读，就没什么了内容了，因此就不能用这个方法了。
//						Bitmap bm = BitmapFactory.decodeStream(is);
						
						Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath());
						
						Message msg = Message.obtain();
						msg.obj = bm;
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
	
	
	/***
	 * 在子线程中下载网络图片
	 * @param v
	 */
	public void click1(View v){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {

				String path = "http://192.168.5.9/hello1/1.jpg";
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
						//7.通过图片工厂类，转成图片
						Bitmap bm = BitmapFactory.decodeStream(is);
						
						Message msg = Message.obtain();
						msg.obj = bm;
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
	
	/***
	 * 在主线程中下载网络图片
	 * @param v
	 */
	public void click(View v){
		String path = "http://192.168.5.9/hello1/11.jpg";
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
				//7.通过图片工厂类，转成图片
				Bitmap bm = BitmapFactory.decodeStream(is);
				ImageView iv = (ImageView) findViewById(R.id.iv);
				iv.setImageBitmap(bm);
			}else{
				Toast.makeText(this, "请求失败", 0).show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
