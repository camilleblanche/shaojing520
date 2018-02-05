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
	 * 授权(验证权限时调用)
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String account=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(iUserService.getRoleSetByAccount(account));
		authorizationInfo.setStringPermissions(iUserService.getPermissionSetByAccount(account));
		return authorizationInfo;
	}

	@Override
	/**
	 * 认证(登录时调用)
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String account=(String)token.getPrincipal();
		User user=iUserService.getUserByAccount(account);
		if(user!=null){
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getAccount(),user.getPassword(),getClass().getName());
			return authcInfo;
		}else{
			return null;				
		}
	}

}
