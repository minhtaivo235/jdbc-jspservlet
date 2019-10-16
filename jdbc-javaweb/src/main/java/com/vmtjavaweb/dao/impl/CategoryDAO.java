package com.vmtjavaweb.dao.impl;

import java.util.List;

import com.vmt.javaweb.dao.ICategoryDAO;
import com.vmtjavaweb.mapper.CategoryMapper;
import com.vmtjavaweb.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {	
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}

	
}
