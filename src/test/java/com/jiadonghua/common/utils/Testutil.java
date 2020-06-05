package com.jiadonghua.common.utils;

import java.util.Date;

import org.junit.Test;

public class Testutil {

	@Test
	public void tests() {
		String sql="select * from t_order where create_time>='"+ZongUtils.getDateByInitMonth(new Date())+"'and create_time<='+ZongUtils.getDateByFullMonth(new Date())'";
		System.out.println(sql);
	
	}
}
