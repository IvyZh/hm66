package com.ivy.hm66.activity;

import java.io.File;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.VideoView;

import com.ivy.hm66.R;

/**
 * —› æ XXX ΩÁ√Ê
 * 
 * @author Ivy
 */
public class VideoActivity extends Activity {

	private MediaPlayer player;
	private SurfaceHolder holder;
	private VideoView vv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_video);

		SurfaceView sv = (SurfaceView) findViewById(R.id.sv);
		holder = sv.getHolder();
		player = new MediaPlayer();

		vv = (VideoView) findViewById(R.id.vv);
		vv.setVideoPath(new File(getCacheDir(), "2.3gp")
					.getAbsolutePath());
		
	}

	public void click1(View v) {
		vv.start();
	}
	public void click(View v) {
		System.out.println("click...");
		
		holder.addCallback(new Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				if(holder!=null){
					player.stop();
					player.release();
					player = null;
				}
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				// TODO Auto-generated method stub
				
			}
		});
		try {
			player.setDataSource(new File(getCacheDir(), "2.3gp")
					.getAbsolutePath());
			player.setDisplay(holder);
			player.prepareAsync();
			player.setOnPreparedListener(new OnPreparedListener() {

				@Override
				public void onPrepared(MediaPlayer mp) {
					player.start();
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
