package com.lingnan.usersys.controller;

import com.lingnan.usersys.business.service.UserService;
import com.lingnan.usersys.business.service.UserServiceImpl;
import com.lingnan.usersys.domain.UserVO;

public class UserController {

	//声明用户service接口对象，用于业务处理
	UserService userService = UserServiceImpl.getInstance();
	
	public UserVO doLogin(String userid,String pass){
		UserVO user = null;
		try {
			//调用用户service接口中的login方法，进行用户登录操作
			user=userService.login(userid, pass);
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("用户登录的时候出错了"+e.getMessage());
		}
		return user;
	}
	
}
