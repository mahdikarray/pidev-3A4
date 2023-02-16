package com.esprit.veltun.model;

import java.sql.Date;

import com.esprit.veltun.model.base.BaseEntity;

public class User extends BaseEntity {
	private String CIN;
	private String nom;
	private String prenom;
	private Date dateNaiss;
	private String type;
	private int codePos;
	private String email;

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCodePos() {
		return codePos;
	}

	public void setCodePos(int codePos) {
		this.codePos = codePos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
