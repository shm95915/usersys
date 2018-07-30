package com.lingnan.usersys.business.dao;

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
		 * @return
		 */
		public boolean addUser(UserVO user);
		/**
		 * 用户登录
		 * @param userid
		 * @param pass
		 * @return
		 */
		public UserVO login(String userid,String pass);
		
}
