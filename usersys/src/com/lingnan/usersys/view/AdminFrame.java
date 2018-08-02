package com.lingnan.usersys.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
import java.io.IOException;
import com.lingnan.usersys.common.util.TypeUtil;
import com.lingnan.usersys.controller.UserController;
import com.lingnan.usersys.domain.UserVO;

public class AdminFrame extends NormalFrame{
	
	public AdminFrame(UserVO user) {
		super(user);
	}
	
	/**
	 * 登陆成功界面
	 **/
	public void loginSuccShow() {
		System.out.println("欢迎登陆本系统");
		System.out.println(user.getUname()+"你好"+"       你的权限为:"+user.getPower());
		System.out.println("---------------------------------------------------");
		if(user.getPower().equals("管理员")) {
			this.show();
		}else {
			new NormalFrame(user).show();
		}
	}
	
	/**
	 * 管理员首界面
	 **/
	public void show() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("添加用户---------------1");
			System.out.println("删除用户---------------2");
			System.out.println("修改用户---------------3");
			System.out.println("查询用户---------------4");
			System.out.println("退出登陆---------------5");
			int i = -1;
			while(true) {
				try {
					i = Integer.parseInt(br.readLine());
					break;
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					System.out.println("你的输入有误，只能输入1~5的数字");
					System.out.println("请重新输入");
				}
			}
			IndexFrame idf = new IndexFrame();
			switch(i) {
			case 1:
				this.addShow("添加用户");
				break;
			case 2:
				this.deleteShow();
				break;
			case 3:
				this.updateShow();
				break;
			case 4:
				this.selectShow();
				break;
			case 5:
				idf.show();
				break;
				
			default:
				System.out.println("您的输入操作不正确，请重新输入");
			}
		}
	}
	
	/**
	 * 删除界面
	 **/
	public void deleteShow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入你想删除的用户的ID:");
		try {
			int id = Integer.parseInt(br.readLine());
			UserController uc = new UserController();
			boolean flag = uc.doDeleteUser(id);
			if(flag) {
				System.out.println("删除成功!");
			}else {
				System.out.println("删除失败!");
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询界面
	 **/
	public void selectShow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
		System.out.println("--------------------------------------------------");
		System.out.println("查询全部用户-------------------1");
		System.out.println("根据id查询用户-----------------2");
		System.out.println("根据用户名查询用户-------------3");
		System.out.println("退出查询-----------------------4");
		System.out.println("请输入您选择的操作:");
		int i = -1;
		while(true) {
			try {
				i = Integer.parseInt(br.readLine());
				break;
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println("你的输入有误，只能输入1~4的数字");
				System.out.println("请重新输入");
			}
		}
		switch(i) {
		case 1:
			System.out.println("请输入要每页显示的条数:");
			try {
				UserController uc = new UserController();
				int pageSize = Integer.parseInt(br.readLine());
				System.out.println("请输入查询的页码:");
				int pageNo = Integer.parseInt(br.readLine());
			
				Vector<UserVO> u14 = uc.doSelect(pageNo, pageSize);
				if(u14 != null)
					this.selectUserShow(u14, pageNo, pageSize);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			this.selectByIdShow();
			break;
		case 3:
			this.selectByNameShow();
			break;
		case 4:
			this.show();
			break;
			
		default:
			System.out.println("您的输入操作不正确，请重新输入");
		}
	}
	}
	
	/**
	 * 根据id查询界面
	**/
	public void selectByIdShow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入你想查询的用户的ID:");
		try {
			int id = Integer.parseInt(br.readLine());
			UserController uc = new UserController();
			UserVO user = new UserVO();
			user = uc.doFindUserById(id);
			if(user != null) {
				System.out.println("----------------------------------------------------------------------------------------------------------|");
				System.out.println("ID:"+user.getId()+"        用户名:"+user.getUname()+"           密码:"+user.getPass()+"            邮箱:"+user.getEmail()+"           权限:"+user.getPower());
				System.out.println("----------------------------------------------------------------------------------------------------------|");
			}else {
				System.out.println("查询的用户不存在!");
			}
		}catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据用户名查询界面
	 **/
	public void selectByNameShow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入你想查询的用户的用户名:");
		try {
			String uname = br.readLine();
			UserController uc = new UserController();
			UserVO user = new UserVO();
			user = uc.dofindUserByUname(uname);
			if(user != null) {
				System.out.println("---------------------------------------------------------------------------------------------------|");
				System.out.println("ID:"+user.getId()+"        用户名:"+user.getUname()+"           密码:"+user.getPass()+"          邮箱:"+user.getEmail()+"           权限:"+user.getPower());
				System.out.println("---------------------------------------------------------------------------------------------------|");
			}else {
				System.out.println("查询的用户不存在!");
			}
		}catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询全部用户时的界面
	 * @param u14 容器类对象
	 * @param pageNo 页码
	 * @param pageSize 一个页面显示多少条信息
	 **/
	public void selectUserShow(Vector<UserVO> u14, int pageNo, int pageSize) {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			java.util.Iterator<UserVO> it = u14.iterator();
			UserVO u = null;
			while(it.hasNext()) {
				u = it.next();
				System.out.println("---------------------------------------------------------------------------------------------------|");
				System.out.println("ID:"+u.getId()+"        用户名:"+u.getUname()+"           密码:"+u.getPass()+"          邮箱:"+u.getEmail()+"           权限:"+u.getPower());
				System.out.println("---------------------------------------------------------------------------------------------------|");
			}
			System.out.println("第"+pageNo+"页");
			System.out.println("上一页---------------1");
			System.out.println("下一页---------------2");
			System.out.println("退出查询-------------3");
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
			switch(i) {
			case 1:
				try {
					UserController uc = new UserController();
					Vector<UserVO> u15 = uc.doSelect(pageNo-1, pageSize);
					if(u15 != null)
						this.selectUserShow(u15, pageNo-1,pageSize);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					UserController uc = new UserController();
					Vector<UserVO> u16 = uc.doSelect(pageNo+1, pageSize);
					if(u16 != null)
						this.selectUserShow(u16, pageNo+1,pageSize);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.selectByIdShow();
				break;
			case 3:
				this.show();
				break;
			default:
				System.out.println("您的输入操作不正确，请重新输入");
			}
	}
	
	/**
	 * 修改界面
	 **/
	public void updateShow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		System.out.println("请输入您要修改的用户ID:");
		try {
			UserVO uv = new UserVO();
			uv.setId(Integer.parseInt(br.readLine()));
			System.out.println("请输入您要修改的用户的姓名:");
			uv.setUname(br.readLine());
			System.out.println("请输入您要修改的用户的密码:");
			uv.setPass(br.readLine());
			while(true) {
				System.out.println("请输入您要修改的用户的邮箱:");
				String email = br.readLine();
				if(TypeUtil.checkEmail(email)) {
					uv.setEmail(email);
					break;
				}
			}
			System.out.println("请输入您要修改的用户的权限(普通用户/管理员)");
			uv.setPower(br.readLine());		
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