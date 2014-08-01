package com.kn.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kn.R;
import com.kn.adapter.ShangChuanFailAdapter;
import com.kn.entity.FailData;
import com.kn.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class ShuJuShangChuanFragment extends Fragment implements
		View.OnClickListener {

	private static final int CONTINUE = 2;
	private static final int FINISH = 1;
	private static final int MAX = 15;
	private static final String TAG = "数据上传Fragment";
	private boolean stop_thread = false;
	private TextView text_total = null;

	private Button button_fanHuiZhuJieMian = null;
	private Button button_shangChuan_begin = null;
	private Button button_shangChuan_stop = null;
	private View currentView;
	private int layoutId = R.layout.shu_ju_shang_chuan;
	private ListView listView_fail = null;
	private ProgressBar progressBar_shangChuan = null;
	private ShangChuanFailAdapter shangChuanFailAdapter = null;

	private Handler shangChuanHandler = new Handler() {
		public void handleMessage(Message message) {
			super.handleMessage(message);
			switch (message.what) {
			default:
				return;
			case CONTINUE:
				ShuJuShangChuanFragment.this.progressBar_shangChuan
						.incrementProgressBy(1);
				Log.d(TAG, message.obj.toString());
				return;
			case FINISH:
				ShuJuShangChuanFragment.this.progressBar_shangChuan
						.incrementProgressBy(1);
				Log.d(TAG, message.obj.toString());
				ArrayList localArrayList = new ArrayList();
				for (int i = 0;; i++) {
					if (i >= 10) {
						ShuJuShangChuanFragment.this.shangChuanFailAdapter = new ShangChuanFailAdapter(
								ShuJuShangChuanFragment.this.getActivity()
										.getApplicationContext(),
								localArrayList);
						ShuJuShangChuanFragment.this.listView_fail
								.setAdapter(ShuJuShangChuanFragment.this.shangChuanFailAdapter);
						ShuJuShangChuanFragment.this.shangChuanFailAdapter
								.notifyDataSetChanged();
						return;
					}
					FailData localFailData = new FailData();
					localFailData.setId(i);
					localFailData.setDanJuHao(String.valueOf(i + (i + i)));
					localFailData.setSaoMiaoLeiXing("收件");
					localArrayList.add(localFailData);
				}
			}
		}
	};

	public ShuJuShangChuanFragment() {

	}
	
	public ShuJuShangChuanFragment(int paramInt) {
		this.layoutId = paramInt;
	}

	public void onClick(View paramView) {
		switch (paramView.getId()) {
		case R.id.button_fanHuiZhuJieMian:
		default:
			return;
		case R.id.button_shangChuan_begin:
			if (NetworkUtils
					.checkNetwork(getActivity().getApplicationContext())) {
				 new Thread(new ShangChuanRunnable()).start();
				return;
			}
			Toast.makeText(getActivity().getApplicationContext(), "网络连接错误！", 1)
					.show();
			return;
		case R.id.button_shangChuan_stop:
			Log.d(TAG, "中止上传");
			this.stop_thread = true;
			this.button_shangChuan_stop.setEnabled(false);
		}
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
	}

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		this.currentView = paramLayoutInflater.inflate(this.layoutId,
				paramViewGroup, false);
		this.currentView.setFocusable(true);
		this.progressBar_shangChuan = ((ProgressBar) this.currentView
				.findViewById(R.id.progressBar_shangChuan));
		this.text_total = ((TextView) this.currentView
				.findViewById(R.id.text_total));
		this.listView_fail = ((ListView) this.currentView
				.findViewById(R.id.listView_fail));
		this.button_shangChuan_begin = ((Button) this.currentView
				.findViewById(R.id.button_shangChuan_begin));
		this.button_shangChuan_stop = ((Button) this.currentView
				.findViewById(R.id.button_shangChuan_stop));
		this.button_fanHuiZhuJieMian = ((Button) this.currentView
				.findViewById(R.id.button_fanHuiZhuJieMian));
		getActivity().setProgressBarVisibility(true);
		getActivity().setProgressBarIndeterminateVisibility(true);
		this.progressBar_shangChuan.setMax(MAX);
		this.button_shangChuan_begin.setOnClickListener(this);
		this.button_shangChuan_stop.setOnClickListener(this);
		this.button_fanHuiZhuJieMian.setOnClickListener(this);
		View localView = LayoutInflater.from(
				getActivity().getApplicationContext()).inflate(
				R.layout.shang_chuan_fail_header, null);
		this.listView_fail.addHeaderView(localView);
		return this.currentView;
	}

	private class ShangChuanRunnable implements Runnable {

		private ShangChuanRunnable() {

		}

		public void run() {
			int i = 0;
			if ((i > MAX) || (ShuJuShangChuanFragment.this.stop_thread))
				return;
			i++;
			while (true) {
				Message localMessage;
				try {
					localMessage = Message.obtain();
					localMessage.obj = Integer.valueOf(i);
					if (i >= MAX)
						// break label74;
						localMessage.what = CONTINUE;
					ShuJuShangChuanFragment.this.shangChuanHandler
							.sendMessage(localMessage);
					Thread.sleep(1000L);
				} catch (InterruptedException localInterruptedException) {
					localInterruptedException.printStackTrace();
				}
				break;
				// if (i != 15)
				// localMessage.what = FINISH;
			}
		}
	}
}
