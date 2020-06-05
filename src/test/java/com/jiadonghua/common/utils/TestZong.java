package com.jiadonghua.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestZong {

	@Test
	public void testDateByInitMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1998, 8,31);
		Date date = ZongUtils.getDateByInitMonth(calendar.getTime());
		System.out.println(sdf.format(date));
	
	}
	
	@Test
	public void testDateByFullMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1998, 8, 1);
		Date date = ZongUtils.getDateByFullMonth(calendar.getTime());
		System.out.println(sdf.format(date));
		
		
	}
}
