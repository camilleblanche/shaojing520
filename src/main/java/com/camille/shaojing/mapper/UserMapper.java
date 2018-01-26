package com.camille.shaojing.mapper;

import java.util.Map;
import java.util.Set;

import com.camille.shaojing.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Map<String, Object> map);

    int insert(User record);

    int insertSelective(Map<String, Object> map);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Map<String, Object> map);

    int updateByPrimaryKey(User record);
    
	User getByUserName(String userName);
	
	Set<String> getRoles(String userName);
	
	Set<String> getPermissions(String userName);
}