package com.camille.shaojing.dao.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camille.shaojing.dao.IUserDao;
import com.camille.shaojing.mapper.UserMapper;
import com.camille.shaojing.model.User;
@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	private UserMapper userMapper;
	@Override
	public int addUser(Map<String, Object> map) {
		return userMapper.insertSelective(map);
	}

	@Override
	public int deleteUser(Map<String, Object> map) {
		return userMapper.deleteByPrimaryKey(map);
	}

	@Override
	public int updateUser(Map<String, Object> map) {
		return userMapper.updateByPrimaryKeySelective(map);
	}

	@Override
	public User getByUserName(String userName) {
		return userMapper.getByUserName(userName);
	}

	@Override
	public Set<String> getRoles(String userName) {
		return userMapper.getRoles(userName);
	}

	@Override
	public Set<String> getPermissions(String userName) {
		return userMapper.getPermissions(userName);
	}

}
