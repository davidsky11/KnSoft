package com.kn.utils;

import android.content.Context;
import android.content.SharedPreferences;

public final class SharedPreferencesManager {
	
	private static String SHARED_PREFERENCES_NAME = "WsBox";
	private static SharedPreferences sharedPreferences = null;

	public static String getUser(Context context) {
		sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
		return sharedPreferences.getString("user", "NO NAME");
	}

	public static void putUser(Context context, String str) {
		sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
		SharedPreferences.Editor localEditor = sharedPreferences.edit();
		localEditor.putString("user", str);
		localEditor.commit();
	}
}
