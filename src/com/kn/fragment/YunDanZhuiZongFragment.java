package com.kn.fragment;

import com.kn.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class YunDanZhuiZongFragment extends Fragment implements
		View.OnClickListener {
	private static final String TAG = "运单追踪Fragment";
	private View currentView;
	private int layoutId = R.layout.yun_dan_zhui_zong;

	public YunDanZhuiZongFragment() {
	}

	public YunDanZhuiZongFragment(int paramInt) {
		this.layoutId = paramInt;
	}

	public void onClick(View paramView) {
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup paramViewGroup,
			Bundle savedInstanceState) {
		this.currentView = inflater.inflate(this.layoutId, paramViewGroup,
				false);
		this.currentView.setFocusable(true);
		return this.currentView;
	}
}
