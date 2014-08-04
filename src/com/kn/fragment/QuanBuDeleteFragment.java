package com.kn.fragment;

import com.kn.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class QuanBuDeleteFragment extends Fragment implements
		View.OnClickListener {
	private static final String TAG = "全部删除Fragment";
	private Button button_delete = null;
	private Button button_fanHuiZhuJieMian = null;
	private View currentView;
	private EditText edit_password = null;
	private int layoutId = R.layout.quan_bu_delete;

	public QuanBuDeleteFragment() {
	}

	public QuanBuDeleteFragment(int paramInt) {
		this.layoutId = paramInt;
	}

	public void onActivityResult(int paramInt1, int paramInt2,
			Intent paramIntent) {
		super.onActivityResult(paramInt1, paramInt2, paramIntent);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.button_delete:
		case R.id.button_fanHuiZhuJieMian:
		}
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
	}

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		this.currentView = paramLayoutInflater.inflate(this.layoutId,
				paramViewGroup, false);
		this.currentView.setFocusable(true);
		this.edit_password = ((EditText) this.currentView
				.findViewById(R.id.edit_password));
		this.button_delete = ((Button) this.currentView
				.findViewById(R.id.button_delete));
		this.button_fanHuiZhuJieMian = ((Button) this.currentView
				.findViewById(R.id.button_fanHuiZhuJieMian));
		this.button_delete.setOnClickListener(this);
		this.button_fanHuiZhuJieMian.setOnClickListener(this);
		return this.currentView;
	}
}
