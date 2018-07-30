package com.lingnan.usersys.common.exception;

public class DateException extends ServiceException {

	/**
	 * 默认构造方法
	 * 
	 */
	public DateException(){
	}
	
	/**
	 * 构造方法
	 * 
	 * @param arg0
	 */
	public DateException(String arg0){
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * 
	 * @param arg0
	 */
	public DateException(Throwable arg0){
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * 
	 * @param arg0
	 * @param arg1
	 */
	public DateException(String arg0,Throwable arg1){
		super(arg0, arg1);
	}
}
