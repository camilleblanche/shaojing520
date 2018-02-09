package com.camille.shaojing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/homepage")
public class HomepageController {
	/**
	 * 初始化页面
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String init() {
		return "module/homepage";
	}
}
