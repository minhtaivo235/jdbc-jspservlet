package com.vmtjavaweb.dao.impl;

import java.util.List;

import com.vmt.javaweb.dao.INewDAO;
import com.vmtjavaweb.mapper.NewMapper;
import com.vmtjavaweb.model.NewModel;
import com.vmtjavaweb.paging.IPageble;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "select * from news where categoryId = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {		
		StringBuilder sql = new StringBuilder("insert into news (title, content,");
		sql.append(" thumbnail, shortdesciption, categoryid, createddate, createdby)");
		sql.append(" values (?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), newModel.getThumbnail(),
				newModel.getShortDesciption(), newModel.getCategoryId(), newModel.getCreatedDate(), newModel.getCreatedBy());

	}

	@Override
	public NewModel findOne(Long id) {
		String sql = "select * from news where id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("update news set title = ?, thumbnail = ?,");
		sql.append(" shortdesciption = ?, content = ?, categoryId = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? where id = ?");
		
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDesciption(),
				updateNew.getContent(), updateNew.getCategoryId(), 
				updateNew.getCreatedDate(), updateNew.getCreatedBy(),
				updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());
		
	}

	@Override
	public void delete(long id) {
		String sql = "delete from news where id = ?";
		update(sql, id);
	}

	@Override
	public List<NewModel> findAll(IPageble pageable) {
		//String sql = "select * from news limit ?,?";
		StringBuilder sql = new StringBuilder("select * from news");
		if(pageable.getSorter() != null) {
			sql.append(" order by "+ pageable.getSorter().getSortName() +" "+ pageable.getSorter().getSortBy() +" ");
		}
		if (pageable.getOffset() != null && pageable.getLimit() != null) {
			sql.append("limit "+pageable.getOffset()+","+pageable.getLimit()+"");
						
		}
		return query(sql.toString(), new NewMapper());
			
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from news";
		return count(sql);
	}

}
