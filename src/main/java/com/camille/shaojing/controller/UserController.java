package com.camille.shaojing.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.camille.shaojing.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService iUserService;
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
}
