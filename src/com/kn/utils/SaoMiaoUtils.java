package com.kn.utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public final class SaoMiaoUtils {

	private static final int REQUEST_CODE = 0;
	private static final String TAG = "扫描帮助工具类";
	private static final String TYPE = "application/vnd.android.package-archive";
	private static final String ZXING_ACTION_NAME = "com.google.zxing.client.android.SCAN";
	private static final String ZXING_FILE = "ZXing.apk";
	private static final String ZXING_PACKAGE_NAME = "com.google.zxing.client.android";
	private static final String ZXING_PATH = "/assets/ZXing.apk";
	private static AlertDialog.Builder installAPKDialog = null;

	private static boolean checkZXingAppExist(Fragment fragment) {
		Log.i(TAG, "检测ZXing.apk是否存在");
		if ((ZXING_PACKAGE_NAME == null) || ("".equals(ZXING_PACKAGE_NAME)))
			return false;
		try {
			ApplicationInfo localApplicationInfo = fragment
					.getActivity()
					.getPackageManager()
					.getApplicationInfo(ZXING_PACKAGE_NAME,
							PackageManager.GET_UNINSTALLED_PACKAGES);
			Log.d(TAG, "*" + localApplicationInfo.enabled);
			Log.i(TAG, "checkZXingAppExist >>>  是否存在 ： "
					+ localApplicationInfo.enabled);
			return localApplicationInfo.enabled;
		} catch (PackageManager.NameNotFoundException localNameNotFoundException) {
		}
		return false;
	}

	private static void installZXingApp(Fragment fragment) {
		Intent localIntent = new Intent();
		localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		localIntent.setAction(Intent.ACTION_DEFAULT);
		AssetManager localAssetManager = fragment.getActivity().getAssets();
		try {
			InputStream localInputStream = localAssetManager.open(ZXING_FILE);
			FileOutputStream localFileOutputStream = fragment.getActivity()
					.openFileOutput(ZXING_FILE, Context.MODE_WORLD_READABLE);
			byte[] arrayOfByte = new byte[1024];
			while (true) {
				int i = localInputStream.read(arrayOfByte);
				if (i == -1) {
					localFileOutputStream.flush();
					if (localInputStream != null)
						localInputStream.close();
					if (localFileOutputStream != null)
						localFileOutputStream.close();
					localIntent.setDataAndType(
							Uri.fromFile(new File(fragment.getActivity()
									.getFilesDir().getPath()
									+ File.separator + ZXING_FILE)), TYPE);
					fragment.getActivity().startActivity(localIntent);
					return;
				}
				localFileOutputStream.write(arrayOfByte, 0, i);
			}
		} catch (Exception localException) {
			while (true)
				localException.printStackTrace();
		}
	}

	private static void launchZXingApp(Fragment fragment) {
		fragment.startActivityForResult(new Intent(ZXING_ACTION_NAME),
				REQUEST_CODE);
	}

	private static void showInstallAPKDialog(final Fragment fragment) {
		installAPKDialog = new AlertDialog.Builder(fragment.getActivity());
		
		/**
		 * 需要添加代码	显示安装APK的对话界面
		 */
		installAPKDialog.setMessage("您的设备尚未安装条码扫描器，是否安装？").setPositiveButton("安装", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Log.i(TAG, "确认安装APK，开始安装...");
				SaoMiaoUtils.installZXingApp(fragment);
			}
		}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		}).create().show();
	}

	public static void startSaoMiao(Fragment fragment) {
		if (!checkZXingAppExist(fragment)) {
			Log.i(TAG, "检测到ZXing.APK不存在");
			showInstallAPKDialog(fragment);
			return;
		}
		launchZXingApp(fragment);
	}
}
