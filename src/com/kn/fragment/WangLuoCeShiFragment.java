package com.kn.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kn.R;
import com.kn.async.NetworkAsyncTask;
import com.kn.utils.FragmentUtils;

public class WangLuoCeShiFragment extends Fragment implements
		View.OnClickListener {

	private static final String TAG = "网络测试Fragment";

	private int layoutId = R.layout.wang_luo_ce_shi;

	private Button button_back = null;
	private Button button_ceSu = null;
	private Button button_yanChi = null;
	private View currentView;
	private NetworkAsyncTask networkAsyncTask = null;
	private TextView text_ceShi = null;

	public WangLuoCeShiFragment() {
	}

	public WangLuoCeShiFragment(int layoutId) {
		this.layoutId = layoutId;
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.button_back:
			FragmentUtils.popBackStack(getFragmentManager());
			return;
		default:
			return;
		case R.id.button_yanChi:
			this.networkAsyncTask = new NetworkAsyncTask(getActivity(),
					this.text_ceShi, Integer.valueOf(1));
			this.networkAsyncTask.execute(new Integer[0]);
			return;
		case R.id.button_ceSu:
			this.networkAsyncTask = new NetworkAsyncTask(getActivity(),
					this.text_ceShi, Integer.valueOf(2));
			this.networkAsyncTask.execute(new Integer[0]);
		}
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView方法");
		this.currentView = inflater.inflate(this.layoutId, container, false);
		this.currentView.setFocusable(true);
		return this.currentView;
	}

	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Log.d(TAG, "onViewCreated方法");
		this.text_ceShi = ((TextView) view.findViewById(R.id.text_ceShi));
		this.button_yanChi = ((Button) view.findViewById(R.id.button_yanChi));
		this.button_ceSu = ((Button) view.findViewById(R.id.button_ceSu));
		this.button_back = ((Button) view.findViewById(R.id.button_back));
		this.text_ceShi
				.setMovementMethod(ScrollingMovementMethod.getInstance());
		this.button_yanChi.setOnClickListener(this);
		this.button_ceSu.setOnClickListener(this);
		this.button_back.setOnClickListener(this);
	}
}
