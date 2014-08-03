package com.kn.adapter;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kn.entity.Grade_1;
import java.util.List;

public class Grade_1Adapter extends ZhanDianAdapter<Grade_1> {
	private static final String TAG = "一级站点Adapter";
	private Fragment fragment;

	public Grade_1Adapter(Fragment paramFragment, List<Grade_1> paramList) {
		super(paramList);
		this.fragment = paramFragment;
		Log.d(TAG, getClass().getName());
	}

	public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
		if (paramView == null)
			paramView = LayoutInflater.from(this.fragment.getActivity())
					.inflate(2130903074, null);
		((TextView) paramView.findViewById(2131099754))
				.setText(((Grade_1) getItem(paramInt)).getGrade_1_name());
		return paramView;
	}
}
