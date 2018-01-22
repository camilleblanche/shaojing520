package com.camille.shaojing.dao;

import java.util.Map;

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
}
