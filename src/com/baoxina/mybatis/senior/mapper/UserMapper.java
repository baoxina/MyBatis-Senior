package com.baoxina.mybatis.senior.mapper;

import java.util.List;

import com.baoxina.mybatis.senior.po.User;
import com.baoxina.mybatis.senior.po.UserExt;
import com.baoxina.mybatis.senior.po.UserQueryVo;

public interface UserMapper {
	
	public List<UserExt> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	public User findUserById(int id) throws Exception;
	
	public User findUserByIdResultMap(int id) throws Exception;
	
	
	public List<User> findUserByName(String name)throws Exception;
	
	public void insertUser(User user)throws Exception;
	
	public void deleteUser(int id)throws Exception;
	
	public void updateUser(User user)throws Exception;
}
