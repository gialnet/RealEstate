/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realestate.property_views;

import com.gialnet.realestate.connect.PoolConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author antonio
 */
public class SQLPropertyViews extends PoolConn {

    public SQLPropertyViews() throws SQLException, NamingException {
        super();
    }
    
    /**
     * Leer la lista de tipos de proveedores
     * @return
     * @throws SQLException
     * @throws NamingException 
     */
    public List<TuplasPropertyViews> getTuplasPropertyViews() throws SQLException, NamingException {

        
        Connection conn = PGconectar();

        List<TuplasPropertyViews> Tuplas = new ArrayList<>();

        try {

            PreparedStatement st = conn.prepareStatement("SELECT * from properties_views order by id");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Tuplas.add(new TuplasPropertyViews.Builder(rs.getInt("id")).
                        Descripcion(rs.getString("descripcion")).
                        build());
            }
            
            st.close();

        } catch (SQLException e) {

            System.out.println("Property Views Connection Failed!");
            return null;

        } finally {

            conn.close();
        }
        return Tuplas;
    }
    
}