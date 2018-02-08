package com.camille.shaojing.shiro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.camille.shaojing.model.User;
import com.camille.shaojing.service.IUserService;
import com.camille.shaojing.util.BaseUtils;

public class CustomizeRealm extends AuthorizingRealm{
	@Autowired
	private IUserService iUserService;
	@Override
	/**
	 * 授权(验证权限时调用)
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user=(User)principals.getPrimaryPrincipal();
		Long userId= user.getUserId();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(iUserService.getRoleSetByUserId(userId));
		List<String> permissionList = iUserService.getPermissionListByUserId(userId);
		Set<String> permissionSet=new HashSet<>();
		for (String permission : permissionList) {
			if(BaseUtils.isBlank(permission)) {
				continue;
			}
			permissionSet.addAll(Arrays.asList(permission.trim().split(",")));
		}
		authorizationInfo.setStringPermissions(permissionSet);
		return authorizationInfo;
	}

	@Override
	/**
	 * 认证(登录时调用)
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String account=(String)token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		User user=iUserService.getUserByAccount(account);
		 //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号不存在");
        }
        //密码错误
        if(!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("密码不正确");
        }
        //账号锁定
        if("02".equals(user.getState())){
        	throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
		AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user, password,getName());
		return authcInfo;
	}

}
