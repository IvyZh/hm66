package com.ivy.hm66.broadcast;

import com.ivy.hm66.MainActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompleteBroadc extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "开机了", 0).show();
		System.out.println("--开机了---");
		Intent it = new Intent(context, MainActivity.class);	
		it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(it);
	}

}
