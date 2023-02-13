package com.esprit.veltun.services.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import com.esprit.veltun.enums.Response;
import com.esprit.veltun.model.Fournisseur;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.FournisseurSearchCriteria;
import com.esprit.veltun.services.FournisseurService;
import com.esprit.veltun.util.MyConnection;

public class FournisseurServiceImpl implements FournisseurService {
	

	//@Override
	public Fournisseur save(Fournisseur f) {

		try { 
			Connection conn = MyConnection.getInstance();
            String req = "INSERT INTO `fournisseur` (`nomf`, `regionf`) VALUES (?,?)";
            PreparedStatement ps=conn.prepareStatement(req);
          
            ps.setString(1, f.getNom());
            ps.setString(2, f.getRegion());
             ps.executeUpdate();
            System.out.println("fournisseur ajouté!!!");
        } catch (SQLException ex) {
			ex.printStackTrace();
		}
		return f;
	}

	@Override
	public Fournisseur update(Fournisseur f) {
		try {
			 
			Connection conn = MyConnection.getInstance();
            String req = "UPDATE `fournisseur` SET `nomf` = '" + f.getNom() + "', `regionf` = '" + f.getRegion() + "' WHERE `fournisseur`.`idf` = " + f.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("fournisseur updated !");
        }catch (SQLException ex) {
			ex.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean remove(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "DELETE FROM `fournisseur` WHERE id = " + id;
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("fournisseur deleted !");
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	@Override
	public Collection<Fournisseur> list() {
		List<Fournisseur> list = new ArrayList<>();
		try {
		    Connection conn = MyConnection.getInstance();
			String req = "Select * from fournisseur";
			Statement st = conn.createStatement();

			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Fournisseur f = new Fournisseur();

				
				 f.setNom(RS.getString(2));
	             f.setId(RS.getInt(1));
	             f.setRegion(RS.getString(3));
	             list.add(f);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
	}


	@Override
	public Fournisseur findById(Integer id) {
		
		try {
			Connection conn = MyConnection.getInstance();
			String req = "SELECT FROM `fournisseur` WHERE id = " + id;
			Statement st = conn.createStatement();
			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Fournisseur f = new Fournisseur();
				f.setId(RS.getInt(1));
				 f.setNom(RS.getString("nomf"));
	             f.setRegion(RS.getString(3));
				
				System.out.println("fournisseur founded");
				return f;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	
	
	

	@Override
	public Collection<Fournisseur> search(SearchCriteria<Fournisseur> searchCriteria) {
		List<Fournisseur> list = new ArrayList<>();
		try {
			FournisseurSearchCriteria fournisseurSearchCriteria = (FournisseurSearchCriteria) searchCriteria;
		    Connection conn = MyConnection.getInstance();

		    StringBuilder builder = new StringBuilder("Select * from fournisseur");
			StringBuilder whereBuilder = new StringBuilder();
			
			if (fournisseurSearchCriteria.getNom() != null && !fournisseurSearchCriteria.getNom().isEmpty()) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND nomf=?");

				} else {
					whereBuilder.append(" WHERE nomf=?");
				}
			}
			
			if (fournisseurSearchCriteria.getId() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND id=?");

				} else {
					whereBuilder.append(" WHERE id=?");
				}
			}
			
			builder.append(whereBuilder);
			
			
			
			PreparedStatement st = conn.prepareStatement(builder.toString());
			int counter = 1;
			if (fournisseurSearchCriteria.getNom() != null && !fournisseurSearchCriteria.getNom().isEmpty()) {
				st.setString(counter, fournisseurSearchCriteria.getNom());
				counter++;
			}

			
			if (fournisseurSearchCriteria.getId() != null) {
				st.setInt(counter, fournisseurSearchCriteria.getId());
				counter++;
			}
			if (fournisseurSearchCriteria.getRegion() != null) {
				st.setString(counter, fournisseurSearchCriteria.getRegion());
				counter++;
			}

			
			ResultSet RS = st.executeQuery();
			while (RS.next()) {
				Fournisseur f = new Fournisseur();

				
				 f.setNom(RS.getString(2));
	             f.setId(RS.getInt(1));
	             f.setRegion(RS.getString(3));
	             list.add(f);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
	}
		
	
}

	