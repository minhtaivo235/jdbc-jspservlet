package com.vmtjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vmtjavaweb.model.NewModel;
import com.vmtjavaweb.model.UserModel;
import com.vmtjavaweb.service.INewService;
import com.vmtjavaweb.utils.HttpUtil;
import com.vmtjavaweb.utils.SessionUtil;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet {
	private static final long serialVersionUID = 9165796261389366540L;

	@Inject
	private INewService newService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8"); // client chuyển lên sever k bị lỗi font
		resp.setContentType("application/json"); // sever định nghĩa kiểu dữ liệu trả về json
		NewModel newModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);
//		UserModel userModel = (UserModel) SessionUtil.getInstance().getvalue(req, "USERMODEL");
//		newModel.setCreatedBy(userModel.getUserName());
		newModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getvalue(req, "USERMODEL")).getUserName());
		newModel = newService.save(newModel);		
		mapper.writeValue(resp.getOutputStream(), newModel);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8"); // client chuyển lên sever k bị lỗi font
		resp.setContentType("application/json"); // sever định nghĩa kiểu dữ liệu trả về json
		NewModel updateNew = HttpUtil.of(req.getReader()).toModel(NewModel.class);
		updateNew.setModifiedBy(((UserModel) SessionUtil.getInstance().getvalue(req, "USERMODEL")).getUserName());
		updateNew = newService.update(updateNew);
		mapper.writeValue(resp.getOutputStream(), updateNew);
	}

	private void saveOrUpdate() {

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8"); // client chuyển lên sever k bị lỗi font
		resp.setContentType("application/json"); // sever định nghĩa kiểu dữ liệu trả về json
		NewModel newModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);
		newService.delete(newModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
