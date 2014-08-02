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
	private int layoutId = 2130903043;
	private ListView listView_yiSaoMiao = null;
	private ArrayAdapter<String> spinnerAdapter = null;
	private Spinner spinner_caoZuo_type = null;

	public DanBiDeleteFragment() {
	}

/*	public DanBiDeleteFragment(int paramInt) {
		this.layoutId = paramInt;
	}*/

	public void onActivityResult(int paramInt1, int paramInt2,
			Intent paramIntent) {
		super.onActivityResult(paramInt1, paramInt2, paramIntent);
		if (paramInt1 != 0)
			Log.e(TAG, "未找到调用者");
		/*do {
			return;
			if (paramInt2 != -1)
				continue;
			String str1 = paramIntent.getStringExtra("SCAN_RESULT");
			String str2 = paramIntent.getStringExtra("SCAN_RESULT_FORMAT");
			Log.e("单笔删除Fragment", "内容：" + str1 + ",格式：" + str2);
			return;
		} while (paramInt2 != 0);
		Log.e("单笔删除Fragment", "操作取消");*/
	}

	public void onClick(View paramView) {
		switch (paramView.getId()) {
			case R.id.button_back:
				return;
			case R.id.button_commit:
			default:
				return;
			case R.id.button_saomiao:
		}
		SaoMiaoUtils.startSaoMiao(this);
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
	}

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		this.currentView = paramLayoutInflater.inflate(this.layoutId,
				paramViewGroup, false);
		this.currentView.setFocusable(true);
		this.spinner_caoZuo_type = ((Spinner) this.currentView
				.findViewById(2131099678));
		this.listView_yiSaoMiao = ((ListView) this.currentView
				.findViewById(2131099679));
		this.button_back = ((Button) this.currentView.findViewById(2131099681));
		this.button_saomiao = ((Button) this.currentView
				.findViewById(2131099680));
		this.spinnerAdapter = new ArrayAdapter(getActivity(), 17367048,
				SPINNER_DATA);
		this.spinnerAdapter.setDropDownViewResource(17367049);
		this.spinner_caoZuo_type.setAdapter(this.spinnerAdapter);
		this.spinner_caoZuo_type.setVisibility(0);
		/*this.spinner_caoZuo_type
				.setOnItemSelectedListener(new OnItemSelectedListenerImpl(null));*/
		this.button_saomiao.setOnClickListener(this);
		this.button_back.setOnClickListener(this);
		ListViewUtils.listViewYiSaoMiao(this, this.listView_yiSaoMiao);
		return this.currentView;
	}

	private class OnItemSelectedListenerImpl implements
			AdapterView.OnItemSelectedListener {
		private OnItemSelectedListenerImpl() {
		}

		public void onItemSelected(AdapterView<?> paramAdapterView,
				View paramView, int paramInt, long paramLong) {
			Log.d("单笔删除Fragment", ((Adapter) paramAdapterView.getAdapter())
					.getItem(paramInt).toString());
		}

		public void onNothingSelected(AdapterView<?> paramAdapterView) {
		}
	}
}

/*
 * Location: C:\Users\davidsky\Desktop\AUTOID7\AutoidPDA_22336439500900.jar
 * Qualified Name: com.seuic.fragment.DanBiDeleteFragment JD-Core Version: 0.6.0
 */