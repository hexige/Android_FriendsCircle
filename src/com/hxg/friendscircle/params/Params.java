package com.hxg.friendscircle.params;

import java.util.List;

public class Params {

	private String content;
	private String created_at;
	private String author_username;
	private List<String> url;
	private List<String> last_up_users;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getAuthor_username() {
		return author_username;
	}

	public void setAuthor_username(String author_username) {
		this.author_username = author_username;
	}

	public List<String> getUrl() {
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

//	public List<String> getLast_up_users() {
//		return last_up_users;
//	}

	public void setLast_up_users(List<String> last_up_users) {
		this.last_up_users = last_up_users;
	}

	public String getLast_up_users(){
		StringBuffer sb = new StringBuffer();
		for (String str : last_up_users) {
			sb.append(str);
			sb.append("   ");
		}
		return sb.toString();
	}
	@Override
	public String toString() {
		return "Params [content=" + content + ", created_at=" + created_at
				+ ", author_username=" + author_username + ", url=" + url
				+ ", last_up_users=" + last_up_users + "]";
	}

}
