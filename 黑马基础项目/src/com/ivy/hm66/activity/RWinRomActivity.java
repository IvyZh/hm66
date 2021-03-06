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
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.ivy.hm66.R;

/**
 * 演示 内部存储的读取 界面
 * 
 * @author Ivy
 * 
 */
public class RWinRomActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_rwinrom);

		
		readAccount();
	}

	private void readAccount() {
		// 用Java基本IO来读取
		// 确定文件名和路径
		File file = new File("data/data/com.ivy.hm66","info.txt");
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
			File file = new File("data/data/com.ivy.hm66","info.txt");
			
			//getFilesDir()方法返回一个File对象，封装的路径是data/data/com.ivy.hm66/files
//			File file = new File(getFilesDir(),"info.txt");
			
			//getFilesDir()方法返回一个File对象，封装的路径是data/data/com.ivy.hm66/cache
//			File file = new File(getCacheDir(),"info.txt");
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
