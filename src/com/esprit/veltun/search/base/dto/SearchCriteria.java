package com.esprit.veltun.search.base.dto;

import com.esprit.veltun.model.base.BaseEntity;

public abstract class SearchCriteria<T extends BaseEntity> {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
