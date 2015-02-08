package com.illidan.fireragekit.base;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.illidan.fireragekit.R;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class BaseFragmentActivity extends SherlockFragmentActivity {

	private TextView mTitleTextView;
	private ImageButton mLeftImageButton;
	
	public NavigationController mNavigationController;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		initActionBar();
	}
	
	private void initActionBar() {

		ActionBar actionBar = getSupportActionBar();
		actionBar.setCustomView(R.layout.layout_actionbar);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		
		mLeftImageButton = (ImageButton) findViewById(R.id.actionbar_left_btn);
//		mRightIcon = (ImageView) findViewById(R.id.iv_right_icon);
//		mLeftIcon.setOnClickListener(this);
//		mRightIcon.setOnClickListener(this);
//		
		
		mTitleTextView = (TextView)findViewById(R.id.title_text_view);
	}
	
	public void setTitle(int resid) {
		
		mTitleTextView.setText(resid);
		
	}
	
	public void setActionBarLeftItem(int imageResid, OnClickListener onClickListener) {
		
		mLeftImageButton.setImageResource(imageResid);
		if (onClickListener != null) {
			mLeftImageButton.setOnClickListener(onClickListener);
		}
		
	}	
	
}
