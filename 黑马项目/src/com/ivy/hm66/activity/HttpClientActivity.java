package com.ivy.hm66.activity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.ivy.hm66.R;
import com.ivy.hm66.activity.utils.FileUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * 演示 使用HttpClient框架发送请求  界面
 * 
 * @author Ivy
 */
public class HttpClientActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
	}

	/***
	 * HttpClient网络框架Get请求
	 * @param v
	 */
	public void click(View v) {
		final String path = "";
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//1.创建HttpClient对象
				HttpClient httpClient = new DefaultHttpClient();
				//2.创建Get请求对象
				HttpGet httpGet = new HttpGet(path);
				//3.使用client发送Get请求
				try {
					HttpResponse response = httpClient.execute(httpGet);
					//获取状态行 状态码
					if(response.getStatusLine().getStatusCode()==200){
						//获取实体，读流
						InputStream is = response.getEntity().getContent();
						// 把流转成字符串
						String text = FileUtil.getTextFromIs(is);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		}).start();
	}
	/***
	 * HttpClient网络框架Post请求
	 * @param v
	 */
	public static void click1(View v){
		final String path = "";
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//1.创建HttpClient对象
				HttpClient httpClient = new DefaultHttpClient();
				//2.创建Post请求对象
				HttpPost httpPost = new HttpPost(path);
				
				//把提交的数据封装到post中
				BasicNameValuePair param1 = new BasicNameValuePair("name", "zhangsan");
				BasicNameValuePair param2 = new BasicNameValuePair("pwd", "123");
				List<NameValuePair> parameters = new ArrayList<NameValuePair>(); ;
				parameters.add(param1);
				parameters.add(param1);
				
				try {
					HttpEntity entity = new UrlEncodedFormEntity(parameters, "utf-8");
					//把实体封装到post中
					httpPost.setEntity(entity);
					HttpResponse response = httpClient.execute(httpPost);
					//获取状态行 状态码
					if(response.getStatusLine().getStatusCode()==200){
						//获取实体，读流
						InputStream is = response.getEntity().getContent();
						// 把流转成字符串
						String text = FileUtil.getTextFromIs(is);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		}).start();
	}
}
