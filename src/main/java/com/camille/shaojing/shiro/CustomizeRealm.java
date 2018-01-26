package com.camille.shaojing.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.camille.shaojing.model.User;
import com.camille.shaojing.service.IUserService;

public class CustomizeRealm extends AuthorizingRealm{
	@Autowired
	private IUserService iUserService;
	@Override
	/**
	 * 为当限前登录的用户授予角色和权限
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(iUserService.getRoles(userName));
		authorizationInfo.setStringPermissions(iUserService.getPermissions(userName));
		return authorizationInfo;
	}

	@Override
	/**
	 * 验证当前登录的用户
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String)token.getPrincipal();
		User user=iUserService.getByUserName(userName);
		if(user!=null){
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getNickName(),user.getLoginPassword(),"realmName");
			return authcInfo;
		}else{
			return null;				
		}
	}

}
