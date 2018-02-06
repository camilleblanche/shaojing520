package com.camille.shaojing.mapper;

import java.util.List;
import java.util.Set;

import com.camille.shaojing.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);
    
    int deleteBatch(Long[] userIds);
    
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User getUserByAccount(String account);
	
	Set<String> getRoleSetByUserId(Long userId);
	
	List<String> getPermissionListByUserId(Long userId);
}