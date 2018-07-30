package com.lingnan.usersys.business.service;

import com.lingnan.usersys.domain.UserVO;

public interface UserService {

	/**
	 * 用户登录
	 * @param userid 用户名
	 * @param pass 密码
	 * @return 返回用户信息
	 */
	public UserVO login(String userid,String pass);
	
}
