package com.kn.adapter;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kn.entity.Grade_3;
import java.util.List;

public class Grade_3Adapter extends ZhanDianAdapter<Grade_3> {
	private static final String TAG = "三级站点Adapter";
	private Fragment fragment;

	public Grade_3Adapter(Fragment paramFragment, List<Grade_3> paramList) {
		super(paramList);
		this.fragment = paramFragment;
		Log.d(TAG, getClass().getName());
	}

	public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
		if (paramView == null)
			paramView = LayoutInflater.from(this.fragment.getActivity())
					.inflate(2130903074, null);
		((TextView) paramView.findViewById(2131099754))
				.setText(((Grade_3) getItem(paramInt)).getGrade_3_name());
		return paramView;
	}
}
