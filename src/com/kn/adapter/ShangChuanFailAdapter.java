package com.kn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kn.R;
import com.kn.entity.FailData;
import java.util.List;

public class ShangChuanFailAdapter extends BaseAdapter {
	private Context context = null;
	private List<FailData> failList = null;

	public ShangChuanFailAdapter(Context context, List<FailData> list) {
		this.context = context;
		this.failList = list;
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

	public View getView(int paramInt, View view, ViewGroup viewGroup) {
		FailData localFailData = (FailData) getItem(paramInt);
		if (view == null)
			view = LayoutInflater.from(this.context).inflate(R.layout.shang_chuan_fail_item,
					null);
		TextView localTextView1 = (TextView) view.findViewById(R.id.text_id);
		TextView localTextView2 = (TextView) view.findViewById(R.id.text_danJuHao);
		TextView localTextView3 = (TextView) view.findViewById(R.id.text_saoMiaoLeiXing);
		localTextView1.setText(String.valueOf(localFailData.getId()));
		localTextView2.setText(localFailData.getDanJuHao());
		localTextView3.setText(localFailData.getSaoMiaoLeiXing());
		return view;
	}
}
