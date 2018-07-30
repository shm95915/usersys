package com.lingnan.usersys.common.exception;

public class EmailException extends ServiceException {

	/**
	 * 默认构造方法
	 * 
	 */
	public EmailException(){
	}
	
	/**
	 * 构造方法
	 * 
	 * @param arg0
	 */
	public EmailException(String arg0){
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * 
	 * @param arg0
	 */
	public EmailException(Throwable arg0){
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * 
	 * @param arg0
	 * @param arg1
	 */
	public EmailException(String arg0,Throwable arg1){
		super(arg0, arg1);
	}
}
