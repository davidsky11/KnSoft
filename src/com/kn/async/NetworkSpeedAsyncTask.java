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

	public NetworkSpeedAsyncTask(Context context, TextView textView) {
		Log.d(TAG, "NetworkAsyncTask");
		this.text_show = textView;
		this.networkDialog = new ProgressDialog(context, 0);
		this.networkDialog.setTitle("正在测网速，请稍后...");
		this.networkDialog.setCancelable(false);
		this.networkDialog.setProgressStyle(0);
		this.networkDialog.show();
	}

	protected String doInBackground(String[] array) {
		Log.d(TAG, "doInBackground");
		StringBuffer sb = new StringBuffer();
		try {
			this.process = Runtime.getRuntime().exec(
					"ping " + ADDRESS + " -l 1000 -n 4");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					this.process.getInputStream()));
			Log.d(TAG, "doInBackground+*:" + br.readLine());
			while (true) {
				String str1 = br.readLine();
				if (str1 == null)
					return sb.toString();
				Log.d(TAG, str1);
				sb.append(str1);
				sb.append("\n");
				int i = str1.indexOf("Average");
				if (i < 0)
					continue;
				String str2 = str1.substring(i + 10, str1.lastIndexOf("ms"));
				Log.d(TAG, "speed is:" + 1000 / Integer.parseInt(str2)
						+ " KB/S");
				sb.append("speed is:" + 1000 / Integer.parseInt(str2) + " KB/S");
			}
		} catch (Exception e) {
			while (true)
				e.getMessage();
		}
	}

	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		Log.d(TAG, "onPostExecute" + result);
		this.text_show.setText("**********************");
		this.networkDialog.dismiss();
	}

	protected void onPreExecute() {
		super.onPreExecute();
	}

	protected void onProgressUpdate(Integer[] array) {
		super.onProgressUpdate(array);
		Log.d(TAG, "onProgressUpdate");
		this.networkDialog.setProgress(array[0].intValue());
	}
}
