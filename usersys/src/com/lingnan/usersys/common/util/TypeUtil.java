package com.lingnan.usersys.common.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.exception.EmailException;

/**
 * 类型转换工具类
 * 
 * @author asus
 *
 */

public class TypeUtil {

	/**
	 * 字符串转日期
	 * 
	 * @param str  传递过来的字符串
	 * @return 转化后的日期
	 */
	public static Date strToDate(String str){
		Date date = null;
		//设置要格式化的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用parse方法，将字符串解析成日期
			date = sdf.parse(str);
		} catch (Exception e) {
//			System.out.println("字符串转日期失败");
			//将异常设置为自定义异常类
			throw new DateException("字符串转日期失败", e);
		}
		return date;
	}
	
	/**
	 * 日期转字符串
	 * 
	 * @param date 传递过来的日期
	 * @return 转化后的字符串
	 */
	public static String dateToStr(Date date){
		String str = null;
		//设置要格式化的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			str = sdf.format(date);
		} catch (Exception e) {
//			System.out.println("日期转字符串失败");
			//将异常设置为自定义异常类
			throw new DateException("日期转字符串失败", e);
		}
		return str;
	}
	
	public static boolean checkEmail(String email){
		boolean flag = false;
		//设置要格式化的邮箱格式
		try {
			Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
			Matcher m = p.matcher(email);
			if(m.matches()){
				flag = true;
				System.out.println("邮箱格式正确");
			}
			else {
				System.out.println("邮箱格式错误");
			}
		} catch (Exception e) {
			//将异常设置为自定义异常类
			throw new EmailException("邮箱验证出错", e);
		}
		
		return flag;
	}
	
	
	public static boolean checkNull(String str){
		boolean flag = true;
		//判断传递到的值是否为空
		if (str == null || str.length()<0) {
			System.out.println("该值为空");
			flag = false;
		}
		else {
			System.out.println("该值为不空");
		}
		return flag;
	}
}
