package com.baoxina.mybatis.senior.mapper;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.baoxina.mybatis.senior.po.Orderdetail;
import com.baoxina.mybatis.senior.po.Orders;
import com.baoxina.mybatis.senior.po.OrdersExt;
import com.baoxina.mybatis.senior.po.User;

public class OrderMapperExtTest {

	//sqlSessionFactory创建单例的对象
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/SqlMapConfig.xml"));
	}

	@Test
	public void testFindOrdersUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapperExt mapper = sqlSession.getMapper(OrderMapperExt.class);
		List<OrdersExt> list = mapper.findOrdersUser();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersUserUseResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapperExt mapper = sqlSession.getMapper(OrderMapperExt.class);
		List<Orders> list = mapper.findOrdersUserUseResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapperExt mapper = sqlSession.getMapper(OrderMapperExt.class);
		List<Orders> list = mapper.findOrdersAndOrderDetailResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void testfindUserAndItemsResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapperExt mapper = sqlSession.getMapper(OrderMapperExt.class);
		List<User> list = mapper.findUserAndItemsResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void findOrdersUserLazyLoading() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapperExt mapper = sqlSession.getMapper(OrderMapperExt.class);
		List<Orders> list = mapper.findOrdersUserLazyLoading();
		
		if(list != null && list.size() > 0){
			for(Orders order : list){
				User user = order.getUser();
				System.out.println(user);
			}
		}
		sqlSession.close();
	}
	
	
	@Test
	public void findOrdersDetailLazyLoading() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapperExt mapper = sqlSession.getMapper(OrderMapperExt.class);
		List<Orders> list = mapper.findOrdersDetailLazyLoading();
		if(list != null && list.size() > 0){
			for(Orders order :list){
				List<Orderdetail> orderdetails = order.getOrderdetails();
				System.out.println(orderdetails);
			}
		}
		sqlSession.close();
	}
}