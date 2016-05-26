package com.ivy.hm66.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SDCardStatusBroadCast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		String text = "SDCardStatusChange";
				
		if("android.intent.action.MEDIA_MOUNTED".equals(action)){
			text = "SDCard ����";
		}else if("android.intent.action.MEDIA_UNMOUNTED".equals(action)){
			text = "SDCard δ����";
		}else if("android.intent.action.MEDIA_REMOVED".equals(action)){
			text = "SDCard �Ƴ�";
		}
		Toast.makeText(context, text, 0).show();
	}

}
