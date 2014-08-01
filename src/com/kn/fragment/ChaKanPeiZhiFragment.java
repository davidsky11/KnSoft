package com.kn.fragment;

import com.kn.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class ChaKanPeiZhiFragment extends Fragment {

	private static final String TAG = "查看配置Fragment";
	private Button button_back_ckpz;
	private View currentView;
	private int layoutId = R.layout.cha_kan_pei_zhi;

	public ChaKanPeiZhiFragment() {

	}

	public ChaKanPeiZhiFragment(int layoutId) {
		this.layoutId = layoutId;
	}

	public void onCreate(Bundle paramBundle) {
		Log.d(TAG, "*onCreate");
		super.onCreate(paramBundle);
	}

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		Log.d(TAG, "*onCreateView");
		this.currentView = paramLayoutInflater.inflate(this.layoutId,
				paramViewGroup, false);
		this.currentView.setFocusable(true);
		Log.d(TAG, "*focus:" + this.currentView.isFocusable());
		this.button_back_ckpz = ((Button) this.currentView
				.findViewById(R.id.button_back_ckpz));
		Log.d(TAG,
				"*button_back_ckpz focus:"
						+ this.button_back_ckpz.isFocusable());
		this.button_back_ckpz.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				Log.d(TAG, "*button_back_ckpz");
			}
		});
		return this.currentView;
	}

	public void onDestroy() {
		Log.d(TAG, "*onDestroy");
		super.onDestroy();
	}

	public void onPause() {
		Log.d(TAG, "*onPause");
		super.onPause();
	}

	public void onResume() {
		Log.d(TAG, "*onResume");
		super.onResume();
	}

	public void onStart() {
		Log.d(TAG, "*onStart");
		super.onStart();
	}

	public void onStop() {
		Log.d(TAG, "*onStop");
		super.onStop();
	}

	public void onViewCreated(View paramView, Bundle paramBundle) {
		Log.d(TAG, "*onViewCreated");
		super.onViewCreated(paramView, paramBundle);
	}
}
