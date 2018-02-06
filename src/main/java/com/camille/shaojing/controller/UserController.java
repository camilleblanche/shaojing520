package com.camille.shaojing.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import com.camille.shaojing.model.User;
import com.camille.shaojing.service.IUserService;
import com.camille.shaojing.util.CryptographyUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Log LOG = LogFactory.getLog(UserController.class);
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
	public Map<String, Object> addUser(@RequestBody Map<String, Object> map){
		return iUserService.addUser(map);
	}
	/**
	 * 删除用户
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteuser",method=RequestMethod.POST)
	public Map<String, Object> deleteUser(@RequestBody Map<String, Object> map){
		return iUserService.deleteUser(map);
	}
	/**
	 * 修改用户
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public Map<String, Object> updateUser(@RequestBody Map<String, Object> map){
		return iUserService.updateUser(map);
	}

	/**
	 * 用户登录
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request){
		Subject subject=SecurityUtils.getSubject();
		String passwordEn = CryptographyUtils.shiroMd5(user.getPassword());
		UsernamePasswordToken token=new UsernamePasswordToken(user.getAccount(), passwordEn);
		try{
			subject.login(token);//会跳到自定义realm中
			Session session=subject.getSession();
			LOG.info("sessionId:"+session.getId());
			LOG.info("sessionHost:"+session.getHost());
			LOG.info("sessionTimeout:"+session.getTimeout());
			session.setAttribute("info", "session的数据");
			return "redirect:/success.jsp";
		}catch (UnknownAccountException e) {
			e.printStackTrace();
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", e.getMessage());
			return "index";
		}catch (IncorrectCredentialsException e) {
			e.printStackTrace();
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", e.getMessage());
			return "index";
		}catch (LockedAccountException e) {
			e.printStackTrace();
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", e.getMessage());
			return "index";
		}catch (AuthenticationException e) {
			e.printStackTrace();
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "账户验证失败");
			return "index";
		}
	}
}
