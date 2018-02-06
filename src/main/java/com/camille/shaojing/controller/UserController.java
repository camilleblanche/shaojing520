package com.camille.shaojing.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.camille.shaojing.model.R;
import com.camille.shaojing.model.User;
import com.camille.shaojing.service.IUserService;
import com.camille.shaojing.util.CryptographyUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService iUserService;
	/**
	 * 初始化页面
	 * @return
	 */
	@RequestMapping(value="/init",method=RequestMethod.GET)
	public String init() {
		return "/module/demo";
	}
	/**
	 * 新增用户
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public R addUser(@RequestBody User user){
		return R.put(iUserService.addUser(user));
	}
	/**
	 * 删除用户
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteuser",method=RequestMethod.POST)
	public R deleteUser(@RequestBody Long[] userIds){
		return R.put(iUserService.deleteUser(userIds));
	}
	/**
	 * 修改用户
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public R updateUser(@RequestBody User user){
		return R.put(iUserService.updateUser(user));
	}

	/**
	 * 用户登录
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public R login(@RequestBody User user,HttpServletRequest request){
		Subject subject=SecurityUtils.getSubject();
		String account=user.getAccount();
		String passwordEn = CryptographyUtils.shiroMd5(user.getPassword());
		UsernamePasswordToken token=new UsernamePasswordToken(account, passwordEn);
		try{
			subject.login(token);//会跳到自定义realm中
			Session session=subject.getSession();//包含sessionId,hostAddress,timeout等信息
			session.setAttribute("user", iUserService.getUserByAccount(account));
			return R.ok();
		}catch (UnknownAccountException e) {
			return R.error(e.getMessage());
		}catch (IncorrectCredentialsException e) {
			return R.error(e.getMessage());
		}catch (LockedAccountException e) {
			return R.error(e.getMessage());
		}catch (AuthenticationException e) {
			return R.error("账户验证失败");
		}
	}
	/**
	 * 用户退出
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:login.jsp";
	}
}
