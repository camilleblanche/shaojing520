package com.camille.shaojing.dao.impl;

import java.util.List;
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
	public int addUser(User user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public int deleteUser(Long[] userIds) {
		return userMapper.deleteBatch(userIds);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User getUserByAccount(String account) {
		return userMapper.getUserByAccount(account);
	}

	@Override
	public Set<String> getRoleSetByUserId(Long userId) {
		return userMapper.getRoleSetByUserId(userId);
	}

	@Override
	public List<String> getPermissionListByUserId(Long userId) {
		return userMapper.getPermissionListByUserId(userId);
	}

}
