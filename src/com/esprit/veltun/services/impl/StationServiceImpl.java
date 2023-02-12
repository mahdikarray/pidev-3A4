package com.esprit.veltun.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import com.esprit.veltun.model.base.BaseEntity;

import com.esprit.veltun.model.Station;
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
		// TODO Auto-generated method stub
		return null;
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
	            String req = "UPDATE `station` SET `longitude` ='" + s.getlongitude() +"', `nom_station` = '" + s.getnom_station() + "', `latitude=` = '" + s.getlatitude() + "' WHERE 'station'.'id_station'= " + s.getid_station() ; 
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
