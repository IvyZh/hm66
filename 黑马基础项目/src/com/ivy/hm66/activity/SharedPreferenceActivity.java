package com.ivy.hm66.activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.ivy.hm66.R;

/**
 * 演示 SharedPreference 存储的读取 界面
 * 
 * @author Ivy
 * 
 */
public class SharedPreferenceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_rwinrom);

		
		readAccount();
	}

	private void readAccount() {
				
		//把账号和密码填入
		EditText etName = (EditText) findViewById(R.id.et_username);
		EditText etPwd = (EditText) findViewById(R.id.et_pwd);
		SharedPreferences preferences = getSharedPreferences("info", MODE_PRIVATE);
		String name = preferences.getString("username", "");
		String pwd = preferences.getString("pwd", "");
		etName.setText(name);
		etPwd.setText(pwd);
				
	}

	public void login(View v) {
		System.out.println("login...");
		EditText etName = (EditText) findViewById(R.id.et_username);
		EditText etPwd = (EditText) findViewById(R.id.et_pwd);
		CheckBox checkBox = (CheckBox) findViewById(R.id.cb_remember);
		
		String name = etName.getText().toString().trim();
		String pwd = etPwd.getText().toString().trim();
		if(checkBox.isChecked()){
			System.out.println("记住用户名和密码");
			SharedPreferences preferences = getSharedPreferences("info", MODE_PRIVATE);
			//获取编辑器
			Editor edit = preferences.edit();
			edit.putString("username", name);
			edit.putString("pwd", pwd);
			edit.commit();//提交数据
		}else{
			
		}

		//创建吐司
		Toast toast = Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT);
		toast.show();//显示
	}
}
