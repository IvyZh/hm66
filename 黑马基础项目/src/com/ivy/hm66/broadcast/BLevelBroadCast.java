package com.ivy.hm66.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BLevelBroadCast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "BLevelBroadCast���յ��˹㲥", 0).show();
		String data = getResultData();
		if(data!=null){
			System.out.println("B--"+data);
			abortBroadcast();
		}
	}

}
