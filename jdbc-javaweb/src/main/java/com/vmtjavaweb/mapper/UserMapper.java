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
				users.setPassword(rs.getString("password"));
				users.setFullName(rs.getString("fullname"));
				users.setStatus(rs.getInt("status"));
				try {
					RoleModel role = new RoleModel();
					role.setCode(rs.getString("code"));
					role.setName(rs.getString("name"));
					users.setRole(role);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					
				}				
				return users;
			} catch (SQLException e) {
				return null;
			}	
	}

}
