package com.vmt.javaweb.dao;

import com.vmtjavaweb.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
