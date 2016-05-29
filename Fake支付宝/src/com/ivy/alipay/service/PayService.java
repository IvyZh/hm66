package com.ivy.alipay.service;

import com.ivy.alipay.service.AliPay.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

public class PayService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new PayBinder();
	}

	class PayBinder extends Stub{

		@Override
		public void pay(int money) throws RemoteException {
			System.out.println("ÄúÖ§¸¶ÁË "+money+" Ôª");
		}
	}
}
