/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun.util;

import java.sql.*;

/**
 *
 * @author Asus
 */
public class MyConnection {

	private static Connection instance;
	private String url = "jdbc:mysql://localhost/veltun";

	private String user = "root";

	private String pwd = "";

	private MyConnection() {
		try {
			instance = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection etablie");
		} catch (SQLException e) {
			System.out.println("Connection non etablie: " + e);
		}
	}

	/**
	 * synchronized protection contre l'acces simultané de +1 thread
	 * 
	 * @return
	 */
	public static synchronized Connection getInstance() {
		if (instance == null) {
			new MyConnection();
		}
		return MyConnection.instance;
	}

}
