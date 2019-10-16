package com.vmtjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.vmt.javaweb.dao.ICategoryDAO;
import com.vmtjavaweb.model.CategoryModel;
import com.vmtjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<CategoryModel> findAll() {		
		return categoryDao.findAll();
	}

}
