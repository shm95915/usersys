package com.lingnan.usersys.common.exception;

public class ServiceException extends RuntimeException {

	/**
	 * 默认构造方法
	 * 
	 */
	public ServiceException(){
	}
	
	/**
	 *构造方法
	 * 
	 * @param arg0
	 */
	public ServiceException(String arg0){
		super(arg0);
	}
	
	/**
	 *构造方法
	 * 
	 * @param arg0
	 */
	public ServiceException(Throwable arg0){
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * 
	 * @param arg0
	 * @param arg1
	 */
	public ServiceException(String arg0,Throwable arg1){
		super(arg0, arg1);
	}
}
