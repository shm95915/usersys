package com.lingnan.usersys.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import com.lingnan.usersys.common.util.TypeUtil;
import com.lingnan.usersys.controller.UserController;
import com.lingnan.usersys.domain.UserVO;

public class NormalFrame extends IndexFrame{
	UserVO user = null;
	/**
	 * 构造函数
	 * @param user 个人用户信息
	 */
	public  NormalFrame(UserVO user) {
		this.user = user;
	}
	
	/**
	 * 普通用户首界面
	 **/
	public void show() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("=======================================");
			System.out.println("查询自己的信息---------------1");
			System.out.println("修改自己的信息---------------2");
			System.out.println("退出登陆---------------3");
			int i = -1;
			while(true) {
				try {
					i = Integer.parseInt(br.readLine());
					break;
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					System.out.println("你的输入有误，只能输入1~3的数字");
					System.out.println("请重新输入");
				}
			}
			IndexFrame idf = new IndexFrame();
			switch(i) {
			case 1:
				this.selectMy();
				break;
			case 2:
				this.updateMy();
				this.show();
			case 3:
				idf.show();
				break;
				
			default:
				System.out.println("您的输入操作不正确，请重新输入");
			}
		}
	}
	
	/**
	 * 查询个人信息界面
	 **/
	public void selectMy() {
		System.out.println("您的信息如下:");
		if(user != null) {
			System.out.println("----------------------------------------------------------------------------------------------------------|");
			System.out.println("ID:"+user.getId()+"        用户名:"+user.getUname()+"           密码:"+user.getPass()+"            邮箱:"+user.getEmail()+"           权限:"+user.getPower());
			System.out.println("----------------------------------------------------------------------------------------------------------|");
		}else {
			System.out.println("查询的用户不存在!");
		}
	}
	
	
	/**
	 * 修改个人信息界面
	 **/
	public void updateMy() {
		    System.out.println("您现在的信息如下:");
			System.out.println("----------------------------------------------------------------------------------------------------------|");
			System.out.println("ID:"+user.getId()+"        用户名:"+user.getUname()+"           密码:"+user.getPass()+"            邮箱:"+user.getEmail()+"           权限:"+user.getPower());
			System.out.println("----------------------------------------------------------------------------------------------------------|");
			System.out.println("=============================================================================================================================");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				UserVO uv = new UserVO();
				uv.setId(user.getId());
				System.out.println("请输入您要修改的用户姓名:");
				uv.setUname(br.readLine());
				System.out.println("请输入您要修改的密码:");
				uv.setPass(br.readLine());
				while(true) {
					System.out.println("请输入您要修改的邮箱:");
					String email = br.readLine();
					if(TypeUtil.checkEmail(email)) {
						uv.setEmail(email);
						break;
					}
				}
				uv.setPower(user.getPower());	
				UserController uc = new UserController();
				boolean flag = uc.doupdateUser(uv);
				if(flag) {
					System.out.println("修改成功!");
				}else {
					System.out.println("修改失败!");
				}
	}catch(Exception e){
		System.out.println("您的输入有误请重新输入");
	}
}
}