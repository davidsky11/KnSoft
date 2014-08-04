package com.kn.fragment;

import com.kn.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ChangYongGongJuFragment extends Fragment {
	
	private int layoutId = R.layout.budgets;

	public ChangYongGongJuFragment() {
		
	}
	
	public ChangYongGongJuFragment(int layoutId) {
		this.layoutId = layoutId;
	}

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		return paramLayoutInflater
				.inflate(this.layoutId, paramViewGroup, false);
	}
}
