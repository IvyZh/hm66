package com.ivy.hm66.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.ivy.hm66.R;

import android.os.Environment;
import android.widget.EditText;

/**
 * 文件操作管理类
 */
public class FileUtil {
	
	/**
	 * 根据地址取得文件名称
	 * @param path
	 * @return
	 */
	public static String getNameFromPath(String path){
		int index = path.lastIndexOf("/")+1;
		return path.substring(index);
	}
	
	
	/**
	 * 把内容写到SdCard里面
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
				//把字节流转成字符流
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				// 读入其中的文本
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


	/**
	 * 流转字符串
	 * @param is
	 * @return
	 */
	public static String getTextFromIs(InputStream is) {
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int len;
			while((len = is.read(b))!=-1){
				baos.write(b, 0, len);
			}
			
			String text = new String(baos.toByteArray());
			//如果服务器的文件是gbk的编码
//			String text = new String(baos.toByteArray(), "gbk");
			return text;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
