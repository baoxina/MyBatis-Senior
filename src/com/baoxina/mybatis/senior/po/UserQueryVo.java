package com.baoxina.mybatis.senior.po;

import java.util.List;

public class UserQueryVo {
	
	private User user;
	
	private UserExt userExt;
	
	private List<Integer> ids;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public UserExt getUserExt() {
		return userExt;
	}

	public void setUserExt(UserExt userExt) {
		this.userExt = userExt;
	}
}
