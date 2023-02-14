package com.esprit.veltun.services.base;

import java.util.Collection;

import com.esprit.veltun.model.Velo;
import com.esprit.veltun.model.base.BaseEntity;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public interface BaseService<T extends BaseEntity> {
	/**
	 * @param id
	 * @return
	 */
	static T findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
	Collection<T> list();
	T save(T entity);
	T update(T entity);
	boolean remove(Integer id);
	Collection<T> search(SearchCriteria<T> searchCriteria);
	Velo findById(Integer id);
}
