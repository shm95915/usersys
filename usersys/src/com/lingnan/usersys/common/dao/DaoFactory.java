package com.lingnan.usersys.common.dao;

import java.sql.Connection;

import com.lingnan.usersys.common.exception.ServiceException;

import com.lingnan.usersys.business.dao.UserDaoImpl;

/**
 * 工厂方法
 * @author asus
 *
 */

public class DaoFactory {

	
	public static BaseDao getDao(Connection conn,String type){
		//如果传入的dao类型是用户user，就实例化用户dao实现类
		if("user".equals(type)){
			//返回实例化的dao对象
			return new UserDaoImpl(conn);
		}
//		else if("order".equals(type)){
//			return new OrderDaoImpl(conn);
//		}
		//如果没有和以上指定类型匹配的值，就提示错误信息
		else{
			throw new ServiceException("dao工厂方法出错");
		}
	}
}
