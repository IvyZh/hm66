package com.ivy.hm66.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.ivy.hm66.R;
import com.ivy.hm66.interfaces.MusicController;
import com.ivy.hm66.service.MusicService;

/**
 * 演示 XXX 界面
 * 
 * @author Ivy
 */
public class PlayMusicActivity extends Activity {
	private MusicController controller;
	private MyConn conn;
	private Intent intent;
	private static SeekBar sb;
	
	public static Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			
			Bundle bundle = msg.getData();
			int max = bundle.getInt("max");
			int progress = bundle.getInt("progress");
			sb.setMax(max);
			sb.setProgress(progress);
			System.out.println("----progress:"+progress);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_music);
		
		sb = (SeekBar) findViewById(R.id.sb);
		
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				int progress = seekBar.getProgress();
				controller.seek(progress);
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	// 本地音乐
	public void click1(View v) {
		if (controller == null) {
			Toast.makeText(this, "请先开启音乐服务", 0).show();
			return;
		}
		controller.play();
	}

	public void click2(View v) {
		if (controller == null) {
			Toast.makeText(this, "请先开启音乐服务", 0).show();
			return;
		}
		controller.pause();
	}

	public void click3(View v) {
		if (controller == null) {
			Toast.makeText(this, "请先开启音乐服务", 0).show();
			return;
		}
		controller.stop();
	}

	// 网络音乐
	public void click4(View v) {
		String path = "http://192.168.1.5/Kettering.mp3";
		
		
		if (controller == null) {
			Toast.makeText(this, "请先开启音乐服务", 0).show();
			return;
		}

		 controller.playNetMusic(path);
	}

	public void click5(View v) {
		intent = new Intent(this, MusicService.class);
		conn = new MyConn();
		startService(intent);
		bindService(intent, conn, BIND_AUTO_CREATE);
	}

	//解除绑定
	public void click6(View v) {
		if (conn != null && intent != null) {
			System.out.println("PlayMusic 解除绑定");
			unbindService(conn);
			stopService(intent);
			conn=null;
		}
	}

	class MyConn implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			controller = (MusicController) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

	}
}
