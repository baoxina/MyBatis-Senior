package com.baoxina.mybatis.senior.mapper;

import java.util.List;

import com.baoxina.mybatis.senior.po.Orderdetail;

public interface OrderdetailMapper {
	/**
	 * 根据订单主键 查询订单明细列表
	 */
	public List<Orderdetail> findOrderDetailByOrderIds(Integer id) throws Exception;
}
