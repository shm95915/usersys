package com.lingnan.usersys.business.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtil;
import com.lingnan.usersys.domain.UserVO;

public class UserDaoImplTest {

	@Test
	public void testAddUser() {
		Connection connection = DBUtil.getConnection();
		UserDaoImpl udilDaoImpl = new UserDaoImpl(connection);
		UserVO u = new UserVO();
		u.setUserid("zs");
		u.setUname("张三");
		u.setPass("zs");
		u.setEmail("1348qq@67.com");
		u.setPower("普通用户");
//		u.setBirth(null);
//		u.setStatus(null);
		System.out.println(udilDaoImpl.addUser(u));
	}

	@Test
	public void testLogin() {
		Connection connection = DBUtil.getConnection();
		UserDaoImpl udilDaoImpl = new UserDaoImpl(connection);
		UserVO u =udilDaoImpl.login("scott", "123456");
		System.out.print(u.getId()+"			"+u.getUname()+"			"+u.getEmail()
				+"			"+u.getPower()+"			"+u.getBirth()+"			"+u.getStatus());
	}

}
