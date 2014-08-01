package com.kn.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public final class NetworkUtils {

	public static boolean checkNetwork(Context paramContext) {

		boolean flag = false;
		
		try {
			ConnectivityManager localConnectivityManager = (ConnectivityManager) paramContext
					.getSystemService("connectivity");
			flag = false;
			if (localConnectivityManager != null) {
				NetworkInfo localNetworkInfo = localConnectivityManager
						.getActiveNetworkInfo();
				flag = false;
				if (localNetworkInfo != null) {
					boolean bool = localNetworkInfo.isConnected();
					flag = false;
					if (bool) {
						NetworkInfo.State localState1 = localNetworkInfo
								.getState();
						NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
						flag = false;
						if (localState1 == localState2)
							flag = true;
					}
				}
			}
			return flag;
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return false;
	}

	public static boolean is3G(Context paramContext) {
		NetworkInfo localNetworkInfo = ((ConnectivityManager) paramContext
				.getSystemService("connectivity")).getActiveNetworkInfo();
		return (localNetworkInfo != null) && (localNetworkInfo.getType() == 0);
	}

	public static boolean isWifi(Context paramContext) {
		NetworkInfo localNetworkInfo = ((ConnectivityManager) paramContext
				.getSystemService("connectivity")).getActiveNetworkInfo();
		return (localNetworkInfo != null) && (localNetworkInfo.getType() == 1);
	}

	public static boolean isWifiEnabled(Context paramContext) {
		ConnectivityManager localConnectivityManager = (ConnectivityManager) paramContext
				.getSystemService("connectivity");
		TelephonyManager localTelephonyManager = (TelephonyManager) paramContext
				.getSystemService("phone");
		return ((localConnectivityManager.getActiveNetworkInfo() != null) && (localConnectivityManager
				.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED))
				|| (localTelephonyManager.getNetworkType() == 3);
	}
}
