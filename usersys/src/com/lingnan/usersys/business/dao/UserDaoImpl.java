package com.lingnan.usersys.business.dao;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.util.DBUtil;
import com.lingnan.usersys.common.util.TypeUtil;
import com.lingnan.usersys.domain.UserVO;

/**
 * 用户dao实现类
 * @author asus
 *
 */
public class UserDaoImpl implements BaseDao{
		/**
		 * 数据库连接
		 */
		private Connection conn;
		
		/**
		 * 
		 * @param conn 数据库连接
		 */
		public UserDaoImpl(Connection conn){
			//给属性赋初值
			this.conn = conn;
		}
		
		/**
		 * 注册用户/添加用户
		 * @param user 用户信息
		 * @return 成功返回真，失败返回假
		 */
		public boolean addUser(UserVO user){
			boolean flag=false;
			//定义预编译对象
			PreparedStatement ptmt = null;
			//赋初值
			String userid = user.getUserid();
			String uname = user.getUname();
			String pass = user.getPass();
			String email = user.getEmail();
			String power = user.getPower();
			try {
				ptmt = conn.prepareStatement
						("insert into m_user(userid,uname,pass,email,power,status)"
								+ "values(?,?,?,?,?,0)");
				ptmt.setString(1, userid);
				ptmt.setString(2, uname);
				ptmt.setString(3, pass);
				ptmt.setString(4, email);
				ptmt.setString(5, power);
				ptmt.executeUpdate();
				flag = true;
				System.out.println("注册成功");
			} catch (SQLException e) {
				//将异常改为自定义异常类	
				throw new DaoException("注册用户/添加用户 出现异常", e);
			}finally{
				DBUtil.closePreparedStatement(ptmt);
			}
			return flag;
		}
		
		/**
		 * 用户登录
		 * @param userid 用户名
		 * @param pass 密码
		 * @return 用户信息
		 */
		public UserVO login(String userid,String pass){
			//定义结果集
			ResultSet rs = null;
			//定义预编译对象
			PreparedStatement ptmt = null;
			//定义返回值对象
			UserVO user = null;
			
			try {
				ptmt = conn.prepareStatement
						("select * from m_user where userid=? and pass=?");
				ptmt.setString(1, userid);
				ptmt.setString(2, pass);
				rs = ptmt.executeQuery();
				if(rs.next()){
					user = new UserVO();
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("email"));
					user.setBirth(rs.getDate("birth"));
					user.setPower(rs.getString("power"));
					user.setUname(rs.getString("uname"));
					user.setStatus(rs.getString("status"));
					user.setUserid(rs.getString("userid"));
					user.setPass(rs.getString("pass"));
				}
//				System.out.println(user.getEmail()+user.getPower());
				System.out.println("登录成功");
			} catch (SQLException e) {
				//将异常改为自定义异常类
				throw new DaoException("用户登录异常，请输入正确的账号和密码",e);
			}finally{
				DBUtil.closeResultSet(rs);
				DBUtil.closePreparedStatement(ptmt);
			}
			
			return user;
		}
		
	
}
