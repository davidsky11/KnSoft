package com.kn.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class NetworkAsyncTask extends AsyncTask<Integer, Integer, String> {
	
//	private static final String IP_ADDRESS = "www.csdn.net";
//	private static final int MAX_COUNT = 4;
	private static final String TAG = "NetworkAsyncTask";
	private Context context = null;
	private ProgressDialog networkDialog = null;
	private Integer param;
	private TextView text_show = null;

	public NetworkAsyncTask(Context context, TextView textView,
			Integer param) {
		Log.d(TAG, "NetworkAsyncTask");
		this.context = context;
		this.text_show = textView;
		this.param = param;
		this.networkDialog = new ProgressDialog(context, 0);
		if (param.intValue() == 1)
			this.networkDialog.setTitle("正在Ping服务器，请稍后...");
		while (true) {
			this.networkDialog.setCancelable(false);
			this.networkDialog.setProgressStyle(0);
			this.networkDialog.show();
			return;
		}
	}

	// ERROR //
	protected String doInBackground(Integer... array) {
		
		return null;
	}

	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		Log.d(TAG, "onPostExecute");
		if (("".equals(result)) || (result == null)) {
			if (this.param.intValue() != 1)
				Toast.makeText(this.context, "Ping失败，请重新Ping！", Toast.LENGTH_LONG).show();
		}
		Toast.makeText(this.context, "测速失败，请重新测速！", Toast.LENGTH_LONG).show();

		while (true) {
			this.text_show.setText(result);
			this.networkDialog.dismiss();
			return;

		}
	}

	protected void onProgressUpdate(Integer... array) {
		super.onProgressUpdate(array);
		Log.d(TAG, "onProgressUpdate" + array[0]);
		this.networkDialog.setProgress(array[0].intValue());
	}
}
