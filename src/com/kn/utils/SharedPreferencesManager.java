package com.kn.utils;

import android.content.Context;
import android.content.SharedPreferences;

public final class SharedPreferencesManager {

	private static String SHARED_PREFERENCES_NAME = "KnSoft";
	private static SharedPreferences sharedPreferences = null;

	public static String getUser(Context context) {
		sharedPreferences = context.getSharedPreferences(
				SHARED_PREFERENCES_NAME, 0);
		return sharedPreferences.getString("user", "NO NAME");
	}

	public static void putUser(Context context, String str) {
		sharedPreferences = context.getSharedPreferences(
				SHARED_PREFERENCES_NAME, 0);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("user", str);
		editor.commit();
	}
}
