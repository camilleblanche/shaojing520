package com.camille.shaojing.service;

import java.util.Map;

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
}
