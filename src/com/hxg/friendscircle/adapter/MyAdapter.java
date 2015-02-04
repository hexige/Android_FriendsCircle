package com.hxg.friendscircle.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cache.loader.ImageWorker;

import com.hxg.friendscircle.activity.R;
import com.hxg.friendscircle.params.Params;

public class MyAdapter extends BaseAdapter {

	private List<Params> list;
	private Context context;

	public MyAdapter(List<Params> list, Context context) {
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
		final Holder holder;
		if (v == null) {
			holder = new Holder();
			v = LayoutInflater.from(context).inflate(R.layout.listview_item,
					null);
			holder.text_authorname = (TextView) v
					.findViewById(R.id.text_authorname);
			holder.text_content = (TextView) v.findViewById(R.id.text_content);
			holder.text_created = (TextView) v.findViewById(R.id.text_created);
			holder.btn = (Button) v.findViewById(R.id.button1);
			holder.btn1 = (Button) v.findViewById(R.id.btn1);
			holder.btn2 = (Button) v.findViewById(R.id.btn2);
			holder.linear = (LinearLayout) v.findViewById(R.id.linear1);
			holder.imageview = (GridView) v.findViewById(R.id.imageView1);
			holder.text_last = (TextView) v.findViewById(R.id.text_last);
			v.setTag(holder);
		} else {
			holder = (Holder) v.getTag();
		}
		holder.text_authorname.setText(list.get(position).getAuthor_username());
		holder.text_content.setText(list.get(position).getContent());
		holder.text_created.setText(list.get(position).getCreated_at());
		holder.text_last.setText(list.get(position).getLast_up_users());
		holder.btn1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "ÔÞ", 0).show();
			}
		});
		holder.btn2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "ÆÀÂÛ", 0).show();
			}
		});
		holder.btn.setOnClickListener(new View.OnClickListener() {

			private ScaleAnimation animation;

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				animation = new ScaleAnimation(0, 1, 1, 1,
						Animation.RELATIVE_TO_SELF, 1f,
						Animation.RELATIVE_TO_SELF, 1f);
				animation.setDuration(200);
				holder.linear.setVisibility(View.VISIBLE);
				holder.linear.startAnimation(animation);
			}
		});
		if (list.get(position).getUrl().size() == 1) {
			holder.imageview.setNumColumns(1);
			holder.imageview.setAdapter(new GridAdapter(list.get(position)
					.getUrl(), context));
		} else if (list.get(position).getUrl().size() % 2 == 0) {
			holder.imageview.setNumColumns(2);
			holder.imageview.setAdapter(new GridAdapter(list.get(position)
					.getUrl(), context));
		} else if (list.get(position).getUrl().size() % 3 == 0) {
			holder.imageview.setNumColumns(3);
			holder.imageview.setAdapter(new GridAdapter(list.get(position)
					.getUrl(), context));
		}

		return v;
	}

	private class Holder {
		TextView text_authorname, text_content, text_created, text_last;
		GridView imageview;
		Button btn, btn1, btn2;
		LinearLayout linear;
	}

}
