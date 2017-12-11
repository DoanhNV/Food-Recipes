package com.nganle.support.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

public class Utils {

	public static void destroySession(HttpSession session, String sessionName) {
		session.removeAttribute(sessionName);
	}

	public static void setSession(HttpSession session, String sessionName, Object value) {
		session.setAttribute(sessionName, value);
	}

	public static void setErrorMessage(ModelMap model, String messageName, String messageValue) {
		model.addAttribute(messageName, messageValue);
	}

	public static List<String> getPageToDisplay(int size, int currentPage) {
		List<String> result = new ArrayList<String>();
		if (currentPage > size) {
			return result;
		}
		if (currentPage - 2 > 0) {
			result.add("...");
		}
		if (currentPage - 1 > 0) {
			result.add(String.valueOf(currentPage - 1));
		}
		result.add(String.valueOf(currentPage));
		if (currentPage + 1 <= size) {
			result.add(String.valueOf(currentPage + 1));
		}
		if (currentPage + 2 <= size) {
			result.add("...");
		}
		return result;
	}

	/**
	 * Url : /part/part
	 * 
	 * @param url
	 * @return
	 */
	public static String redirect(String url) {
		return "redirect:" + url;
	}

	public static String toSQlArray(List<String> list) {
		if(list == null) {
			return "";
		}
		String result = "";
		int size = list.size();
		for (int i = 0; i < size; i++) {
			result += list.get(i);
			if (i != size - 1) {
				result += ",";
			}
		}
		return result;
	}

	public static Date getCurrentSQLDate() {
		return new Date(System.currentTimeMillis());
	}
	
	/**
	 * arr format: "a,b,c"
	 * @param arr String
	 * @return List<String>
	 */
	public static List<String> toList(String arr) {
		List<String> result = new ArrayList<String>();
		String[] data = arr.split(",");
		for (int i = 0; i < data.length; i++) {
			result.add(data[i]);
		}
		return result;
	}

}
