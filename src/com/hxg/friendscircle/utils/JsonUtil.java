package com.hxg.friendscircle.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.hxg.friendscircle.params.Params;

public class JsonUtil {

	public static List<Params> parseJson(String json) throws Exception{
		List<Params> list = new ArrayList<Params>();
		List<String> last_up_userslist = null;
		List<String> url = null;
		Params params = null;
		
		JSONObject object = new JSONObject(json);
		JSONArray data = object.getJSONArray("data");
		for (int i = 0; i < data.length(); i++) {
			JSONObject obj = data.getJSONObject(i);
			params = new Params();
			params.setContent(obj.getString("content"));
			params.setCreated_at(obj.getString("created_at"));
			JSONObject author = obj.getJSONObject("author");
			params.setAuthor_username(author.getString("username"));
			JSONArray attachments = obj.getJSONArray("attachments");
			url = new ArrayList<String>();
			for (int j = 0; j < attachments.length(); j++) {
				JSONObject attachmentsobj = attachments.getJSONObject(j);
				url.add(attachmentsobj.getString("url"));
			}
			params.setUrl(url);
			JSONArray last_up_users = obj.getJSONArray("last_up_users");
			last_up_userslist = new ArrayList<String>();
			for (int j = 0; j < last_up_users.length(); j++) {
				JSONObject last_up_usersobj = last_up_users.getJSONObject(j);
				last_up_userslist.add(last_up_usersobj.getString("username"));
			}
			params.setLast_up_users(last_up_userslist);
			list.add(params);
			params = null;
			last_up_userslist = null;
			url = null;
		}
		
		return list;
	}
}
