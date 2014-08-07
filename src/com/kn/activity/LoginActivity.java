package com.kn.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kn.R;
import com.kn.client.AccountClient;
import com.kn.utils.SharedPreferencesManager;
import com.kn.utils.UpdateAppUtils;

public class LoginActivity extends Activity implements View.OnClickListener {

	private static final int CHECK_APP_FLAG_FALSE = 22;
	private static final int CHECK_APP_FLAG_TRUE = 11;
	private static final int DOWN_APP_FLAG_FALIURE = 44;
	private static final int DOWN_APP_FLAG_SUCCESS = 33;
	private static final int LOGIN_FAILURE = 0;
	private static final int LOGIN_SUCCESS = 1;

	private static final String TAG = "LoginActivity";

	private Button button_loginoff = null;
	private Button button_loginon = null;
	private AlertDialog.Builder checkAppDialog = null;
	private ProgressDialog checkAppProgress = null;
	private EditText edit_password = null;
	private EditText edit_username = null;
	private ProgressDialog loginProgress = null;

	private Handler mainHandler = new Handler() {
		public void handleMessage(Message message) {
			super.handleMessage(message);
			switch (message.what) {
			default:
				return;
			case LOGIN_SUCCESS:
				Log.e(TAG, "登录成功");
				String str = message.obj.toString(); // 获取用户名字段
				SharedPreferencesManager.putUser(
						LoginActivity.this.getApplicationContext(), str);
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				LoginActivity.this.startActivity(intent);
				LoginActivity.this.loginProgress.dismiss();
				LoginActivity.this.finish();
				Log.d(TAG, "登录完成，切换画面...");
				return;
			case LOGIN_FAILURE:
				LoginActivity.this.loginProgress.dismiss();
				Log.e(TAG, "登录失败");
				Toast.makeText(LoginActivity.this.getApplicationContext(),
						"登录失败，请检查用户名或密码！", Toast.LENGTH_LONG).show();
				return;
			case CHECK_APP_FLAG_TRUE:
				LoginActivity.this.checkAppDialog = new AlertDialog.Builder(
						LoginActivity.this, 0);
				LoginActivity.this.checkAppDialog.setTitle("应用有更新，是否更新?");
				LoginActivity.this.checkAppDialog.setPositiveButton("是",
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface paramDialogInterface,
									int paramInt) {
								paramDialogInterface.dismiss();
								LoginActivity.this.checkAppProgress
										.setTitle("正在下载应用...");
								new Thread(new LoginActivity.DownAppRunable())
										.start();
							}
						});
				LoginActivity.this.checkAppDialog.setPositiveButton("否",
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface paramDialogInterface,
									int paramInt) {
								LoginActivity.this.checkAppProgress.dismiss();
								paramDialogInterface.dismiss();
							}
						});
				LoginActivity.this.checkAppDialog.create().show();
				return;
			case DOWN_APP_FLAG_SUCCESS:
				LoginActivity.this.checkAppProgress.dismiss();
				new Thread(new LoginActivity.InstallAppRunnable()).start();
				return;
			case CHECK_APP_FLAG_FALSE:
				LoginActivity.this.checkAppProgress.dismiss();
				Toast.makeText(LoginActivity.this, "您的应用已是最新，无需更新！", Toast.LENGTH_SHORT).show();
				return;
			case DOWN_APP_FLAG_FALIURE:
				LoginActivity.this.checkAppProgress.dismiss();
				Toast.makeText(LoginActivity.this, "更新失败，请重新更新！", Toast.LENGTH_SHORT).show();
				return;
			}
		}
	};

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.button_loginoff:
			this.edit_username.setText("");
			this.edit_password.setText("");
			return;
		default:
			return;
		case R.id.button_loginon:
			String str1 = this.edit_username.getText().toString();
			String str2 = this.edit_password.getText().toString();
			this.loginProgress = ProgressDialog.show(this, "正在登录...", null,
					true, false);
			Log.d(TAG, "启动LoginRunnable");
			new Thread(new LoginRunnable(str1, str2)).start();
			
			/** Debug使用 */
//			Message message = Message.obtain();
//			message.what = LOGIN_SUCCESS;
//			LoginActivity.this.mainHandler.sendMessage(message);
		}
	}

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		this.edit_username = ((EditText) findViewById(R.id.edit_username));
		this.edit_password = ((EditText) findViewById(R.id.edit_password));
		this.button_loginon = ((Button) findViewById(R.id.button_loginon));
		this.button_loginoff = ((Button) findViewById(R.id.button_loginoff));
		this.button_loginon.setOnClickListener(this);
		this.button_loginoff.setOnClickListener(this);
		
		/** 检测APP更新，Debug状态下不更新 */
		this.checkAppProgress = ProgressDialog.show(this, "正在检测更新...", null,
				true, false);
		new Thread(new CheckAppRunnable()).start();
	}

	private class CheckAppRunnable implements Runnable {

		private CheckAppRunnable() {

		}

		public void run() {
			Message message = Message.obtain();
			Log.i(TAG, "CheckAppRunnable");
			Boolean flag = false;
			if (flag = UpdateAppUtils.checkAppCode(LoginActivity.this)){
				message.what = CHECK_APP_FLAG_TRUE;
			} else {
				message.what = CHECK_APP_FLAG_FALSE;
			}
			Log.i(TAG, "flag : " + flag);
			LoginActivity.this.mainHandler.sendMessage(message);
		}
	}

	private class DownAppRunable implements Runnable {

		private DownAppRunable() {

		}

		public void run() {
			Message message = Message.obtain();
			if (UpdateAppUtils.downApp(LoginActivity.this
					.getApplicationContext())){
				message.what = DOWN_APP_FLAG_SUCCESS;
			} else {
				message.what = DOWN_APP_FLAG_FALIURE;
			}
			LoginActivity.this.mainHandler.sendMessage(message);
		}
	}

	private class InstallAppRunnable implements Runnable {

		private InstallAppRunnable() {

		}

		public void run() {
			UpdateAppUtils.installApp(LoginActivity.this
					.getApplicationContext());
		}
	}

	private class LoginRunnable implements Runnable {

		private String password;
		private String username;

		public LoginRunnable(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}

		public void run() {
			Message message = Message.obtain();
			if (AccountClient.login(this.username, this.password)) {
				Log.i(TAG, "用户信息验证通过！");
				message.what = LOGIN_SUCCESS;
				message.obj = LoginActivity.this.edit_username.getText()
						.toString();
			} else {
				Log.i(TAG, "用户信息验证失败！");
				message.what = LOGIN_FAILURE;
			}
			LoginActivity.this.mainHandler.sendMessage(message);
		}
	}
}
