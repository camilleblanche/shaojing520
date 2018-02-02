package com.camille.shaojing.dao;

import java.util.Map;
import java.util.Set;

import com.camille.shaojing.model.User;

public interface IUserDao {
	/**
	 * 新增用户
	 * @param map
	 * @return
	 */
	int addUser(Map<String, Object> map);
	/**
	 * 删除用户
	 * @param map
	 * @return
	 */
	int deleteUser(Map<String, Object> map);
	/**
	 * 修改用户
	 * @param map
	 * @return
	 */
	int updateUser(Map<String, Object> map);
	/**
	 * 通过账号查询用户
	 * @param userName
	 * @return
	 */
	User getUserByAccount(String account);
	
	/**
	 * 通过账号查询角色信息
	 * @param userName
	 * @return
	 */
	Set<String> getRoleSetByAccount(String account);
	
	/**
	 * 通过账号查询权限信息
	 * @param userName
	 * @return
	 */
	Set<String> getPermissionSetByAccount(String account);
}
