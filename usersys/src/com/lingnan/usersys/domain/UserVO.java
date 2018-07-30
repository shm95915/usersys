package com.lingnan.usersys.domain;

import java.sql.Date;
/**
 * 用户信息类
 * @author asus
 *
 */
public class UserVO {

		private int id;						//主键
		private String userid;			//用户名
		private String uname;		//用户名字
		private String pass;			//密码
		private String email;			//邮箱
		private String power;			//权限
		private Date birth;				//出生日期
		private String status;			//状态
		
		/**
		 * 获取用户编号
		 * @return 返回用户编号
		 */
		public int getId() {
			return id;
		}
		/**
		 * 设置用户编号
		 * @param id 用户编号
		 */
		public void setId(int id) {
			this.id = id;
		}
		
		/**
		 * 获取用户的用户名
		 * @return 用户名
		 */
		public String getUserid() {
			return userid;
		}
		/**
		 * 设置用户名
		 * @param userid 用户名
		 */
		public void setUserid(String userid) {
			this.userid = userid;
		}
		
		/**
		 * 获取用户姓名
		 * @return 用户姓名
		 */
		public String getUname() {
			return uname;
		}
		/**
		 * 设置用户姓名
		 * @param uname 用户姓名
		 */
		public void setUname(String uname) {
			this.uname = uname;
		}
		
		/**
		 * 获取用户密码
		 * @return 用户密码
		 */
		public String getPass() {
			return pass;
		}
		/**
		 * 设置用户密码
		 * @param pass 用户密码
		 */
		public void setPass(String pass) {
			this.pass = pass;
		}
		
		/**
		 * 获取用户邮箱
		 * @return 邮箱
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * 设置用户邮箱
		 * @param email 邮箱
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		
		/**
		 * 获取用户权限
		 * @return 用户权限
		 */
		public String getPower() {
			return power;
		}
		/**
		 * 设置用户权限
		 * @param power 用户权限
		 */
		public void setPower(String power) {
			this.power = power;
		}
		
		/**
		 * 获取用户出生日期
		 * @return 出生日期
		 */
		public Date getBirth() {
			return birth;
		}
		/**
		 * 设置出生日期
		 * @param birth 出生日期
		 */
		public void setBirth(Date birth) {
			this.birth = birth;
		}
		
		/**
		 * 获取用户状态
		 * @return 用户状态
		 */
		public String getStatus() {
			return status;
		}
		/**
		 * 设置用户状态
		 * @param status 用户状态
		 */
		public void setStatus(String status) {
			this.status = status;
		}
		
	
}
