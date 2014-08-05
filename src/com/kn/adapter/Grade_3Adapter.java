package com.kn.adapter;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kn.R;
import com.kn.entity.Grade_3;
import java.util.List;

public class Grade_3Adapter extends ZhanDianAdapter<Grade_3> {
	private static final String TAG = "三级站点Adapter";
	private Fragment fragment;

	public Grade_3Adapter(Fragment fragment, List<Grade_3> list) {
		super(list);
		this.fragment = fragment;
		Log.d(TAG, getClass().getName());
	}

	public View getView(int position, View view, ViewGroup container) {
		if (view == null)
			view = LayoutInflater.from(this.fragment.getActivity()).inflate(
					R.layout.zhan_dian_item, null);
		((TextView) view.findViewById(R.id.text_title))
				.setText(((Grade_3) getItem(position)).getGrade_3_name());
		return view;
	}
}
