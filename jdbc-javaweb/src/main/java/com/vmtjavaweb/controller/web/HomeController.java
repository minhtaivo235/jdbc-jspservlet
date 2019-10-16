package com.vmtjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vmtjavaweb.service.ICategoryService;

@WebServlet(urlPatterns = {"/trang-chu"}) //design tất cả url có trong value 
public class HomeController extends HttpServlet {
	
	@Inject
	private ICategoryService categoryService;
    // đoạn inject thay cho đoạn bên dưới , đoạn bên dưới là thủ công
	/*private INewService newService;  
	public HomeController() {
		newService = new NewService();
	}*/ 
	
	
	private static final long serialVersionUID = 1782092174206838839L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {				
		req.setAttribute("categories", categoryService.findAll());		
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp"); // trả về views trang home
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
