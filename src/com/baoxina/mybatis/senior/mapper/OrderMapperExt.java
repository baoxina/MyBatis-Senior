package com.baoxina.mybatis.senior.mapper;

import java.util.List;

import com.baoxina.mybatis.senior.po.Orders;
import com.baoxina.mybatis.senior.po.OrdersExt;
import com.baoxina.mybatis.senior.po.User;


public interface OrderMapperExt {
	/**
	 * ��ѯ[����] <����> ��ѯ[�û�]   ʹ��resultType  һ��һ
	 */
	public List<OrdersExt> findOrdersUser() throws Exception;
	/**
	 * ��ѯ[����] <����> ��ѯ[�û�]   ʹ��resultMap   һ��һ �� ʹ��associationʵ��
	 */
	public List<Orders> findOrdersUserUseResultMap() throws Exception;
	/**
	 * ��ѯ[����] <����> [�û�]��[������ϸ]   ʹ��resultMap һ�Զࣺʹ��collectionʵ��
	 */
	public List<Orders> findOrdersAndOrderDetailResultMap()throws Exception;
	
	/**
	 * ��ѯ[�û�] <����> ��ѯ[��Ʒ��Ϣ]
	 * 
	 * ������
	 * 		��ѯ�����ǣ��û���
	 * 		�����������û�����Ʒû��ֱ�ӹ�����ͨ�������Ͷ�����ϸ���й��������Թ��������£�
	 * 		orders��orderdetail��items
	 */
	public List<User> findUserAndItemsResultMap()throws Exception;
	
	/**
	 * ��ѯ[����] <����> ��ѯ[�û�]���û���Ϣ<�ӳټ���ʹ��association>������
	 */
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
	/**
	 * ��ѯ[����] <����> ��ѯ[������ϸ]��������ϸ<�ӳټ���ʹ��collection>������
	 */
	public List<Orders> findOrdersDetailLazyLoading() throws Exception;
}
