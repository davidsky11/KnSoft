package com.kn.client;

import android.util.Log;
import java.util.HashMap;
import org.ksoap2.serialization.SoapObject;

public final class AccountClient extends BaseClient {
	private static final String TAG = "AccountClient";

	public static final boolean login(String username, String password) {
		boolean flag = false;
		HashMap localHashMap = new HashMap();
		localHashMap.put("name", username);
		if ((username  == null) || ("".equals(username))
				|| (password == null) || ("".equals(password))) {
			
			/** 如果username或password为空 */
			flag = false;
		} else {
			if (username.equals("admin") && password.equals("admin")) {
				flag = true;
			}
//			boolean bool = false;
//			do {
//				SoapObject localSoapObject2;
//				do {
//					SoapObject localSoapObject1;
//					try {
//						localSoapObject1 = getSoapObject(localHashMap,
//								"account", "findAccountByUsername");
//						if (null == localSoapObject1) {
//							Log.e("AccountClient", "soapObject为空");
//							return false;
//						}
//					} catch (Exception localException) {
//						localException.printStackTrace();
//						return false;
//					}
//					localSoapObject2 = (SoapObject) localSoapObject1
//							.getProperty(0);
//					Log.e("AccountClient", localSoapObject2.toString());
//				} while (!localSoapObject2.hasProperty("password"));
//				bool = localSoapObject2.getProperty("password").toString()
//						.equals(password);
//			} while (!bool);
		}
		return flag;
	}
}