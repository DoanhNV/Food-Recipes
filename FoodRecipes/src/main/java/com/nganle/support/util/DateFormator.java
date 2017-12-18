package com.nganle.support.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormator {
	public static String format_yyyy_MM_dd(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	public static String format_dd_MM_yyyy(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(date);
	}
	
	public static String format_yyyy_MM_dd_hh_mm(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(date);
	}
	
	public static Date parse_yyyy_MM_dd(String dateStr) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}
}
