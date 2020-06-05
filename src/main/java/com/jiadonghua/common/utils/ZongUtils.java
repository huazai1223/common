package com.jiadonghua.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;


public class ZongUtils {
	/*
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/
	@SuppressWarnings("static-access")
	public static Date getDateByInitMonth(Date src){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(src);
		
		calendar.set(calendar.DAY_OF_MONTH, 1);
		calendar.set(calendar.HOUR_OF_DAY, 0);
		calendar.set(calendar.MINUTE, 0);
		calendar.set(calendar.SECOND, 0);
		
		return calendar.getTime();
	//TODO 实现代码
	}
	
	/*
	* 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	@SuppressWarnings("static-access")
	public static Date getDateByFullMonth(Date src){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(src);
		calendar.add(calendar.MONTH, 1);
		Date initMonth= getDateByInitMonth(calendar.getTime());
		calendar.setTime(initMonth);
		calendar.add(calendar.SECOND, -1);
		
	//TODO 实现代码
		return calendar.getTime();
	}
	
	
	/*
	* 给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”(10分)
	*/
	public static String getExtendName(String fileName){
		if (fileName!=null) {
			return fileName.substring(fileName.lastIndexOf(".")+1);
			
		}
		return "";
	//TODO 实现代码
	}
	
	/*
	* 批量关闭流，参数能传入无限个
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	*/
	public static void closeAll(java.io.Closeable... ios){
		for (java.io.Closeable io : ios) {
			if (io!=null) {
				try {
					io.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	//TODO 实现代码
	}
	
	/*
	* 传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	*/
	public static String readTextFile(InputStream in) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(in));
		String str;
		String string =bf.readLine();
		ZongUtils.closeAll(bf);
		return string;
	//TODO 实现代码
	}
	/*
	* 传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	*/
	public static String readTextFile(File txtFile) throws IOException{
		
		FileInputStream in = new FileInputStream(txtFile);
		String string = ZongUtils.readTextFile(in);
		ZongUtils.closeAll(in);
		return string;
	//TODO 实现代码
	}
}
