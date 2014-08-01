package com.kn.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public final class FragmentUtils {

	public static final void popBackStack(FragmentManager paramFragmentManager) {
		paramFragmentManager.popBackStackImmediate();
	}

	public static final void popBackStack(FragmentManager paramFragmentManager,
			String paramString) {
		paramFragmentManager.popBackStackImmediate(paramString, 1);
	}

	public static final void popFragment(FragmentManager paramFragmentManager,
			int paramInt, Fragment paramFragment, String paramString) {
		FragmentTransaction localFragmentTransaction = paramFragmentManager
				.beginTransaction();
		localFragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);	// 17432576, 17432577
		localFragmentTransaction.replace(paramInt, paramFragment, paramString);
		localFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		localFragmentTransaction.addToBackStack(paramString);
		localFragmentTransaction.commit();
	}
}
