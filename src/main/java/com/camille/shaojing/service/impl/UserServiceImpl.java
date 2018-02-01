package com.camille.shaojing.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.camille.shaojing.dao.IUserDao;
import com.camille.shaojing.model.User;
import com.camille.shaojing.service.IUserService;
import com.camille.shaojing.util.BaseUtils;
import com.camille.shaojing.util.CryptographyUtils;
@Service
@CacheConfig(cacheNames="user")
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao iUserDao;
	@Override
	public Map<String, Object> addUser(Map<String, Object> map) {
		Map<String, Object> rtnMap=new HashMap<String, Object>();
		Object loginPassword = map.get("loginPassword");
		if(BaseUtils.isNotNull(loginPassword)) {
			String loginPasswordEn = CryptographyUtils.springMd5Encode(loginPassword.toString());
			map.put("loginPassword", loginPasswordEn);
		}
		int result=iUserDao.addUser(map);
		if(result==1) {
			rtnMap.put("success",true);
			rtnMap.put("message","新增用户成功");
		}else {
			rtnMap.put("success",false);
			rtnMap.put("message","新增用户失败");
		}
		return rtnMap;
	}

	@Override
	public Map<String, Object> deleteUser(Map<String, Object> map) {
		Map<String, Object> rtnMap=new HashMap<String, Object>();
		int result=iUserDao.deleteUser(map);
		if(result==1) {
			rtnMap.put("success",true);
			rtnMap.put("message","删除用户成功");
		}else {
			rtnMap.put("success",false);
			rtnMap.put("message","删除用户失败");
		}
		return rtnMap;
	}

	@Override
	@CachePut(keyGenerator = "customKeyGenerator")
	public Map<String, Object> updateUser(Map<String, Object> map) {
		Map<String, Object> rtnMap=new HashMap<String, Object>();
		Object loginPassword = map.get("loginPassword");
		if(BaseUtils.isNotNull(loginPassword)) {
			String loginPasswordEn = CryptographyUtils.springMd5Encode(loginPassword.toString());
			map.put("loginPassword", loginPasswordEn);
		}
		int result=iUserDao.updateUser(map);
		if(result==1) {
			rtnMap.put("success",true);
			rtnMap.put("message","修改用户成功");
		}else {
			rtnMap.put("success",false);
			rtnMap.put("message","修改用户失败");
		}
		return rtnMap;
	}

	@Override
	public User getByUserName(String userName) {
		return iUserDao.getByUserName(userName);
	}

	@Override
	public Set<String> getRoles(String userName) {
		return iUserDao.getRoles(userName);
	}

	@Override
	public Set<String> getPermissions(String userName) {
		return iUserDao.getPermissions(userName);
	}
}
