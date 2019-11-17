package com.vmtjavaweb.service.impl;

import javax.inject.Inject;

import com.vmt.javaweb.dao.IUserDAO;
import com.vmtjavaweb.model.UserModel;
import com.vmtjavaweb.service.IUserService;

public class UserService implements IUserService {
	@Inject
	private IUserDAO userDAO;

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

}
