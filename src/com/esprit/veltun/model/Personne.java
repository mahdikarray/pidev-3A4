/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun.model;

/**
 *
 * @author Asus
 */
public class Personne {
    private int id;
    private String nom;
    private String prenom;

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    public Personne(){
        
    }
    
    
    @Override
    public String toString()
    {
        return "Nom:" + this.nom + "Prenom: " + this.prenom;
    }
    
    
}
