package com.ivy.hm66.activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.ivy.hm66.R;

/**
 * 演示 SDCard存储的读取 界面
 * 
 * @author Ivy
 * 
 */
public class RWinSDCardActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_rwinrom);

		
		readAccount();
	}

	private void readAccount() {
		// 用Java基本IO来读取
		// 确定文件名和路径
//		File file = new File("sdcard/info.txt");
		
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			
		
		
		File file = new File(Environment.getExternalStorageDirectory(),"info.txt");
		if(file.exists()&&file.length()>0){
			try {
				FileInputStream fis = new FileInputStream(file);
				//把字节流转成字符流
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				// 读入其中的文本
				String line = br.readLine();
				String[] split = line.split("##");
				
				//把账号和密码填入
				EditText etName = (EditText) findViewById(R.id.et_username);
				EditText etPwd = (EditText) findViewById(R.id.et_pwd);
				
				etName.setText(split[0]);
				etPwd.setText(split[1]);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		}else{
			Toast toast = Toast.makeText(this, "SD card不可用", Toast.LENGTH_SHORT);
		}
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
			// 用Java基本IO来存储
			// 确定文件名和路径
//			File file = new File("sdcard/info.txt");
			File file = new File(Environment.getExternalStorageDirectory(),"info.txt");
			
			try {
				FileOutputStream fos = new FileOutputStream(file);
				//把账号和密码写入
				fos.write((name+"##"+pwd).getBytes());
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			
		}

		//创建吐司
		Toast toast = Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT);
		toast.show();//显示
	}
}
