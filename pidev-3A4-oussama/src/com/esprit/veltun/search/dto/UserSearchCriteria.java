package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.User;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class UserSearchCriteria extends SearchCriteria<User> {
	private String cin;

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
	
}
