package com.vmtjavaweb.service;

import java.util.List;

import com.vmtjavaweb.model.NewModel;
import com.vmtjavaweb.paging.IPageble;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel); // thêm mới
	NewModel update(NewModel updateNew); // update
	void delete (long[] ids);
	List<NewModel> findAll(IPageble pageble); // select * from news order by 
																				// (sortName) (DESC) limit 0--(offset), 2--(limit)
	int getTotalItem();
	NewModel findOne(long id);
}
