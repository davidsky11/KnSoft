package com.kn.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.util.Log;

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
			ApplicationInfo ai = fragment
					.getActivity()
					.getPackageManager()
					.getApplicationInfo(ZXING_PACKAGE_NAME,
							PackageManager.GET_UNINSTALLED_PACKAGES);
			Log.d(TAG, "*" + ai.enabled);
			Log.i(TAG, "checkZXingAppExist >>>  是否存在 ： " + ai.enabled);
			return ai.enabled;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static void installZXingApp(Fragment fragment) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(Intent.ACTION_DEFAULT);
		AssetManager am = fragment.getActivity().getAssets();
		try {
			InputStream is = am.open(ZXING_FILE);
			FileOutputStream fos = fragment.getActivity().openFileOutput(
					ZXING_FILE, Context.MODE_WORLD_READABLE);
			byte[] arrayOfByte = new byte[1024];
			while (true) {
				int i = is.read(arrayOfByte);
				if (i == -1) {
					fos.flush();
					if (is != null)
						is.close();
					if (fos != null)
						fos.close();
					intent.setDataAndType(
							Uri.fromFile(new File(fragment.getActivity()
									.getFilesDir().getPath()
									+ File.separator + ZXING_FILE)), TYPE);
					fragment.getActivity().startActivity(intent);
					return;
				}
				fos.write(arrayOfByte, 0, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void launchZXingApp(Fragment fragment) {
		fragment.startActivityForResult(new Intent(ZXING_ACTION_NAME),
				REQUEST_CODE);
	}

	private static void showInstallAPKDialog(final Fragment fragment) {
		installAPKDialog = new AlertDialog.Builder(fragment.getActivity());

		/**
		 * 需要添加代码 显示安装APK的对话界面
		 */
		installAPKDialog.setMessage("您的设备尚未安装条码扫描器，是否安装？")
				.setPositiveButton("安装", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.i(TAG, "确认安装APK，开始安装...");
						SaoMiaoUtils.installZXingApp(fragment);
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {

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
