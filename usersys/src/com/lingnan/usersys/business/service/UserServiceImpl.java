package com.lingnan.usersys.business.service;

import java.rmi.ServerException;
import java.sql.Connection;

import com.lingnan.usersys.business.dao.UserDao;
import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtil;
import com.lingnan.usersys.domain.UserVO;

public class UserServiceImpl implements UserService {

	/**
	 * 用户service类实例，在类的内部创建唯一的实例
	 */
	private static UserService userService = new UserServiceImpl();
	/**
	 * 构造方法私有化
	 */
	private UserServiceImpl(){
		
	}
	
	public static UserService getInstance(){
		return userService;
	}
	
	public UserVO login(String userid,String pass){
		//声明连接数据库的对象
		Connection conn = null;
		UserVO user = null;
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtil.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用dao中的login方法，进行登录操作，结果赋值给登录结果变量
			user = userDao.login(userid, pass);
		} catch (DaoException e) {
			throw e;
		} catch(Exception e){
			throw new ServiceException("登录出现错误",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return user;
	}
}
