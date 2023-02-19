package com.esprit.veltun.services.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.services.RackVeloService;
import com.esprit.veltun.util.MyConnection;

public class RackVeloImpl implements RackVeloService{

	@Override
	public RackVelo findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<RackVelo> list() {
		List<RackVelo> list = new ArrayList<>();
		try {
		    Connection conn = MyConnection.getInstance();
		    Statement ste;
			String req = "Select * from rackvelo";
			Statement st = conn.createStatement();

			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				RackVelo rv = new RackVelo();

				rv.setRefRack(RS.getInt(1));
				rv.setCapacite(RS.getInt(2));
				rv.setId_station(RS.getInt(3));
				
				
	
				list.add(rv);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
				
	}

	@Override
	public RackVelo save(RackVelo rv) {
		try {
		    Connection conn = MyConnection.getInstance();
			String req = "INSERT INTO `rackvelo`( `Ref_rack`,`Capacitee`, `id_station`) VALUES (?,?,?)" ;
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setInt(1, rv.getRefRack());
			ps.setInt(2, rv.getCapacite());
			ps.setInt(3, rv.getId_station());
			
			Integer id = ps.executeUpdate();
			rv.setId(id);
			System.out.println("Rack ajouté!!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rv;
	}

	@Override
	public RackVelo update(RackVelo rv) {
		try {
		    Connection conn = MyConnection.getInstance();
            String req = "UPDATE `rackvelo` SET `Ref_rack` ='" + rv.getRefRack() +"', `Capacitee` = '" + rv.getCapacite() + "', `Id_station`=  '" + rv.getId_station() + "' WHERE `rackvélo`.`Ref_rack`= " + rv.getRefRack() ; 
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Station updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
	return null;
	}

	@Override
	public boolean remove(Integer refRack) {
		 try {
			 Connection conn = MyConnection.getInstance();
	            String req = "DELETE FROM `rackvelo` WHERE Ref_rack = " + refRack;
	            Statement st = conn.createStatement();
	            st.executeUpdate(req);
	            System.out.println("Station deleted !");
	            return true;
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	            return false;
	        }	}

	@Override
	public Collection<RackVelo> search(SearchCriteria<RackVelo> searchCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
