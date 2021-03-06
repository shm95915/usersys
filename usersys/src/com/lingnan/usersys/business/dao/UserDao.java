package com.lingnan.usersys.business.dao;

import java.util.List;
import java.util.Vector;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.domain.UserVO;
/**
 * 用户dao接口
 * @author asus
 *
 */
public interface UserDao extends BaseDao{

		/**
		 * 注册用户/添加用户
		 * @param user
		 * @return 成功返回真，失败返回假
		 */
		public boolean addUser(UserVO user);
		/**
		 * 用户登录
		 * @param userid
		 * @param pass
		 * @return
		 */
		public UserVO login(String userid,String pass);
		
		/**
		 * 通过ID查找用户
		 * @param id 用户编号
		 * @return 用户信息
		 */
		public UserVO findUserById(int id);
		
		/**
		 * 通过用户姓名名查找用户
		 * @param uname 用户姓名名
		 * @return 用户信息
		 */
		public UserVO findUserByUname(String uname);
		
		/**
		 * 查询全部用户信息
		 * @param pageNo 页码
		 * @param pageSize 一个页面显示多少条信息
		 * @return 用户信息
		 */
		public Vector<UserVO> selectUser(int pageNo,  int pageSize);
				
		/**
		 * 更新用户信息
		 * @param user 更新前的用户信息
		 * @return  更新后的用户信息
		 */
		public boolean updateUser(UserVO user);
		
		/**
		 * 删除用户
		 * @param id 用户编号
		 * @return 删除成功返回真，否则返回假
		 */
		public boolean deleteUser(int id);
		
		/**
		 * 查找所有有效用户，即status= 0；
		 * @return 用户信息
		 */
		public UserVO findAllValid();

}
