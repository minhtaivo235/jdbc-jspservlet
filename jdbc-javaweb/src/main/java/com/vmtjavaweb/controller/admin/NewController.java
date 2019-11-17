package com.vmtjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vmtjavaweb.constant.SystemConstant;
import com.vmtjavaweb.model.NewModel;
import com.vmtjavaweb.paging.IPageble;
import com.vmtjavaweb.paging.PageRequest;
import com.vmtjavaweb.service.INewService;
import com.vmtjavaweb.sort.Sorter;
import com.vmtjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-new"}) //design tất cả url có trong value 
public class NewController extends HttpServlet {

	
	private static final long serialVersionUID = 1782092174206838839L;
	@Inject
	private INewService newService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewModel model = FormUtil.toModel(NewModel.class, req);
//		String pageStr = req.getParameter("page"); // lấy theo name ở view-list
//		String maxPageItemStr = req.getParameter("maxPageItem");
//		if (pageStr != null) {
//			model.setPage(Integer.parseInt(pageStr));
//		}else {
//			model.setPage(1);
//		}
//		if (maxPageItemStr != null) {
//			model.setMaxPageItem(Integer.parseInt(maxPageItemStr));
//		} 
		IPageble pageable = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
		model.setListResult(newService.findAll(pageable));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/new/list.jsp"); // trả về views trang home
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
