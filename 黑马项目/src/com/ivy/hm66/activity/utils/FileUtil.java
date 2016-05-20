package com.ivy.hm66.activity.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ivy.hm66.R;

import android.os.Environment;
import android.widget.EditText;

/**
 * �ļ�����������
 */
public class FileUtil {
	
	/**
	 * ������д��SdCard����
	 * @param content
	 * @param fileName
	 */
	public static boolean w2Sdcard(String content,String fileName){
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			File file = new File(Environment.getExternalStorageDirectory(),fileName);
			
			try {
				FileOutputStream fos = new FileOutputStream(file);
				fos.write((content).getBytes());
				fos.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}else{
			return false;
		}
	}
	
	public static String rFromSdcard(String fileName){
		File file = new File(Environment.getExternalStorageDirectory(),fileName);
		if(file.exists()&&file.length()>0){
			try {
				FileInputStream fis = new FileInputStream(file);
				//���ֽ���ת���ַ���
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				// �������е��ı�
				StringBuffer sb = new StringBuffer();
				String line = "";
				while((line = br.readLine())!=null){
					sb.append(line);
				}
				return sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}else{
			return null;
		}
		
	}
	
}
