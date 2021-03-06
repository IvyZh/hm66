package com.ivy.hm66.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AppStatusBroadCast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String text = "";
		String action = intent.getAction();
		text = intent.getData().toString();
		if("android.intent.action.PACKAGE_REPLACED".equals(action)){
			text += "应用更新了";
		}else if("android.intent.action.PACKAGE_ADDED".equals(action)){
			text += "应用安装了";
		}else if("android.intent.action.PACKAGE_REMOVED".equals(action)){
			text += "应用移除了";
		}
		Toast.makeText(context, text, 0).show();
	}

}
