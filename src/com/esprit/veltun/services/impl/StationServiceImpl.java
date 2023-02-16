package com.esprit.veltun.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.veltun.model.base.BaseEntity;

import com.esprit.veltun.model.Station;
import com.esprit.veltun.model.User;
import com.esprit.veltun.services.StationService;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.impl.StationServiceImpl;

public class StationServiceImpl implements StationService {

	@Override
	public Station findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Station> list() {
		
		List<Station> list = new ArrayList<>();
		try {
		    Connection conn = MyConnection.getInstance();
		    Statement ste;
			String req = "Select * from station";
			Statement st = conn.createStatement();

			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Station s = new Station();

				s.setid_station(RS.getInt(1));
				s.setnom_station(RS.getString(2));
				s.setlongitude(RS.getDouble(3));
				s.setlatitude(RS.getDouble(4));
			
				list.add(s);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
				
	}

	@Override
	public Station save(Station s) {
		try {
		    Connection conn = MyConnection.getInstance();
			String req = "INSERT INTO `station`( `Nom_station`,`Longitude`, `Latitude`) VALUES (?,?,?)" ;
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setString(1, s.getnom_station());
			ps.setDouble(2, s.getlongitude());
			ps.setDouble(3, s.getlatitude());
			
			Integer id = ps.executeUpdate();
			s.setId(id);
			System.out.println("Station ajouté!!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return s;
        
	}

	@Override
	public Station update(Station s) {
		 try {
			    Connection conn = MyConnection.getInstance();
	            String req = "UPDATE `station` SET `Longitude` ='" + s.getlongitude() +"', `Nom_station` = '" + s.getnom_station() + "', `Latitude`=  '" + s.getlatitude() + "' WHERE `station`.`Id_station`= " + s.getid_station() ; 
	            Statement st = conn.createStatement();
	            st.executeUpdate(req);
	            System.out.println("Station updated !");
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
		return null;
	}

	@Override
	public boolean remove(Integer id) {
		 try {
			 Connection conn = MyConnection.getInstance();
	            String req = "DELETE FROM `station` WHERE id_station = " + id;
	            Statement st = conn.createStatement();
	            st.executeUpdate(req);
	            System.out.println("Station deleted !");
	            return true;
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	            return false;
	        }

	}
	
	
	

}
