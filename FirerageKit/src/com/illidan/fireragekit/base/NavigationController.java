package com.illidan.fireragekit.base;

import com.illidan.fireragekit.R;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class NavigationController {

	public BaseFragmentActivity mRootFragmentActivity;
	
	public NavigationController(BaseFragmentActivity rootFragmentActivity) {
		// Required empty public constructor
	}
	
	public void pushFragment(BaseFragment fragment) {
		
//		if (fragment != null && mRootFragmentActivity != null) {
//			FragmentManager fm = mRootFragmentActivity.getSupportFragmentManager();
//			FragmentTransaction ft = fm.beginTransaction();
//			ft.setCustomAnimations(R.animator.slide_enter_from_right, 0, 0,
//					R.animator.slide_exit_from_left);
//			ft.replace(R.id.firstFragment, second, "other");
//			ft.addToBackStack("tag");
//			ft.commit();
//		}
		
	}
	
}
