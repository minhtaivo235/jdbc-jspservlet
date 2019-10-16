package com.vmtjavaweb.service;

import java.util.List;

import com.vmtjavaweb.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
