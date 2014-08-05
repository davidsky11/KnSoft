package com.kn.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public final class NetworkUtils {

	public static boolean checkNetwork(Context context) {

		boolean flag = false;

		try {
			ConnectivityManager cm = (ConnectivityManager) context
					.getSystemService("connectivity");
			if (cm != null) {
				NetworkInfo ni = cm.getActiveNetworkInfo();
				if (ni != null) {
					if (ni.isConnected()) {
						NetworkInfo.State state1 = ni.getState();
						if (state1 == NetworkInfo.State.CONNECTED)
							flag = true;
					}
				}
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean is3G(Context context) {
		NetworkInfo ni = ((ConnectivityManager) context
				.getSystemService("connectivity")).getActiveNetworkInfo();
		return (ni != null) && (ni.getType() == 0);
	}

	public static boolean isWifi(Context context) {
		NetworkInfo ni = ((ConnectivityManager) context
				.getSystemService("connectivity")).getActiveNetworkInfo();
		return (ni != null) && (ni.getType() == 1);
	}

	public static boolean isWifiEnabled(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService("connectivity");
		TelephonyManager tm = (TelephonyManager) context
				.getSystemService("phone");
		return ((cm.getActiveNetworkInfo() != null) && (cm
				.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED))
				|| (tm.getNetworkType() == 3);
	}
}
