package com.kn.utils;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.kn.R;
import com.kn.adapter.YiSaoMiaoAdapter;

public final class ListViewUtils {
	public static void listViewYiSaoMiao(Fragment fragment,
			ListView listView) {
		listView.addHeaderView(LayoutInflater.from(
				fragment.getActivity().getApplicationContext()).inflate(
				R.layout.yi_sao_miao_header, null));
		YiSaoMiaoAdapter localYiSaoMiaoAdapter = new YiSaoMiaoAdapter(
				fragment.getActivity().getApplicationContext());
		listView.setAdapter(localYiSaoMiaoAdapter);
		localYiSaoMiaoAdapter.notifyDataSetChanged();
	}
}
