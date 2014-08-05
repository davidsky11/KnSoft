package com.kn.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kn.R;

public class BaseFragment extends Fragment {
	
	private int layoutId = R.layout.excels;

	public BaseFragment() {
		
	}

	public BaseFragment(int layoutId) {
		this.layoutId = layoutId;
	}

	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		return inflater
				.inflate(this.layoutId, container, false);
	}
}
