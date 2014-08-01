package com.kn.fragment;

import com.kn.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ValidFragment")
public class TiaoMaSaoMiaoFragment extends Fragment {
	
	private int layoutId = R.layout.excels;

	public TiaoMaSaoMiaoFragment() {
		
	}

	public TiaoMaSaoMiaoFragment(int layoutId) {
		this.layoutId = layoutId;
	}

	public View onCreateView(LayoutInflater layoutInflater,
			ViewGroup viewGroup, Bundle bundle) {
		return layoutInflater
				.inflate(this.layoutId, viewGroup, false);
	}
}
