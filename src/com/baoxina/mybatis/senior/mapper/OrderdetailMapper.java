package com.baoxina.mybatis.senior.mapper;

import java.util.List;

import com.baoxina.mybatis.senior.po.Orderdetail;

public interface OrderdetailMapper {
	/**
	 * ���ݶ������� ��ѯ������ϸ�б�
	 */
	public List<Orderdetail> findOrderDetailByOrderIds(Integer id) throws Exception;
}
