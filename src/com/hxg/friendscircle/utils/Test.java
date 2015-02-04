package com.hxg.friendscircle.utils;

import java.io.InputStream;
import java.util.List;

import android.test.AndroidTestCase;

import com.hxg.friendscircle.params.Params;

public class Test extends AndroidTestCase{

	public void test() throws Exception{
		InputStream is = HttpUtil.getCon("http://192.172.10.252/rss.php");
		String str = StreamUtil.stream2String(is);
		List<Params> list = JsonUtil.parseJson(str);
		for (Params params : list) {
			System.out.println("```````"+params.toString());
		}
	}
}
