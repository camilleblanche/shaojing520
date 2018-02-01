package com.camille.shaojing.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
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
		return "/demo/demo";
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
		UsernamePasswordToken token=new UsernamePasswordToken(user.getNickName(), user.getLoginPassword());
		try{
			subject.login(token);
			Session session=subject.getSession();
			System.out.println("sessionId:"+session.getId());
			System.out.println("sessionHost:"+session.getHost());
			System.out.println("sessionTimeout:"+session.getTimeout());
			session.setAttribute("info", "session的数据");
			return "redirect:/success.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "index";
		}
	}
}
