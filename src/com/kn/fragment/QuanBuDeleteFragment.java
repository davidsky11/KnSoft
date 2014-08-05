package com.kn.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.kn.R;

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

	public QuanBuDeleteFragment(int layoutId) {
		this.layoutId = layoutId;
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.button_delete:
		case R.id.button_fanHuiZhuJieMian:
			Log.d(TAG, "返回主界面");
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.currentView = inflater.inflate(this.layoutId, container, false);
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
