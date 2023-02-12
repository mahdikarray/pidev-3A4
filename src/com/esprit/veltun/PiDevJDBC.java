/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;

import java.sql.Connection;

import com.esprit.veltun.model.Station;
import com.esprit.veltun.services.stationCRUD;
import com.esprit.veltun.util.MyConnection;

/**
 *
 * @author Asus
 */
public class PiDevJDBC {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Connection conn = MyConnection.getInstance();
		System.out.print("started");
		Station s8 = new Station("ARIANA", 8.5, 8.6);
		stationCRUD stas = new stationCRUD();

	}

}
