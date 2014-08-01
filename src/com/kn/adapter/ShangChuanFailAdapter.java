package com.kn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.kn.entity.FailData;
import java.util.List;

public class ShangChuanFailAdapter extends BaseAdapter {
	private Context context = null;
	private List<FailData> failList = null;

	public ShangChuanFailAdapter(Context paramContext, List<FailData> paramList) {
		this.context = paramContext;
		this.failList = paramList;
	}

	public int getCount() {
		return this.failList.size();
	}

	public Object getItem(int paramInt) {
		return this.failList.get(paramInt);
	}

	public long getItemId(int paramInt) {
		return paramInt;
	}

	public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
		FailData localFailData = (FailData) getItem(paramInt);
		if (paramView == null)
			paramView = LayoutInflater.from(this.context).inflate(2130903064,
					null);
		TextView localTextView1 = (TextView) paramView.findViewById(2131099731);
		TextView localTextView2 = (TextView) paramView.findViewById(2131099732);
		TextView localTextView3 = (TextView) paramView.findViewById(2131099733);
		localTextView1.setText(String.valueOf(localFailData.getId()));
		localTextView2.setText(localFailData.getDanJuHao());
		localTextView3.setText(localFailData.getSaoMiaoLeiXing());
		return paramView;
	}
}

/*
 * Location: C:\Users\davidsky\Desktop\AUTOID7\AutoidPDA_22336439500900.jar
 * Qualified Name: com.seuic.adapter.ShangChuanFailAdapter JD-Core Version:
 * 0.6.0
 */