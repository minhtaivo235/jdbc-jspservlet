package com.vmt.javaweb.dao;

import java.util.List;

import com.vmtjavaweb.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();

}
