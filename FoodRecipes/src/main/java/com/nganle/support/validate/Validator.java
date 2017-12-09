package com.nganle.support.validate;

import static com.nganle.support.constant.Constant.SESSION_NAME.ADMIN_SESSION;

import javax.servlet.http.HttpSession;

import com.nganle.entity.User;

public class Validator {
	
	public static boolean isExistSession(HttpSession session, String sessionName) {
		User user = (User) session.getAttribute(ADMIN_SESSION);
		if (user != null) {
			return true;
		}
		return false;
	}
	
	public static boolean isAdmin(User user) {
		return user != null && user.isAdmin();
	}
}
