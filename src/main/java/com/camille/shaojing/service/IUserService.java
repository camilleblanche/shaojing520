package com.camille.shaojing.service;

import java.util.Map;
import java.util.Set;

import com.camille.shaojing.model.User;

public interface IUserService {
	/**
	 * 新增用户
	 * @param map
	 * @return
	 */
	Map<String, Object> addUser(Map<String, Object> map);
	/**
	 * 删除用户
	 * @param map
	 * @return
	 */
	Map<String, Object> deleteUser(Map<String, Object> map);
	/**
	 * 修改用户
	 * @param map
	 * @return
	 */
	Map<String, Object> updateUser(Map<String, Object> map);
	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	User getByUserName(String userName);
	
	/**
	 * 通过用户名查询角色信息
	 * @param userName
	 * @return
	 */
	Set<String> getRoles(String userName);
	
	/**
	 * 通过用户名查询权限信息
	 * @param userName
	 * @return
	 */
	Set<String> getPermissions(String userName);
}
