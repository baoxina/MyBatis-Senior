package com.baoxina.mybatis.senior.po;

/**
 * 此类映射订单和用户的查询结果，继承较多的po
 * @author baoxina
 *
 */
public class OrdersExt extends Orders {

	//添加用户属性
	private String username;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
