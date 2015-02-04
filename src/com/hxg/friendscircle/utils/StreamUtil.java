package com.hxg.friendscircle.utils;

import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {

	public static String stream2String(InputStream is){
		StringBuffer sb = new StringBuffer();
		int len = 0;
		byte[] buffer = new byte[10240];
		try {
			while((len = is.read(buffer))!=-1){
				sb.append(new String(buffer,0,len));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}
