package com.kn.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kn.R;

public class YunDanZhuiZongFragment extends Fragment implements
		View.OnClickListener {

//	private static final String TAG = "运单追踪Fragment";

	private View currentView;
	private int layoutId = R.layout.yun_dan_zhui_zong;

	public YunDanZhuiZongFragment() {
	}

	public YunDanZhuiZongFragment(int paramInt) {
		this.layoutId = paramInt;
	}

	public void onClick(View paramView) {
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.currentView = inflater.inflate(this.layoutId, container, false);
		this.currentView.setFocusable(true);
		return this.currentView;
	}
}
