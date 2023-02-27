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
	private String password;

	public User() {
	}
	public User(String cin){
		this.CIN=cin;
	}



	public String getCIN() {
		return CIN;
	}

	public User(String CIN, String nom, String prenom, Date dateNaiss, String type, int codePos, String email) {
		this.CIN = CIN;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
		this.type = type;
		this.codePos = codePos;
		this.email = email;
	}

	public User(String CIN, String nom, String prenom, Date dateNaiss, String type, int codePos, String email, String password) {
		this.CIN = CIN;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
		this.type = type;
		this.codePos = codePos;
		this.email = email;
		this.password=password;
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

	public User(String cin, String nom, String prenom){
		this.CIN=cin;
		this.nom=nom;
		this.prenom=prenom;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User{" +
				"CIN='" + CIN + '\'' +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", dateNaiss=" + dateNaiss +
				", type='" + type + '\'' +
				", codePos=" + codePos +
				", email='" + email + '\'' +
				'}';
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
