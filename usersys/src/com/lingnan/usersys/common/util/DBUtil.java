package com.lingnan.usersys.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lingnan.usersys.common.exception.DaoException;

/**
 * 数据库的工具类
 * 
 * @author asus
 *
 */

public class DBUtil {
	
     private  static String user = "scott" ;  
     private static  String password = "123456" ;  
     private  static String className = "oracle.jdbc.OracleDriver" ;  
     private  static String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl" ;
	private static Connection conn = null;
	
	/**
	 * 获取数据库连接
	 * 
	 * @return 返回获取到的数据库连接
	 */
	public static Connection getConnection() {
	try {
			Class.forName(className);	//加载驱动
			conn = DriverManager.getConnection//建立连接
					(url,user,password);	
		} 	catch (ClassNotFoundException e) {
			//将异常设置为自定义异常类
			throw new DaoException("找不到Oracle的驱动，请查看相应的jar包是否存在", e);
//				System.out.println("找不到Oracle的驱动，请查看相应的jar包是否存在");	
//				e.printStackTrace();
		}	 catch (SQLException e) {
			//将异常设置为自定义异常类
			throw new DaoException("不能建立数据库连接，驱动加载失败。。。", e);	
//			System.out.println("ִ不能建立数据库连接");	
//			e.printStackTrace();
		} 	 
//	System.out.println("数据库连接获取成功......");	
	return conn;
}	
	
	/**
	 * 开启事务
	 * 
	 * @param conn
	 */
	public static void beginTransaction(Connection conn){
		try {
			//将事务的自动提交设置为假
			conn.setAutoCommit(false);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 提交事务
	 * 
	 * @param conn
	 */
	public static void commit(Connection conn){
		try {
			//提交事务
			conn.commit();
			//将事务的自动提交设置为真
			conn.setAutoCommit(true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 事务回滚
	 * 
	 * @param conn
	 */
	public static void rollback(Connection conn){
		try {
			//回滚事务
			conn.rollback();
			//将事务的自动提交设置为真
			conn.setAutoCommit(true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	/**
	 * 关闭所有连接及结果集
	 * 
	 * @param conn
	 * @param prep
	 * @param stat
	 * @param rs
	 */
	public static void closeConnection(Connection conn) {
			try {
			//如果数据库连接对象不为空，关闭该对象
			if(conn != null){
				conn.close();
				conn = null;
				} 	
		}
		catch (SQLException e) {
			//将异常设置为自定义异常类
			throw new DaoException("连接关闭失败", e);
//			System.out.println("连接关闭失败");
//			e.printStackTrace();
		}
	}
	
	public static void closePreparedStatement(PreparedStatement prep) {
		//如果预处理对象不为空，关闭该对象
		try {
			if(prep != null){
				prep.close();
				prep = null;
			}
		} catch (SQLException e) {
			//将异常设置为自定义异常类
			throw new DaoException("预处理对象失败", e);
		}
	}

	
	
	public static void closeResultSet(ResultSet rs){
		//如果查询结果集对象不为空，关闭该对象
					try {
						if(rs != null){
							rs.close();
							rs = null;
						}
					} catch (SQLException e) {
						throw new DaoException("查询结果集关闭失败", e);
					}
				}
	
}
