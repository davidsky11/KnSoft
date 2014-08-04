package com.kn.client;

import java.util.HashMap;

public final class AccountClient extends BaseClient {
	private static final String TAG = "AccountClient";

	public static final boolean login(String username, String password) {
		// boolean flag = false;
		HashMap hashMap = new HashMap();
		hashMap.put("name", username);
		if ((username == null) || ("".equals(username)) || (password == null)
				|| ("".equals(password))) {

			/** 如果username或password为空 */
			return false;
		} else {
			/** Debug使用，发布时删除 */
			 if (username.equals("admin") && password.equals("admin")) {
				 return true;
			 }
			
			/** 正常登录功能 */
//			boolean bool = false;
//			SoapObject request1, request2;
//			try {
//				request2 = getSoapObject(hashMap, "account",
//						"findAccountByUsername");
//				if (null == request2) {
//					Log.e(TAG, "soapObject为空");
//					return false;
//				}
//				Log.e(TAG, "request2.toString > " + request2.toString());
//				request1 = (SoapObject) request2.getProperty(0);
//				Log.e(TAG, "request1.toString > " + request1.toString());
//				if (request1.hasProperty("password")
//						&& request1.getProperty("password").toString()
//								.equals(password))
//					return true;
//			} catch (Exception localException) {
//				localException.printStackTrace();
//				return false;
//			}
		}
		return false;
	}
}