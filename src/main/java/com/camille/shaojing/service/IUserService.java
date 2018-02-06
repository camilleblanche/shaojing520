package com.camille.shaojing.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.camille.shaojing.model.User;

public interface IUserService {
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	Map<String, Object> addUser(User user);
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	Map<String, Object> deleteUser(Long[] userIds);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	Map<String, Object> updateUser(User user);
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
