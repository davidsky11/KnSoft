package com.kn.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.kn.R;
import com.kn.utils.ListViewUtils;
import com.kn.utils.SaoMiaoUtils;

public class DanBiDeleteFragment extends Fragment implements
		View.OnClickListener {
	private static final String[] SPINNER_DATA = { "1", "2", "3", "4", "5",
			"6", "7" };
	private static final String TAG = "单笔删除Fragment";
	private Button button_back = null;
	private Button button_saomiao = null;
	private View currentView;
	private int layoutId = R.layout.dan_bi_delete;
	private ListView listView_yiSaoMiao = null;
	private ArrayAdapter<String> spinnerAdapter = null;
	private Spinner spinner_caoZuo_type = null;

	public DanBiDeleteFragment() {
	}

	public DanBiDeleteFragment(int layoutId) {
		this.layoutId = layoutId;
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode != 0) {
			Log.e(TAG, "未找到调用者");
			if (resultCode == 0) {
				String str1 = data.getStringExtra("SCAN_RESULT");
				String str2 = data.getStringExtra("SCAN_RESULT_FORMAT");
				Log.e(TAG, "内容：" + str1 + ",格式：" + str2);
				Log.e(TAG, "操作取消");
			}
			return;
		}
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.button_back:
			return;
		case R.id.button_commit:
		default:
			return;
		case R.id.button_saomiao:
			SaoMiaoUtils.startSaoMiao(this);
			return;
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
			Bundle savedInstanceState) {
		this.currentView = inflater.inflate(this.layoutId, viewGroup, false);
		this.currentView.setFocusable(true);
		this.spinner_caoZuo_type = ((Spinner) this.currentView
				.findViewById(R.id.spinner_caoZuo_type));
		this.listView_yiSaoMiao = ((ListView) this.currentView
				.findViewById(R.id.listView_yiSaoMiao));
		this.button_back = ((Button) this.currentView
				.findViewById(R.id.button_back));
		this.button_saomiao = ((Button) this.currentView
				.findViewById(R.id.button_saomiao));
		this.spinnerAdapter = new ArrayAdapter(getActivity(),
				android.R.layout.simple_spinner_item, SPINNER_DATA);
		this.spinnerAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_caoZuo_type.setAdapter(this.spinnerAdapter);
		this.spinner_caoZuo_type.setVisibility(0);
		this.spinner_caoZuo_type
				.setOnItemSelectedListener(new OnItemSelectedListenerImpl());
		this.button_saomiao.setOnClickListener(this);
		this.button_back.setOnClickListener(this);
		ListViewUtils.listViewYiSaoMiao(this, this.listView_yiSaoMiao);
		return this.currentView;
	}

	private class OnItemSelectedListenerImpl implements
			AdapterView.OnItemSelectedListener {
		private OnItemSelectedListenerImpl() {
		}

		public void onItemSelected(AdapterView<?> adapterView, View view,
				int paramInt, long paramLong) {
			Log.d(TAG, ((Adapter) adapterView.getAdapter()).getItem(paramInt)
					.toString());
		}

		public void onNothingSelected(AdapterView<?> paramAdapterView) {
		}
	}
}
