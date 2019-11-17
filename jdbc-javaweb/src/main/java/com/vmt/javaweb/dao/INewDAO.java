package com.vmt.javaweb.dao;

import java.util.List;

import com.vmtjavaweb.model.NewModel;
import com.vmtjavaweb.paging.IPageble;

public interface INewDAO extends GenericDAO<NewModel> {
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id);
	List<NewModel> findAll(IPageble pageable);
	int getTotalItem();
}
