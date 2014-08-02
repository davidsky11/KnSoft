package com.kn.entity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class ZhanDianAdapter<T> extends BaseAdapter {
	private static final String TAG = "站点Adapter";
	private List<T> zhanDianList;

	public ZhanDianAdapter(List<T> paramList) {
		Log.d("站点Adapter", getClass().getName());
		this.zhanDianList = paramList;
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
