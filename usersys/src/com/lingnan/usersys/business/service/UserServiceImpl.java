package com.lingnan.usersys.business.service;

import java.rmi.ServerException;
import java.sql.Connection;
import java.util.Vector;

import com.lingnan.usersys.business.dao.UserDao;
import com.lingnan.usersys.business.dao.UserDaoImpl;
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
	/**
	 * 用户登录
	 * @param userid 用户名
	 * @param pass 密码
	 * @return 用户信息
	 */
	public UserVO login(String userid,String pass){
		//声明预编译对象变量，用于进行数据库操作的载体
 		Connection conn = null;
 		UserVO user = null;
 		try {
 			     //调用数据库getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
 			     conn = DBUtil.getConnection();
// 			     System.out.println(conn);
 			     //调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
 			     UserDaoImpl userMgrDao = (UserDaoImpl) DaoFactory.getDao(conn, EnumType.USER_DAO);
 			     //调用dao中的login方法，进行登录操作，结果赋值给登录结果变量
//		 		 System.out.println("--3--"+userid);
 			     user = userMgrDao.login(userid, pass);
 		 }catch (DaoException e) {
 			//将自定义异常抛出
 			 throw e;
		    }catch (Exception e) {
		    	//将异常封装成自定义异常并抛出
		    	throw new ServiceException("用户登录错误",e);		

 		    }finally {
 		    	//调用DBUtil类中的closeConnection方法关闭连接对象
 		    	DBUtil.closeConnection(conn);
 				
 		    }
 		//返回用户登录结果
 		return user;
	}
	
	/**
	 * 注册用户/添加用户
	 * @param user
	 * @return 成功返回真，失败返回假
	 */
 	public boolean register(UserVO user) {
 		//声明预编译对象变量，用于进行数据库操作的载体
 		Connection conn = null;
 		boolean flag = false;
 		try {
 			     //调用数据库getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
 			     conn = DBUtil.getConnection();
 			     //调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
 			    UserDaoImpl userMgrDao = (UserDaoImpl)DaoFactory.getDao(conn, EnumType.USER_DAO);
 			     //调用数据库工具类中的beginTransaction方法，开启事务
 			     DBUtil.beginTransaction(conn);
 			     //设置用户为普通用户
 			     user.setPower("普通用户");
 			     //调用dao的addUser方法，进行数据插入操作，结果赋值给插入结果变量
 			     flag = userMgrDao.addUser(user);
 			     //调用数据库工具类中的committ方法，提交事务
 			     DBUtil.commit(conn);
 		 }catch (DaoException e) {
 			//将自定义异常抛出
 			 throw e;
		    }catch (Exception e) {
		    	//调用数据库工具类中的rollback方法，回滚事务
		    	DBUtil.rollback(conn);
		    	//将异常封装成自定义异常并抛出
		    	throw new ServiceException("用户注册错误",e);		    	
 		    }finally {
 		    	//调用DBUtil类中的closeConnection方法关闭连接对象
 		    	DBUtil.closeConnection(conn);
 				
 		    }
 		//返回用户注册结果
 		return flag;
 	}
	
 	/**
	 * 通过ID查找用户
	 * @param id 用户编号
	 * @return 用户信息
	 */
	public UserVO findUserById(int id){
		//声明预编译对象变量，用于进行数据库操作的载体
 		Connection conn = null;
 		UserVO user = null;
 		try {
 			     //调用数据库getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
 			     conn = DBUtil.getConnection();
 			     //调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
 			    UserDaoImpl userMgrDao = (UserDaoImpl)DaoFactory.getDao(conn, EnumType.USER_DAO);
 			     //调用dao中的selectUserById方法，进行查询操作，结果赋值给查询结果变量
 			     user = userMgrDao.findUserById(id);
 		 }catch (DaoException e) {
 			//将自定义异常抛出
 			 throw e;
		    }catch (Exception e) {
		    	//将异常封装成自定义异常并抛出
		    	throw new ServiceException("用户查询错误",e);		    	
 		    }finally {
 		    	//调用DBUtil类中的closeConnection方法关闭连接对象
 		    	DBUtil.closeConnection(conn);
 				
 		    }
 		//返回用户登录结果
 		return user;
	}
	
	/**
	 * 通过用户姓名名查找用户
	 * @param uname 用户姓名名
	 * @return 用户信息
	 */
	public UserVO findUserByUname(String uname){
		//声明预编译对象变量，用于进行数据库操作的载体
 		Connection conn = null;
 		UserVO user = null;
 		try {
 			     //调用数据库getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
 			     conn = DBUtil.getConnection();
 			     //调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
 			    UserDaoImpl userMgrDao = (UserDaoImpl)DaoFactory.getDao(conn, EnumType.USER_DAO);
 			     //调用dao中的selectUserById方法，进行查询操作，结果赋值给查询结果变量
 			     user = userMgrDao.findUserByUname(uname);
 		 }catch (DaoException e) {
 			//将自定义异常抛出
 			 throw e;
		    }catch (Exception e) {
		    	//将异常封装成自定义异常并抛出
		    	throw new ServiceException("用户查询错误",e);		    	
 		    }finally {
 		    	//调用DBUtil类中的closeConnection方法关闭连接对象
 		    	DBUtil.closeConnection(conn);
 				
 		    }
 		//返回用户登录结果
 		return user;
	}
 	
	/**
	 * 查询全部用户信息
	 * @param pageNo 页码
	 * @param pageSize 一个页面显示多少条信息
	 * @return 用户信息
	 */
	public Vector<UserVO> selectUser(int pageNo,  int pageSize){
		Vector<UserVO> v = new Vector<UserVO>();
 		//声明预编译对象变量，用于进行数据库操作的载体
 		Connection conn = null;
 		try {
 			     //调用数据库getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
 			     conn = DBUtil.getConnection();
 			     //调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
 			    UserDaoImpl userMgrDao = (UserDaoImpl)DaoFactory.getDao(conn, EnumType.USER_DAO);
 			     //调用dao中的selectUserById方法，进行查询操作，结果赋值给查询结果变量
 			     v = userMgrDao.selectUser(pageNo, pageSize);
 		 }catch (DaoException e) {
 			//将自定义异常抛出
 			 throw e;
		    }catch (Exception e) {
		    	//将异常封装成自定义异常并抛出
		    	throw new ServiceException("用户查询错误",e);		    	
 		    }finally {
 		    	//调用DBUtil类中的closeConnection方法关闭连接对象
 		    	DBUtil.closeConnection(conn);
 				
 		    }
 		//返回用户登录结果
 		return v;
	}
		
	/**
	 * 更新用户信息
	 * @param user 更新前的用户信息
	 * @return  更新后的用户信息
	 */
	public boolean updateUser(UserVO user){
		//声明预编译对象变量，用于进行数据库操作的载体
 		Connection conn = null;
 		boolean flag = false;
 		try {
 			     //调用数据库getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
 			     conn = DBUtil.getConnection();
 			     //调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
 			    UserDaoImpl userMgrDao = (UserDaoImpl)DaoFactory.getDao(conn, EnumType.USER_DAO);
 			     //调用数据库工具类中的beginTransaction方法，开启事务
 			     DBUtil.beginTransaction(conn);
 			     //调用dao的addUser方法，进行数据插入操作，结果赋值给插入结果变量
 			     flag = userMgrDao.updateUser(user);
 			     //调用数据库工具类中的committ方法，提交事务
 			     DBUtil.commit(conn);
 		 }catch (DaoException e) {
 			//将自定义异常抛出
 			 throw e;
		    }catch (Exception e) {
		    	//调用数据库工具类中的rollback方法，回滚事务
		    	DBUtil.rollback(conn);
		    	//将异常封装成自定义异常并抛出
		    	throw new ServiceException("用户注册错误",e);		    	
 		    }finally {
 		    	//调用DBUtil类中的closeConnection方法关闭连接对象
 		    	DBUtil.closeConnection(conn);
 				
 		    }
 		//返回用户注册结果
 		return flag;
	}
	
	/**
	 * 删除用户
	 * @param id 用户编号
	 * @return 删除成功返回真，否则返回假
	 */
	public boolean deleteUser(int id){
		//声明预编译对象变量，用于进行数据库操作的载体
 		Connection conn = null;
 		boolean flag = false;
 		try {
 			     //调用数据库getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
 			     conn = DBUtil.getConnection();
 			     //调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
 			    UserDaoImpl userMgrDao = (UserDaoImpl)DaoFactory.getDao(conn, EnumType.USER_DAO);
 			     //调用数据库工具类中的beginTransaction方法，开启事务
 			     DBUtil.beginTransaction(conn);
 			     //调用dao的deleteUserById方法，进行数据删除操作，结果赋值给插入结果变量
 			     flag = userMgrDao.deleteUser(id);
 			     //调用数据库工具类中的committ方法，提交事务
 			     DBUtil.commit(conn);
 		 }catch (DaoException e) {
 			//将自定义异常抛出
 			 throw e;
		    }catch (Exception e) {
		    	//调用数据库工具类中的rollback方法，回滚事务
		    	DBUtil.rollback(conn);
		    	//将异常封装成自定义异常并抛出
		    	throw new ServiceException("用户删除错误",e);		    	
 		    }finally {
 		    	//调用DBUtil类中的closeConnection方法关闭连接对象
 		    	DBUtil.closeConnection(conn);
 				
 		    }
 		//返回用户删除结果
 		return flag;
	}
	
	/**
	 * 查找所有有效用户，即status= 0；
	 * @return 用户信息
	 */
	public UserVO findAllValid(){
		//声明预编译对象变量，用于进行数据库操作的载体
 		Connection conn = null;
 		UserVO user =null;
 		try {
 			     //调用数据库getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
 			     conn = DBUtil.getConnection();
 			     //调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
 			    UserDaoImpl userMgrDao = (UserDaoImpl)DaoFactory.getDao(conn, EnumType.USER_DAO);
 			     //调用dao中的selectUserById方法，进行查询操作，结果赋值给查询结果变量
 			     user = userMgrDao.findAllValid();
 		 }catch (DaoException e) {
 			//将自定义异常抛出
 			 throw e;
		    }catch (Exception e) {
		    	//将异常封装成自定义异常并抛出
		    	throw new ServiceException("用户查询错误",e);		    	
 		    }finally {
 		    	//调用DBUtil类中的closeConnection方法关闭连接对象
 		    	DBUtil.closeConnection(conn);
 				
 		    }
 		//返回用户登录结果
 		return user;
	}
	
}
