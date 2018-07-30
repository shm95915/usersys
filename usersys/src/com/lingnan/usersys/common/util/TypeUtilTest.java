package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TypeUtilTest {

	@Test
	public void testStrToDate() {
		Date t = TypeUtil.strToDate("2001-07-05");
		System.out.println(t);
	}

	@Test
	public void testDateToStr() {
		String s = TypeUtil.dateToStr(new Date());
		System.out.println(s);
	}

	@Test
	public void testCheckEmail() {
		boolean f = TypeUtil.checkEmail("165@99.c");
		System.out.println(f);
		boolean s = TypeUtil.checkEmail("qw954@w.com");
		System.out.println(s);
		boolean q =TypeUtil.checkEmail("1231@12.com");
		System.out.println(q);
	}
	
	@Test
	public void testCheckNull() {
		boolean f = TypeUtil.checkNull("");
		System.out.println(f);
		boolean s = TypeUtil.checkNull("123");
		System.out.println(s);
	}

}
