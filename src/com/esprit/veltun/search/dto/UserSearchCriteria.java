package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.User;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class UserSearchCriteria extends SearchCriteria<User> {
	private String cin;
	private String nom;
	private String prenom;
	private String role;
	private String email;


	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}


	public void setNom(String nom){
		this.nom=nom;
	}

	public String getPrenom() {
		return this.prenom;
	}
	public void setPrenom(String prenom){
		this.prenom=prenom;
	}

	public String getRole() {
		return this.role;
	}
	public void setRole(String role)
	{
		this.role=role;
	}

	@Override
	public String toString() {
		return "UserSearchCriteria{" +
				"cin='" + cin + '\'' +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", role='" + role + '\'' +
				'}';
	}
}
