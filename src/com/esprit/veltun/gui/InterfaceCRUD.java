/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun.gui;

import java.util.List;

import com.esprit.veltun.model.Personne;

/**
 *
 * @author Asus
 */
public interface InterfaceCRUD {
    public void AjouterPersonne();
    public void AjouterPersonne2();
    public List <Personne> afficherPersonne();
    
}
