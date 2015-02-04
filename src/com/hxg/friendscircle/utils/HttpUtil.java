package com.hxg.friendscircle.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtil {

	private static final int TIMEOUT = 5000;
	
	public static InputStream getCon(String path){
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setReadTimeout(TIMEOUT);
			conn.setConnectTimeout(TIMEOUT);
			conn.setDoInput(true);
			if(conn.getResponseCode() == 200){
				return conn.getInputStream();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
