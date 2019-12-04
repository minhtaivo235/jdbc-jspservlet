package com.vmtjavaweb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vmtjavaweb.model.UserModel;
import com.vmtjavaweb.service.ICategoryService;
import com.vmtjavaweb.service.IUserService;
import com.vmtjavaweb.utils.FormUtil;
import com.vmtjavaweb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"}) //design tất cả url có trong value 
public class HomeController extends HttpServlet {
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IUserService userService;
    // đoạn inject thay cho đoạn bên dưới , đoạn bên dưới là thủ công
	/*private INewService newService;  
	public HomeController() {
		newService = new NewService();
	}*/ 
	
	
	private static final long serialVersionUID = 1782092174206838839L;
	
	ResourceBundle resourcebundle = ResourceBundle.getBundle("message");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");
			if(message != null && alert != null) {
				req.setAttribute("message", resourcebundle.getString(message));
				req.setAttribute("alert", alert);
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		}else if (action != null && action.equals("logout")){
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath()+"/trang-chu");
		}else {
			req.setAttribute("categories", categoryService.findAll());		
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp"); // trả về views trang home
			rd.forward(req, resp);		
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, req);
			model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(),1);
			if (model != null) {
				SessionUtil.getInstance().putvalue(req, "USERMODEL", model);
				if (model.getRole().getCode().equals("USER")) { // nếu ng` dùng là user chuyển đến trang chu sau khi đăng nhập thành công
					resp.sendRedirect(req.getContextPath()+"/trang-chu"); 
				}else if(model.getRole().getCode().equals("ADMIN")) { // nếu ng dùng là admin chuyển đến trang admin
					resp.sendRedirect(req.getContextPath()+"/admin-home"); 
				}
			}
			else { // đăng nhập thất bại
				// sendRedirect : phản hồi lại 1 url cho client
				// getContextPath : địa chỉ web ban đầu localhost...
				resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid&alert=danger"); 
			}
		}
	}

}
