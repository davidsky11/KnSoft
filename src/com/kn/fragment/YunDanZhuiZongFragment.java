package com.kn.fragment;

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
	private int layoutId = 2130903072;

	public YunDanZhuiZongFragment() {
	}

//	public YunDanZhuiZongFragment(int paramInt) {
//		this.layoutId = paramInt;
//	}

	public void onClick(View paramView) {
	}

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		this.currentView = paramLayoutInflater.inflate(this.layoutId,
				paramViewGroup, false);
		this.currentView.setFocusable(true);
		return this.currentView;
	}
}

/*
 * Location: C:\Users\davidsky\Desktop\AUTOID7\AutoidPDA_22336439500900.jar
 * Qualified Name: com.seuic.fragment.YunDanZhuiZongFragment JD-Core Version:
 * 0.6.0
 */