package com.hxg.friendscircle.adapter;

import java.util.List;

import cache.loader.ImageWorker;

import com.hxg.friendscircle.activity.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter{

	private List<String> list;
	private Context context;
	public GridAdapter(List<String> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getView(int position, View v, ViewGroup parent) {
		// TODO Auto-generated method stub
		v = LayoutInflater.from(context).inflate(R.layout.gridview_item, null);
		ImageView imageview = (ImageView) v.findViewById(R.id.grid_imageview);
		ImageWorker.getImage(context, list.get(position), imageview, R.drawable.ic_launcher);
		return v;
	}
	
	
}
