package com.kn.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class ZhanDianAdapter<T> extends BaseAdapter {
	private static final String TAG = "站点Adapter";
	private List<T> zhanDianList;

	public ZhanDianAdapter(List<T> list) {
		Log.d(TAG, getClass().getName());
		this.zhanDianList = list;
	}

	public int getCount() {
		return this.zhanDianList.size();
	}

	public Object getItem(int paramInt) {
		return this.zhanDianList.get(paramInt);
	}

	public long getItemId(int paramInt) {
		return paramInt;
	}

	public abstract View getView(int paramInt, View paramView,
			ViewGroup paramViewGroup);
}
