package com.lingnan.usersys.controller;

import java.util.Vector;

import com.lingnan.usersys.business.service.UserService;
import com.lingnan.usersys.business.service.UserServiceImpl;
import com.lingnan.usersys.domain.UserVO;

public class UserController {

	//声明用户service接口对象，用于业务处理
	UserService userService = UserServiceImpl.getInstance();
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO doLogin(String userid,String pass){
		UserVO user = null;
//		System.out.println("--2--"+userid+pass);
		try {
			//调用用户service接口中的login方法，进行用户登录操作
			user=userService.login(userid, pass);
		} catch (Exception e) {
			// 显示异常信息
			System.out.println("用户登录的时候出错了"+e.getMessage());
		}
		return user;
	}
	/**
	 * 用户添加
	 * @param user 用户信息
	 * @return 用户信息
	 */
	public boolean doaddUser(UserVO user){
		boolean flag = false;
		try {
			//调用用户service接口中的register方法，进行用户注册操作
			flag = userService.register(user);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户添加的时候出错了"+e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 用户注册
	 * @param user 用户信息
	 * @return 用户信息
	 */
	public boolean doregister(UserVO user) {
		boolean flag = false;
		try {
			//调用用户service接口中的register方法，进行用户注册操作
			flag = userService.register(user);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户注册的时候出错了"+e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 删除用户
	 * @param id 用户编号
	 * @return 删除成功返回真，否则返回假
	 */
	public boolean dodeleteUser(int id){
		boolean flag = false;
		try {
			//调用用户service接口中的deleteUserById方法，进行用户删除操作
			flag = userService.deleteUser(id);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户删除的时候出错了"+e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 根据ID查询用户信息
	 * @param _id 用户ID
	 * @return 用户信息
	 */
	public UserVO doFindUserById(int id) {
		UserVO user = null;
		try {
			//调用用户service接口中的login方法，进行用户登录操作
		     user = userService.findUserById(id);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户查询的时候出错了"+e.getMessage());
		}
		return user;
	}
	
	/**
	 * 通过用户姓名名查找用户
	 * @param uname 用户姓名名
	 * @return 用户信息
	 */
	public UserVO dofindUserByUname(String uname){
		UserVO user = null;
		try {
			//调用用户service接口中的login方法，进行用户登录操作
		     user = userService.findUserByUname(uname);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户查询的时候出错了"+e.getMessage());
		}
		return user;
	}
	
	/**
	 * 查询全部用户信息
	 * @param pageNo 页码
	 * @param pageSize 页面大小(一页有多少条信息)
	 * @return 用户信息
	 */
	public Vector<UserVO> doSelect(int pageNo,  int pageSize) {
		Vector<UserVO> v = new Vector<UserVO>();
		try {
			//调用用户service接口中的login方法，进行用户登录操作
		     v = userService.selectUser(pageNo, pageSize);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户查询的时候出错了"+e.getMessage());
		}
		return v;
	}
	
	/**
	 * 更新用户信息
	 * @param user 更新前的用户信息
	 * @return  更新后的用户信息
	 */
	public boolean doupdateUser(UserVO user){
		boolean flag = false;
		try {
			//调用用户service接口中的register方法，进行用户注册操作
			flag = userService.updateUser(user);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户修改的时候出错了"+e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 删除用户
	 * @param id 用户编号
	 * @return 删除成功返回真，否则返回假
	 */
	public boolean doDeleteUser(int id){
		boolean flag = false;
		try {
			//调用用户service接口中的deleteUserById方法，进行用户删除操作
			flag = userService.deleteUser(id);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户删除的时候出错了"+e.getMessage());
		}
		return flag;
	}
}
