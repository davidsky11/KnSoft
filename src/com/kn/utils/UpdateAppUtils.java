package com.kn.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.ksoap2.serialization.SoapObject;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

import com.kn.client.BaseClient;

public final class UpdateAppUtils extends BaseClient {

	private static final String APK_FILE_NAME = "KnSoft.apk";
	private static final String APK_URL = "http://10.0.2.2:8080/KnService/apk/KnSoft.apk";
	private static final String METHOD_NAME = "getAndroidVersion";
	private static final String PACKAGE_NAME = "com.kn";
	private static final String SERVICE_NAME = "android";
	private static final String TAG = "UpdateAppUtils";
	private static final String TYPE = "application/vnd.android.package-archive";

	public static boolean checkAppCode(Context context) {
		Log.i(TAG, "currentAppDode : " + currentAppCode(context) + "\t serviceAppCode : " + serviceAppCode());
		return currentAppCode(context) < serviceAppCode();
	}

	public static int currentAppCode(Context context) {
		int i = -1;
		try {
			i = context.getPackageManager().getPackageInfo(PACKAGE_NAME,
					PackageManager.COMPONENT_ENABLED_STATE_DEFAULT).versionCode;
			Log.d(TAG, "currentAppCode " + String.valueOf(i));
			return i;
		} catch (PackageManager.NameNotFoundException localNameNotFoundException) {
			localNameNotFoundException.printStackTrace();
		}
		return i;
	}

	public static boolean downApp(Context context) {
		boolean flag = true;
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(
					APK_URL).openConnection();
			conn.connect();
			InputStream is = conn
					.getInputStream();
			FileOutputStream fos = context
					.openFileOutput(APK_FILE_NAME, Context.MODE_WORLD_READABLE);
			byte[] arrayOfByte = new byte[1024];
			while (true) {
				int j = is.read(arrayOfByte);
				if (j == -1) {
					fos.flush();
					is.close();
					return true;
				}
				fos.write(arrayOfByte, 0, j);
			}
		} catch (Exception localException) {
			localException.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public static void installApp(Context context) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(Intent.ACTION_DEFAULT);
		intent.setDataAndType(
				Uri.fromFile(new File(context.getFilesDir().getPath()
						+ File.separator + APK_FILE_NAME)), TYPE);
		context.startActivity(intent);
	}

	public static int serviceAppCode() {
		try {
			SoapObject request = getSoapObject(null, SERVICE_NAME,
					METHOD_NAME);
			if (request == null)
				return -1;
			Log.e(TAG, "serviceAppCode " + request.getProperty(0));
			int i = Integer.parseInt(((SoapObject) request
					.getProperty(0)).getProperty("versionCode").toString());
			return i;
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return -1;
	}
}
