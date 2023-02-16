package com.esprit.veltun.services.base;

import java.util.Collection;

import com.esprit.veltun.model.base.BaseEntity;
import com.esprit.veltun.search.Base.SearchCriteria;

public interface BaseService<T extends BaseEntity> {
	T findById(Integer id);
	Collection<T> list();
	T save(T entity);
	T update(T entity);
	boolean remove(Integer id);
	Collection<T> search(SearchCriteria<T> searchCriteria);
}
