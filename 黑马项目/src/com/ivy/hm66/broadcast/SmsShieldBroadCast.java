package com.ivy.hm66.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsShieldBroadCast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("---∂Ã–≈¿¥¡À---");
		
		Bundle extras = intent.getExtras();
		Object[] object = (Object[]) extras.get("pdus");
		for (Object obj : object) {
			SmsMessage sms = SmsMessage.createFromPdu((byte[])obj);
			String body = sms.getMessageBody();
			String address = sms.getOriginatingAddress();
			
			System.out.println(address+"---"+body);
			if("111".equals(address)){
				abortBroadcast();
			}
		}
	}

}
