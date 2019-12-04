package com.vmtjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil { // quản lý thông tin người dùng khi đăng nhập thành công
	
	private static SessionUtil sessionUtil = null;
	public static SessionUtil getInstance() {
		if (sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}
		return sessionUtil;
	}
	
	// tạo đối tượng request để lấy ra đc session
	public void putvalue(HttpServletRequest request, String key, Object value) { // duy trì thông tin người dùng
		request.getSession().setAttribute(key, value); // gán giá trị attribute vào session
	}
	public Object getvalue(HttpServletRequest request, String key) { // lấy thông tin ra
		return request.getSession().getAttribute(key); // lấy giá trị attribute
	}
	public void removeValue(HttpServletRequest request, String key) { // thoát ra khỏi hệ thống
		request.getSession().removeAttribute(key); // xóa attribute đó ra khỏi session
	}
}
