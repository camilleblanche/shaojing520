package com.camille.shaojing.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.camille.shaojing.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Map<String, Object> map);

    int insert(User record);

    int insertSelective(Map<String, Object> map);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(Map<String, Object> map);

    int updateByPrimaryKey(User record);
    
	User getUserByAccount(String account);
	
	Set<String> getRoleSetByUserId(Long userId);
	
	List<String> getPermissionListByUserId(Long userId);
}