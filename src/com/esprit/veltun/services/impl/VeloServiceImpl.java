package com.esprit.veltun.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.veltun.model.Velo;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.VeloSearchCriteria;
import com.esprit.veltun.services.VeloService;
import com.esprit.veltun.util.MyConnection;

public class VeloServiceImpl implements VeloService{
	//@Override
		public Velo save(Velo v) {

			 try {
				 Connection conn = MyConnection.getInstance();
		            String req = "INSERT INTO `velo` (`libellev`, `taillev`, `couleurv`, `fournisseur`) VALUES (?,?,?,?)";
		            PreparedStatement ps=conn.prepareStatement(req);
		          
		            ps.setString(1, v.getLibelle());
		            ps.setString(2, v.getTaille());
		            ps.setString(3, v.getCouleur());
		            ps.setString(4, v.getFournisseur());

		             ps.executeUpdate();
		            System.out.println("velo ajouté!!!");
		        }catch (SQLException ex) {
					ex.printStackTrace();
				}
				return v;
		}

		@Override
		public Velo update(Velo v) {
			  try {
					 Connection conn = MyConnection.getInstance();
		            String req = "UPDATE `velo` SET `libellev` = '" + v.getLibelle() + "', `taillev` = '" + v.getTaille() + "', `couleurv` = '" + v.getCouleur() + "', `fournisseur` = '" + v.getFournisseur() + "' WHERE `velo`.`idv` = " + v.getId();
		            Statement st = conn.createStatement();
		            st.executeUpdate(req);
		            System.out.println("velo updated !");
		        }catch (SQLException ex) {
				ex.printStackTrace();
			}
			return v;
		}

		@Override
		public boolean remove(Integer id) {
			try {
				Connection conn = MyConnection.getInstance();
				String req = "DELETE FROM `velo` WHERE id = " + id;
				Statement st = conn.createStatement();
				st.executeUpdate(req);
				System.out.println("velo deleted !");
				return true;
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				return false;
			}
		}
		@Override
		public Collection<Velo> list() {
			List<Velo> list = new ArrayList<>();
			try {
			    Connection conn = MyConnection.getInstance();
				String req = "Select * from velo";
				Statement st = conn.createStatement();

				ResultSet RS = st.executeQuery(req);
				while (RS.next()) {
					Velo v = new Velo();

					
					 v.setLibelle(RS.getString(2));
		             v.setId(RS.getInt(1));
		             v.setTaille(RS.getString(3));
		             v.setCouleur(RS.getString(4));
		             v.setFournisseur(RS.getString(5));
		             list.add(v);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

			return list;
		}


		@Override
		public Velo findById(Integer id) {
			
			try {
				Connection conn = MyConnection.getInstance();
				String req = "SELECT FROM `fournisseur` WHERE id = " + id;
				Statement st = conn.createStatement();
				ResultSet RS = st.executeQuery(req);
				while (RS.next()) {
					Velo v = new Velo();
					 v.setLibelle(RS.getString(2));
		             v.setId(RS.getInt(1));
		             v.setTaille(RS.getString(3));
		             v.setCouleur(RS.getString(4));
		             v.setFournisseur(RS.getString(5));
					
					System.out.println("velo founded");
					return v;
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			return null;
		}

		
		
		

		@Override
		public Collection<Velo> search(SearchCriteria<Velo> searchCriteria) {
			List<Velo> list = new ArrayList<>();
			try {
				VeloSearchCriteria veloSearchCriteria = (VeloSearchCriteria) searchCriteria;
			    Connection conn = MyConnection.getInstance();

			    StringBuilder builder = new StringBuilder("Select * from velo");
				StringBuilder whereBuilder = new StringBuilder();
				
				if (veloSearchCriteria.getLibelle() != null && !veloSearchCriteria.getLibelle().isEmpty()) {
					if (!whereBuilder.toString().isEmpty()) {
						whereBuilder.append(" AND nomf=?");

					} else {
						whereBuilder.append(" WHERE nomf=?");
					}
				}
				
				if (veloSearchCriteria.getId() != null) {
					if (!whereBuilder.toString().isEmpty()) {
						whereBuilder.append(" AND id=?");

					} else {
						whereBuilder.append(" WHERE id=?");
					}
				}
				
				builder.append(whereBuilder);
				
				
				
				PreparedStatement st = conn.prepareStatement(builder.toString());
				int counter = 1;
				if (veloSearchCriteria.getLibelle() != null && !veloSearchCriteria.getLibelle().isEmpty()) {
					st.setString(counter, veloSearchCriteria.getLibelle());
					counter++;
				}

				
				if (veloSearchCriteria.getId() != null) {
					st.setInt(counter,veloSearchCriteria.getId());
					counter++;
				}
				
				if (veloSearchCriteria.getTaille() != null) {
					st.setString(counter, veloSearchCriteria.getTaille());
					counter++;
				}
				
				if (veloSearchCriteria.getCouleur() != null) {
					st.setString(counter, veloSearchCriteria.getCouleur());
					counter++;
				}
				
				if (veloSearchCriteria.getFournisseur() != null) {
					st.setString(counter, veloSearchCriteria.getFournisseur());
					counter++;
				}

				
				ResultSet RS = st.executeQuery();
				while (RS.next()) {
					Velo v = new Velo();

					
					v.setLibelle(RS.getString(2));
		             v.setId(RS.getInt(1));
		             v.setTaille(RS.getString(3));
		             v.setCouleur(RS.getString(4));
		             v.setFournisseur(RS.getString(5));
		             list.add(v);
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

			return list;
		}
			
		
	
}
