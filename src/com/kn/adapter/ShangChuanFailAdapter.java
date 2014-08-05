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

	public Object getItem(int position) {
		return this.failList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View view, ViewGroup viewGroup) {
		FailData data = (FailData) getItem(position);
		if (view == null)
			view = LayoutInflater.from(this.context).inflate(R.layout.shang_chuan_fail_item,
					null);
		TextView tv1 = (TextView) view.findViewById(R.id.text_id);
		TextView tv2 = (TextView) view.findViewById(R.id.text_danJuHao);
		TextView tv3 = (TextView) view.findViewById(R.id.text_saoMiaoLeiXing);
		tv1.setText(String.valueOf(data.getId()));
		tv2.setText(data.getDanJuHao());
		tv3.setText(data.getSaoMiaoLeiXing());
		return view;
	}
}
