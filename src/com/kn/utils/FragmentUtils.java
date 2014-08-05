package com.kn.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public final class FragmentUtils {

	public static final void popBackStack(FragmentManager fm) {
		fm.popBackStackImmediate();
	}

	public static final void popBackStack(FragmentManager fm, String str) {
		fm.popBackStackImmediate(str, 1);
	}

	public static final void popFragment(FragmentManager fm, int id,
			Fragment fragment, String str) {
		FragmentTransaction ft = fm.beginTransaction();
		ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
		ft.replace(id, fragment, str);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		ft.addToBackStack(str);
		ft.commit();
	}
}
