package com.ivy.hm66.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class IpCallBroadCast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		String data = getResultData();
		System.out.println("---�е绰���ȥ��---"+data.toString());
//		setResultData("17951"+data); ��ʱ�ر�
	}

}
