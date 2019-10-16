package com.vmtjavaweb.service;

import java.util.List;

import com.vmtjavaweb.model.NewModel;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel); // thêm mới
	NewModel update(NewModel updateNew); // update
	void delete (long[] ids);
}
