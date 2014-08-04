package com.kn.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NetworkSpeedAsyncTask extends AsyncTask<String, Integer, String> {
	private static final String ADDRESS = "www.csdn.net";
	private static final String TAG = "NetworkAsyncTask";
	private ProgressDialog networkDialog = null;
	private Process process;
	private TextView text_show = null;

	public NetworkSpeedAsyncTask(Context paramContext, TextView paramTextView) {
		Log.d(TAG, "NetworkAsyncTask");
		this.text_show = paramTextView;
		this.networkDialog = new ProgressDialog(paramContext, 0);
		this.networkDialog.setTitle("正在测网速，请稍后...");
		this.networkDialog.setCancelable(false);
		this.networkDialog.setProgressStyle(0);
		this.networkDialog.show();
	}

	protected String doInBackground(String[] paramArrayOfString) {
		Log.d(TAG, "doInBackground");
		StringBuffer localStringBuffer = new StringBuffer();
		try {
			this.process = Runtime.getRuntime().exec(
					"ping "+ ADDRESS + " -l 1000 -n 4");
			BufferedReader localBufferedReader = new BufferedReader(
					new InputStreamReader(this.process.getInputStream()));
			Log.d(TAG,
					"doInBackground+*:" + localBufferedReader.readLine());
			while (true) {
				String str1 = localBufferedReader.readLine();
				if (str1 == null)
					return localStringBuffer.toString();
				Log.d(TAG, str1);
				localStringBuffer.append(str1);
				localStringBuffer.append("\n");
				int i = str1.indexOf("Average");
				if (i < 0)
					continue;
				String str2 = str1.substring(i + 10, str1.lastIndexOf("ms"));
				Log.d(TAG,
						"speed is:" + 1000 / Integer.parseInt(str2) + " KB/S");
				localStringBuffer.append("speed is:" + 1000
						/ Integer.parseInt(str2) + " KB/S");
			}
		} catch (Exception localException) {
			while (true)
				localException.getMessage();
		}
	}

	protected void onPostExecute(String paramString) {
		super.onPostExecute(paramString);
		Log.d(TAG, "onPostExecute" + paramString);
		this.text_show.setText("**********************");
		this.networkDialog.dismiss();
	}

	protected void onPreExecute() {
		super.onPreExecute();
	}

	protected void onProgressUpdate(Integer[] paramArrayOfInteger) {
		super.onProgressUpdate(paramArrayOfInteger);
		Log.d(TAG, "onProgressUpdate");
		this.networkDialog.setProgress(paramArrayOfInteger[0].intValue());
	}
}
