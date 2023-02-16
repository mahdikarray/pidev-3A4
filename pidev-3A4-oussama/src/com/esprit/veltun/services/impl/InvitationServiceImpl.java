package com.esprit.veltun.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.model.User;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.services.InvitationService;
import com.esprit.veltun.util.MyConnection;

public class InvitationServiceImpl implements InvitationService {

	@Override
	public Invitation findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Invitation> list() {
		List<Invitation> list = new ArrayList<>();
		try {
		    Connection conn = MyConnection.getInstance();
		    Statement ste;
			String req = "Select * from invitation";
			Statement st = conn.createStatement();

			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
//				Invitation entity = new Invitation();
//
//				u.setCIN(RS.getString(1));
//				u.setNom(RS.getString(2));
//				u.setPrenom(RS.getString(3));
//				u.setDateNaiss(RS.getDate(4));
//				u.setType(RS.getString(5));
//				u.setCodePos(RS.getInt(6));
//				u.setEmail(RS.getString(7));
//				list.add();
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;}

	@Override
	public Invitation save(Invitation entity) {

		try {
		    Connection conn = MyConnection.getInstance();
			String req = "INSERT INTO `invitation`( `id` ) VALUES (?)";
			PreparedStatement ps = conn.prepareStatement(req);
			
			ps.setInt(1, entity.getId());
			
			
			
			
			Integer id = ps.executeUpdate();
			entity.setId(id);
			System.out.println("user ajouté!!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return entity;
	}

	@Override
	public Invitation update(Invitation entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Invitation> search(SearchCriteria<Invitation> searchCriteria) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
