package com.baoxina.mybatis.senior.mapper;

import java.util.List;

import com.baoxina.mybatis.senior.po.Orders;
import com.baoxina.mybatis.senior.po.OrdersExt;
import com.baoxina.mybatis.senior.po.User;


public interface OrderMapperExt {
	/**
	 * 查询[订单] <关联> 查询[用户]   使用resultType  一对一
	 */
	public List<OrdersExt> findOrdersUser() throws Exception;
	/**
	 * 查询[订单] <关联> 查询[用户]   使用resultMap   一对一 ： 使用association实现
	 */
	public List<Orders> findOrdersUserUseResultMap() throws Exception;
	/**
	 * 查询[订单] <关联> [用户]及[订单明细]   使用resultMap 一对多：使用collection实现
	 */
	public List<Orders> findOrdersAndOrderDetailResultMap()throws Exception;
	
	/**
	 * 查询[用户] <关联> 查询[商品信息]
	 * 
	 * 分析；
	 * 		查询主表是：用户表
	 * 		关联表：由于用户和商品没有直接关联，通过订单和订单明细进行关联，所以关联表如下：
	 * 		orders、orderdetail、items
	 */
	public List<User> findUserAndItemsResultMap()throws Exception;
	
	/**
	 * 查询[订单] <关联> 查询[用户]，用户信息<延迟加载使用association>的配置
	 */
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
	/**
	 * 查询[订单] <关联> 查询[订单明细]，订单明细<延迟加载使用collection>的配置
	 */
	public List<Orders> findOrdersDetailLazyLoading() throws Exception;
}
