package com.ivy.hm66.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CLevelBroadCast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "CLevelBroadCast接收到了广播", 0).show();
		String data = getResultData();
		if(data!=null){
			System.out.println("C--"+data);
		}
	}

}
