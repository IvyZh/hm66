package com.ivy.hm66.activity;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

import com.ivy.hm66.R;
import com.ivy.hm66.cons.Constant;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings.Global;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 演示 Async-Http异步请求  界面
 * 
 * @author Ivy
 */
public class AsyncHttpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_getmethod);
		
		findViewById(R.id.bt_post).setVisibility(View.VISIBLE);
	}
	
	
	/**
	 * AsyncHttp的Get请求
	 * @param v
	 */
	public void click(View v) {
		System.out.println("--AsyncHttp的Get请求--");
		EditText etUserName = (EditText) findViewById(R.id.et_username);
		EditText etPwd = (EditText) findViewById(R.id.et_pwd);
		
		String username = etUserName.getText().toString().trim();
		String pwd = etPwd.getText().toString().trim();
		
		final String path = Constant.Login +"?username1="+URLEncoder.encode(username)+"&pwd1="+pwd;
		
		AsyncHttpClient client = new AsyncHttpClient();
		
		// 也可以使用RequestParam封装表单数据
		RequestParams rp = new RequestParams();
		rp.add("username1", username);
		rp.add("pwd1", pwd);
		
		
		client.get(Constant.Login,rp, new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
				Toast.makeText(AsyncHttpActivity.this, new String(responseBody), 0).show();
			}
			
			@Override
			public void onFailure(int statusCode, Header[] headers,
					final byte[] responseBody, final Throwable error) {
				
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Toast.makeText(AsyncHttpActivity.this, error.toString(), 0).show();
					}
				});
				
			}
		});

	}
	
	
	/**
	 * AsyncHttp的Post请求
	 * @param v
	 */
	public void click1(View v) {
		
		final String path = Constant.Login;
		EditText etUserName = (EditText) findViewById(R.id.et_username);
		EditText etPwd = (EditText) findViewById(R.id.et_pwd);
		
		final String username = etUserName.getText().toString().trim();
		final String pwd = etPwd.getText().toString().trim();
		
		
		AsyncHttpClient client = new AsyncHttpClient();
		
		RequestParams rp = new RequestParams();
		rp.add("username1", username);
		rp.add("pwd1", pwd);
		client.post(path, rp,new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
				Toast.makeText(AsyncHttpActivity.this, new String(responseBody), 0).show();
			}
			
			@Override
			public void onFailure(int statusCode, Header[] headers,
					byte[] responseBody, final Throwable error) {
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Toast.makeText(AsyncHttpActivity.this, error.toString(), 0).show();
					}
				});
			}
		});

	}
}
