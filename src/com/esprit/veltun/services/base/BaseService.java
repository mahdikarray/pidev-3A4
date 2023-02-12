package com.esprit.veltun.services.base;

import java.util.Collection;

import com.esprit.veltun.model.base.BaseEntity;

public interface BaseService<T extends BaseEntity> {
	T findById(Integer id);
	Collection<T> list();
	T save(T entity);
	T update(T entity);
	boolean remove(Integer id);
}
