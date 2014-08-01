package com.kn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.kn.entity.ShouJian;
import java.util.ArrayList;
import java.util.List;

public class YiSaoMiaoAdapter extends BaseAdapter {
	private Context context = null;
	private List<ShouJian> shouJianList = null;

	public YiSaoMiaoAdapter(Context paramContext) {
		this.context = paramContext;
		this.shouJianList = new ArrayList();
		for (int i = 0;; i++) {
			if (i >= 5)
				return;
			ShouJian localShouJian = new ShouJian();
			localShouJian.setId(i);
			localShouJian.setTiaoma("11-22-33-44-" + i + i);
			this.shouJianList.add(localShouJian);
		}
	}

	public int getCount() {
		return this.shouJianList.size();
	}

	public Object getItem(int paramInt) {
		return this.shouJianList.get(paramInt);
	}

	public long getItemId(int paramInt) {
		return paramInt;
	}

	public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
		ShouJian localShouJian = (ShouJian) getItem(paramInt);
		if (paramView == null)
			paramView = LayoutInflater.from(this.context).inflate(2130903071,
					null);
		((TextView) paramView.findViewById(2131099754)).setText(localShouJian
				.getTiaoma());
		return paramView;
	}
}
