package com.hxg.friendscircle.activity;

import java.io.InputStream;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;

import com.hxg.friendscircle.adapter.MyAdapter;
import com.hxg.friendscircle.params.Params;
import com.hxg.friendscircle.utils.HttpUtil;
import com.hxg.friendscircle.utils.JsonUtil;
import com.hxg.friendscircle.utils.StreamUtil;

public class MainActivity extends Activity {

	private ListView listview;
	private Context context;
	private MyAdapter adapter;
	private List<Params> list;
	private static final String URL = "http://www.yasite.net/rss.php";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;

		init();

		new Thread() {
			public void run() {
				try {
					InputStream is = HttpUtil.getCon(URL);
					list = JsonUtil.parseJson(StreamUtil.stream2String(is));
					handler.sendEmptyMessage(1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();
	}

	private void init() {
		// TODO Auto-generated method stub
		listview = (ListView) findViewById(R.id.listView1);
		TextView tv = new TextView(context);
		tv.setText("test");
		listview.addHeaderView(LayoutInflater.from(context).inflate(
				R.layout.listview_header, null));
	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 1) {
				adapter = new MyAdapter(list, context);
				listview.setAdapter(adapter);
			}
		};
	};
}
