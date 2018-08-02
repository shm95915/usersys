package com.lingnan.usersys.business.dao;

import java.util.Date;
import java.util.List;
import java.util.Vector;
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
		 * 用户添加
		 * @param user 用户信息
		 * @return flag ture or false
		 **/
		public boolean addUser(UserVO user) {
			//声明预编译对象变量，用于进行数据库操作的载体
			PreparedStatement prep = null;
			//声明结果集对象变量，用于保存数据库查询结果
//			int rs = -1;
		    //声明用户对象变量，用于保存从结果集中提取出来的数据
			boolean flag = false;
			String uname = user.getUname();
			String userid = user.getUserid();
			String pass = user.getPass();
			String email = user.getEmail();
			String power = user.getPower();
			try {
				     prep = conn.prepareStatement
				    		 ("insert into m_user(userid,pass,uname,  email, power,  status) values( ?,?, ?, ?, ?, 1)"); 
				     prep.setString(1, userid);     
			         prep.setString(2, pass);
			         prep.setString(3, uname);
			         prep.setString(4, email);
			         prep.setString(5, power);
			        
				     prep.executeUpdate();
				     flag = true;
//				     if(rs > 0) {
//				    	 return true;
//				     }else {
//				    	 return false;
//				     }
			 }catch (SQLException e) {
					System.out.println("SQL语言运行错误");
					e.printStackTrace();
			    }finally {
			    	//调用DBUtil类中的closeStatement方法关闭结果集对象和预编译对象
			    	DBUtil.closePreparedStatement(prep);
			    }
			return flag;
//			if(user != null) {
//				return true;
//			}else {
//				return false;
//			}
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
//			System.out.println(userid+pass);
			try {
				ptmt = conn.prepareStatement
						("select * from m_user where userid=? and pass=? and status=0");
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
				//调用DBUtil类中的close方法关闭结果集对象和预编译对象
				DBUtil.closeResultSet(rs);
				DBUtil.closePreparedStatement(ptmt);
			}
			
			return user;
		}
		
		
		/**
		 * 通过ID查找用户
		 * @param id 用户编号
		 * @return 用户信息
		 */
		public UserVO findUserById(int id){
			//定义结果集
			ResultSet rs = null;
			//定义预编译对象
			PreparedStatement ptmt = null;
			//定义返回值对象
			UserVO user = null;
			try {
				ptmt = conn.prepareStatement
						("select * from m_user where id=?");
				ptmt.setInt(1, id);
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
//					System.out.println("查找到的用户信息如下：");
				}
				else {
					System.out.println("查无此id的用户");
				}
			} catch (SQLException e) {
				//将异常改为自定义异常类
				throw new DaoException("查找用户失败，请确认id是否输入正确",e);
			}finally{
				//调用DBUtil类中的close方法关闭结果集对象和预编译对象
				DBUtil.closeResultSet(rs);
				DBUtil.closePreparedStatement(ptmt);
			}
			
			return user;
		}
		
		/**
		 * 通过用户姓名名查找用户
		 * @param uname 用户姓名名
		 * @return 用户信息
		 */
		public UserVO findUserByUname(String uname){
			//定义结果集
			ResultSet rs = null;
			//定义预编译对象
			PreparedStatement ptmt = null;
			//定义返回值对象
			UserVO user = null;
			try {
				ptmt = conn.prepareStatement
						("select * from m_user where uname=?");
				ptmt.setString(1, uname);
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
//					System.out.println("查找到的用户信息如下：");
				}
				else {
					System.out.println("查无此姓名的用户");
				}
			} catch (SQLException e) {
				//将异常改为自定义异常类
				throw new DaoException("查找用户失败，请确认用户姓名是否输入正确",e);
			}finally{
				//调用DBUtil类中的close方法关闭结果集对象和预编译对象
				DBUtil.closeResultSet(rs);
				DBUtil.closePreparedStatement(ptmt);
			}
			
			return user;
		}
		
		/**
		 * 查询全部用户信息
		 * @param pageNo 页码
		 * @param pageSize 一个页面显示多少条信息
		 * @return 用户信息
		 */
		public Vector<UserVO> selectUser(int pageNo,  int pageSize) {
			//声明预编译对象变量，用于进行数据库操作的载体
			PreparedStatement ptmt = null;
			//声明结果集对象变量，用于保存数据库查询结果
			ResultSet rs = null;
		    //声明用户对象变量，用于保存从结果集中提取出来的数据
			Vector<UserVO> v = new Vector<UserVO>();
			try {
				ptmt = conn.prepareStatement("select * from(select t2.*,rownum rn from (select t1.* from m_user t1 order by id) t2) " +
						"where rn>? and rn<=?");
				//调用预编译对象的setXxx方法，给？号赋值
				ptmt.setInt(1,(pageNo-1)*pageSize);
				ptmt.setInt(2,pageNo*pageSize);
			         rs = ptmt.executeQuery();
				while(rs.next()) {
					UserVO user = new UserVO();
					user.setId(rs.getInt("id"));
					user.setUname(rs.getString("uname"));
					user.setPass(rs.getString("pass"));
					user.setEmail(rs.getString("email"));
					user.setPower(rs.getString("power"));
					v.add(user);
				}
				
			 }catch (SQLException e1) {
					System.out.println("SQL语言运行错误");
					e1.printStackTrace();
			    }finally {
			    	//调用DBUtil类中的close方法关闭结果集对象和预编译对象
					DBUtil.closeResultSet(rs);
					DBUtil.closePreparedStatement(ptmt);
			    }
			return v;
		}
		
		
		/**
		 * 更新用户信息
		 * @param user 更新前的用户信息
		 * @return  更新后的用户信息
		 */
		public boolean updateUser(UserVO user){
			//声明返回值变量
			boolean flag = false;
			//定义预编译对象
			PreparedStatement ptmt = null;
			int id = user.getId();
			String uname = user.getUname();
			String pass = user.getPass();
			String email = user.getEmail();
			try {
				ptmt = conn.prepareStatement
						("update m_user set uname=?,email=?,pass = ? where id = ?");
				ptmt.setString(1, uname);
				ptmt.setString(2, email);
				ptmt.setString(3, pass);
				ptmt.setInt(4, id);
				ptmt.executeUpdate();
				flag = true;
			} catch (SQLException e) {
				//将异常改为自定义异常类
				throw new DaoException("用户信息更新失败",e);
			}
			return flag;
		}
		
		/**
		 * 删除用户
		 * @param id 用户编号
		 * @return 删除成功返回真，否则返回假
		 */
		public boolean deleteUser(int id){
			//声明返回值变量
			boolean flag = false;
			//定义预编译对象
			PreparedStatement ptmt = null;
			try {
				ptmt = conn.prepareStatement
						("delete from m_user where id =?");
				ptmt.setInt(1, id);
				ptmt.executeUpdate();
				flag = true;
			} catch (SQLException e) {
				//将异常改为自定义异常类
				throw new DaoException("用户删除失败",e);
			}			
		return flag;
		}
		
		/**
		 * 查找所有有效用户，即status= 0；
		 * @return 用户信息
		 */
		public UserVO findAllValid(){
			//定义结果集
			ResultSet rs = null;
			//定义预编译对象
			PreparedStatement ptmt = null;
			//定义返回值对象
			UserVO user = null;
			try {
				ptmt = conn.prepareStatement
						("select * from m_user where status='"+0+"' ");
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
//					System.out.println("查找到的用户信息如下：");
				}
			} catch (SQLException e) {
				//将异常改为自定义异常类
				throw new DaoException("查找用户失败",e);
			}finally{
				//调用DBUtil类中的close方法关闭结果集对象和预编译对象
				DBUtil.closeResultSet(rs);
				DBUtil.closePreparedStatement(ptmt);
			}
			
			return user;
		}
	
}
