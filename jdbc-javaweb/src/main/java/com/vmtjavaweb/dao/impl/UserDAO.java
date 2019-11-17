package com.vmtjavaweb.dao.impl;

import java.util.List;

import com.vmt.javaweb.dao.IUserDAO;
import com.vmtjavaweb.mapper.NewMapper;
import com.vmtjavaweb.mapper.UserMapper;
import com.vmtjavaweb.model.NewModel;
import com.vmtjavaweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("select * from user as u ");
		sql.append(" inner join role as r on r.id = u.roleid");
		sql.append(" where username = ? and password = ? and status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

}
