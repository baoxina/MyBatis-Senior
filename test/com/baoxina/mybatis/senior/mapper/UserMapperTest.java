package com.baoxina.mybatis.senior.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.baoxina.mybatis.senior.po.User;

public class UserMapperTest {

	// sqlSessionFactory创建单例的对象
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources
				.getResourceAsStream("mybatis/SqlMapConfig.xml"));
	}

	/**
	 * 一级缓存测试，无需配置，默认开启一级缓存
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCache1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 下边查询使用一个SqlSession
		// 第一次发起请求，查询id为1的用户
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);

		// 如果sqlSession去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。

		// 更新user1的信息
		user1.setUsername("测试用户22");
		userMapper.updateUser(user1);
		// 执行commit操作去清空缓存
		sqlSession.commit();

		// 第二次发起请求，查询id为1的用户
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);

		sqlSession.close();

	}

	// 二级缓存测试
	/**
	 * 1.需要在MyBatis核心配置文件中配置<setting name="cacheEnabled" value="true"/>
	 * 2.需要在要开启二级缓存的的mapper.xml文件中配置 <cache/>   开启mapper的namespace下的二级缓存
	 * 3.如果某个select的statement不需要使用二级缓存，则需设置statement的usecache属性为false,默认为true
	 * 4.如果某个insert/update/delete的statement执行后不需要刷新缓存，则需设置statement的flushCache属性为false,默认为true
	 * @throws Exception
	 */
	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		// 第一次发起请求，查询id为1的用户
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);

		// 这里执行关闭操作，将sqlsession中的数据写到二级缓存区域
		sqlSession1.close();

		// 使用sqlSession3执行commit()操作
		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		User user = userMapper3.findUserById(1);
		user.setUsername("哈哈哈");
		userMapper3.updateUser(user);
		// 执行提交，清空UserMapper下边的二级缓存
		sqlSession3.commit();
		sqlSession3.close();

		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		// 第二次发起请求，查询id为1的用户
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);

		sqlSession2.close();

	}

}
