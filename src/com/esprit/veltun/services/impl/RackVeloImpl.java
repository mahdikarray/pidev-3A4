//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.services.impl;

import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.services.RackVeloService;
import com.esprit.veltun.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class RackVeloImpl implements RackVeloService {
    public RackVeloImpl() {
    }

    public RackVelo findById(Integer id) {
        return null;
    }

    public Collection<RackVelo> list() {
        ArrayList list = new ArrayList();

        try {
            Connection conn = MyConnection.getInstance();
            String req = "Select * from rackvelo";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);

            while(RS.next()) {
                RackVelo rv = new RackVelo();
                rv.setRefRack(RS.getInt(1));
                rv.setCapacite(RS.getInt(2));
                rv.setId_station(RS.getInt(3));
                list.add(rv);
            }
        } catch (SQLException var8) {
            System.out.println(var8.getMessage());
        }

        return list;
    }

    public RackVelo save(RackVelo rv) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "INSERT INTO `rackvelo`( `Ref_rack`,`Capacite`, `id_station`) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, rv.getRefRack());
            ps.setInt(2, rv.getCapacite());
            ps.setInt(3, rv.getId_station());
            Integer id = ps.executeUpdate();
            rv.setId(id);
            System.out.println("Rack ajouté!!!");
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return rv;
    }

    public RackVelo update(RackVelo rv) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "UPDATE `rackvelo` SET `Ref_rack` ='" + rv.getRefRack() + "', `Capacite` = '" + rv.getCapacite() + "', `Id_station`=  '" + rv.getId_station() + "' WHERE `rackvelo`.`Ref_rack`= " + rv.getRefRack();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Station updated !");
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
        }

        return null;
    }

    public boolean remove(Integer refRack) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "DELETE FROM `rackvelo` WHERE Ref_rack = " + refRack;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Station deleted !");
            return true;
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
            return false;
        }
    }

    public Collection<RackVelo> search(SearchCriteria<RackVelo> searchCriteria) {
        return null;
    }
}
