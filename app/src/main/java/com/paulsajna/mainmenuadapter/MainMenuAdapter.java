package com.paulsajna.mainmenuadapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainMenuAdapter extends ArrayAdapter<String> {

	private LayoutInflater mInflater;
	
	private String[] mTitles;
	private String[] mDescs;
	private TypedArray mIcons;
	private String[] mClasses;
	
	private int mViewResourceId;
	
	public MainMenuAdapter(Context ctx, int viewResourceId,
			String[] titles, String[] descs, TypedArray icons, String[] classes) {
		super(ctx, viewResourceId, titles);
		
		mInflater = (LayoutInflater)ctx.getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		
		mTitles = titles;
		mDescs = descs;
		mIcons = icons;
		mClasses = classes;
		
		mViewResourceId = viewResourceId;
	}

	@Override
	public int getCount() {
		return mTitles.length;
	}

	@Override
	public String getItem(int position) {
		return mClasses[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = mInflater.inflate(mViewResourceId, null);
		
		ImageView iv = (ImageView)convertView.findViewById(R.id.item_icon);
		iv.setImageDrawable(mIcons.getDrawable(position));

		TextView tv = (TextView)convertView.findViewById(R.id.item_title);
		tv.setText(mTitles[position]);
		
		TextView tv2 = (TextView)convertView.findViewById(R.id.item_desc);
		tv2.setText(mDescs[position]);
		
		return convertView;
	}
}
