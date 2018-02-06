package com.camille.shaojing.service;

import java.util.List;
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
