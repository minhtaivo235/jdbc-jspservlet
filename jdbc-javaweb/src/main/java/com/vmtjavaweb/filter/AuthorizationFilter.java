package com.vmtjavaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vmtjavaweb.constant.SystemConstant;
import com.vmtjavaweb.model.UserModel;
import com.vmtjavaweb.utils.SessionUtil;

public class AuthorizationFilter implements Filter {
	
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI(); // lấy ra link hiện tại đang truy cập
        if (url.startsWith("/admin")) { // check url bắt đầu /admin
        	UserModel model = (UserModel) SessionUtil.getInstance().getvalue(request, "USERMODEL"); // kiểm tra đã đang nhập chưa
            if (model != null) {
                if (model.getRole().getCode().equals(SystemConstant.ADMIN)) { // package constant -- ktra giống admin
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (model.getRole().getCode().equals(SystemConstant.USER)) { // package constant -- ktra giống user -- k có quyền truy cập
                    response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_permission&alert=danger");
                }
            } else {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
            }
        } else {
        	 filterChain.doFilter(servletRequest, servletResponse); // cho phép truy cập
        }
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
