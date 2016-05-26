package com.ivy.hm66.service;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.text.format.Time;

import com.ivy.hm66.activity.PlayMusicActivity;
import com.ivy.hm66.interfaces.MusicController;

public class MusicService extends Service {

	private MediaPlayer player;
	private TimerTask task;
	private Timer timer;

	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("音乐服务已经创建....");
		prepareTimer();
		prepareMusice();
	}

	private void prepareTimer() {
		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				if (player != null) {
//					if(!player.isPlaying()){
//						player.start();
//					}
					Message msg = PlayMusicActivity.handler.obtainMessage();
					Bundle bundle = new Bundle();
					int duration = player.getDuration();
					int currentPosition = player.getCurrentPosition();
					bundle.putInt("max", duration);
					bundle.putInt("progress", currentPosition);
					msg.setData(bundle);
					PlayMusicActivity.handler.sendMessage(msg);
				}
			}
		};
		timer.schedule(task, 500, 500);
	}

	private void prepareMusice() {
		player = new MediaPlayer();
		try {
			player.setDataSource(new File(getCacheDir(), "zdmx.mp3")
					.getAbsolutePath());
			player.setAudioStreamType(AudioManager.STREAM_MUSIC);
			player.prepare();
			int duration = player.getDuration();
			System.out.println("时长：" + duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("----onStartCommand--");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("----onDestroy--");
		if (player != null) {
			player.release();
			player = null;
		}

		if (timer != null) {
			timer.cancel();
			timer = null;
		}
	}

	class MyBinder extends Binder implements MusicController {

		@Override
		public void play() {
			if (player != null) {
				System.out.println("----开始播放音乐---");
				player.start();
			} else {
				prepareMusice();
				player.start();
			}
		}

		@Override
		public void stop() {
			if (player != null) {
				player.stop();
				player.release();
				player = null;
			}
		}

		@Override
		public void pause() {
			if (player != null) {
				player.pause();
			}
		}

		@Override
		public void playNetMusic(String path) {
			stop();
			prepareAyncMusice(path);
		}

		@Override
		public void seek(int progress) {
			if(player!=null)
				player.seekTo(progress);
		}

	}

	public void prepareAyncMusice(String path) {
		player = new MediaPlayer();
		try {
			player.setDataSource(path);
			player.setAudioStreamType(AudioManager.STREAM_MUSIC);
			player.prepareAsync();
			player.setOnPreparedListener(new OnPreparedListener() {

				@Override
				public void onPrepared(MediaPlayer mp) {
					mp.start();
				}
			});
			int duration = player.getDuration();
			System.out.println("时长：" + duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
