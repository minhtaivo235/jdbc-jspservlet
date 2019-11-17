package com.vmtjavaweb.service;

import java.util.List;

import com.vmtjavaweb.model.NewModel;
import com.vmtjavaweb.model.UserModel;
import com.vmtjavaweb.paging.IPageble;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
