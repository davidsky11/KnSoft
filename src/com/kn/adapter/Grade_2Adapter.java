package com.kn.adapter;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kn.R;
import com.kn.entity.Grade_2;
import java.util.List;

public class Grade_2Adapter extends ZhanDianAdapter<Grade_2> {
	private static final String TAG = "二级站点Adapter";
	private Fragment fragment;

	public Grade_2Adapter(Fragment paramFragment, List<Grade_2> paramList) {
		super(paramList);
		this.fragment = paramFragment;
		Log.d(TAG, getClass().getName());
	}

	public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
		if (paramView == null)
			paramView = LayoutInflater.from(this.fragment.getActivity())
					.inflate(R.layout.zhan_dian_item, null);
		((TextView) paramView.findViewById(R.id.text_title))
				.setText(((Grade_2) getItem(paramInt)).getGrade_2_name());
		return paramView;
	}
}
