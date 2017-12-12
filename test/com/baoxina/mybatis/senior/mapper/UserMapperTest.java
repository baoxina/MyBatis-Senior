package com.baoxina.mybatis.senior.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.baoxina.mybatis.senior.po.User;

public class UserMapperTest {

	// sqlSessionFactory���������Ķ���
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources
				.getResourceAsStream("mybatis/SqlMapConfig.xml"));
	}

	/**
	 * һ��������ԣ��������ã�Ĭ�Ͽ���һ������
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCache1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();// �����������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// �±߲�ѯʹ��һ��SqlSession
		// ��һ�η������󣬲�ѯidΪ1���û�
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);

		// ���sqlSessionȥִ��commit������ִ�в��롢���¡�ɾ���������SqlSession�е�һ�����棬��������Ŀ��Ϊ���û����д洢�������µ���Ϣ�����������

		// ����user1����Ϣ
		user1.setUsername("�����û�22");
		userMapper.updateUser(user1);
		// ִ��commit����ȥ��ջ���
		sqlSession.commit();

		// �ڶ��η������󣬲�ѯidΪ1���û�
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);

		sqlSession.close();

	}

	// �����������
	/**
	 * 1.��Ҫ��MyBatis���������ļ�������<setting name="cacheEnabled" value="true"/>
	 * 2.��Ҫ��Ҫ������������ĵ�mapper.xml�ļ������� <cache/>   ����mapper��namespace�µĶ�������
	 * 3.���ĳ��select��statement����Ҫʹ�ö������棬��������statement��usecache����Ϊfalse,Ĭ��Ϊtrue
	 * 4.���ĳ��insert/update/delete��statementִ�к���Ҫˢ�»��棬��������statement��flushCache����Ϊfalse,Ĭ��Ϊtrue
	 * @throws Exception
	 */
	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		// �����������
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		// ��һ�η������󣬲�ѯidΪ1���û�
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);

		// ����ִ�йرղ�������sqlsession�е�����д��������������
		sqlSession1.close();

		// ʹ��sqlSession3ִ��commit()����
		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		User user = userMapper3.findUserById(1);
		user.setUsername("������");
		userMapper3.updateUser(user);
		// ִ���ύ�����UserMapper�±ߵĶ�������
		sqlSession3.commit();
		sqlSession3.close();

		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		// �ڶ��η������󣬲�ѯidΪ1���û�
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);

		sqlSession2.close();

	}

}
