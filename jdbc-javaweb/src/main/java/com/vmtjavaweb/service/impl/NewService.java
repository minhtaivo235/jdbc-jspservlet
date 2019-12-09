package com.vmtjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.vmt.javaweb.dao.ICategoryDAO;
import com.vmt.javaweb.dao.INewDAO;
import com.vmtjavaweb.model.CategoryModel;
import com.vmtjavaweb.model.NewModel;
import com.vmtjavaweb.paging.IPageble;
import com.vmtjavaweb.service.INewService;

public class NewService implements INewService {
	@Inject
	private INewDAO newDao;
	
	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {	
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		CategoryModel category = categoryDao.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getId());
		Long newId = newDao.save(newModel);		
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		CategoryModel category = categoryDao.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			newDao.delete(id);
		}
		
	}

	@Override
	public List<NewModel> findAll(IPageble pageble) {		
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

	@Override
	public NewModel findOne(long id) {
		NewModel newModel = newDao.findOne(id);
		CategoryModel categoryModel = categoryDao.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}
	

}
