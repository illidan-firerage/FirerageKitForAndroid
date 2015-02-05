package com.illidan.fireragekitdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ColorMenuFragment extends ListFragment {

	private SampleAdapter mAdap;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		String[] colors = getResources().getStringArray(R.array.color_names);
//		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
//				android.R.layout.simple_list_item_1, android.R.id.text1, colors);
//		setListAdapter(colorAdapter);
		
		mAdap = new SampleAdapter(getActivity());
		for (int i = 0; i < 5; i++) {
			mAdap.add(new SampleItem("Sample", android.R.drawable.ic_menu_search));
		}
		setListAdapter(mAdap);
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		case 0:
			newContent = new ColorFragment(R.color.red);
			break;
		case 1:
			newContent = new ColorFragment(R.color.green);
			break;
		case 2:
			newContent = new ColorFragment(R.color.blue);
			break;
		case 3:
			newContent = new ColorFragment(android.R.color.white);
			break;
		case 4:
			newContent = new ColorFragment(android.R.color.black);
			break;
		}
		mAdap.setSelectItem(position);
		mAdap.notifyDataSetChanged();
		
		if (newContent != null)
			switchFragment(newContent);
	}

	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof FragmentChangeActivity) {
			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
			fca.switchContent(fragment);
		}
		
	}
	
	private class SampleItem {
		public String tag;
		public int iconRes;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			if (position == selectItem) {  
				convertView.setBackgroundResource(R.color.red);
            }   
            else {  
            	convertView.setBackgroundResource(R.color.black);
            } 
			
			return convertView;
		}
		
		private int selectItem=0;
		public  void setSelectItem(int selectItem) {  
            this.selectItem = selectItem;  
       }

	}


}
