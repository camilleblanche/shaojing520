package com.camille.shaojing.dao;

import java.util.List;
import java.util.Set;

import com.camille.shaojing.model.User;

public interface IUserDao {
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	int deleteUser(Long[] userIds);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * 通过账号查询用户
	 * @param userName
	 * @return
	 */
	User getUserByAccount(String account);
	/**
	 * 通过userId查询角色信息
	 * @param userId
	 * @return
	 */
	Set<String> getRoleSetByUserId(Long userId);
	
	/**
	 * 通过userId查询权限信息
	 * @param userId
	 * @return
	 */
	List<String> getPermissionListByUserId(Long userId);
}
