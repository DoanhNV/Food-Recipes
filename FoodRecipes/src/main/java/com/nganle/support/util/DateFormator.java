package com.nganle.support.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormator {
	public static String format_yyyy_MM_dd(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	public static String format_yyyy_MM_dd_hh_mm(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(date);
	}
}
