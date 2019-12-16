/**
 * @filename UserInfoController.java
 * @author lg
 * @date 2018年1月11日 下午5:13:54
 * @version 1.0
 * Copyright (C) 2018 
 */

package com.auth.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.auth.entity.UserInfo;
import com.auth.service.UserInfoService;

/**
 * 用户管理控制类
 * @author lg
 * @date  2018-01-11
 */
@Controller
public class UserInfoController {
	//注入用户service业务接口
	@Autowired
	UserInfoService userInfoService;
	
	/**
	 * 用户登录
	 * @param user 用户对象
	 * @return mod对象
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,UserInfo user){
		UserInfo nuser=userInfoService.login(user);
		if(nuser!=null){//用户登录成功
			request.getSession().setAttribute("sessionUser", nuser);
			ModelAndView mod=new ModelAndView("index");
			return mod;
		}else{
			//登录失败
			ModelAndView mod=new ModelAndView("error");
			return mod;
		}
	}
	
}
