package com.ivy.hm66.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class IpCallBroadCast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		String data = getResultData();
		System.out.println("---有电话打出去了---"+data.toString());
//		setResultData("17951"+data); 暂时关闭
	}

}
