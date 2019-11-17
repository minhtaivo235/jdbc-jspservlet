package com.vmtjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.vmtjavaweb.model.RoleModel;
import com.vmtjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {		
			try {
				UserModel users = new UserModel();
				users.setId(rs.getLong("id"));	
				users.setUserName(rs.getString("username"));
				users.setPassWord(rs.getString("password"));
				users.setFullName(rs.getString("fullname"));
				users.setStatus(rs.getInt("status"));
				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				users.setRole(role);
				return users;
			} catch (SQLException e) {
				return null;
			}	
	}

}
