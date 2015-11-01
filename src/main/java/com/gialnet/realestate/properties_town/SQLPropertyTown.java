/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realestate.properties_town;

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
public class SQLPropertyTown extends PoolConn {

    public SQLPropertyTown() throws SQLException, NamingException {
        super();
    }
    
    /**
     * Leer la lista de tipos de proveedores
     * @return
     * @throws SQLException 
     * @throws NamingException 
     */
    public List<TuplasPropertyTown> getTuplasPropertyTown() throws SQLException, NamingException {

        
        Connection conn = PGconectar();

        List<TuplasPropertyTown> Tuplas = new ArrayList<>();

        try {

            PreparedStatement st = conn.prepareStatement("SELECT * from properties_town order by id");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Tuplas.add(new TuplasPropertyTown.Builder(rs.getInt("id")).
                        Descripcion(rs.getString("descripcion")).
                        build());
            }
            
            st.close();

        } catch (SQLException e) {

            System.out.println("Property Town Connection Failed!");
            return null;

        } finally {

            conn.close();
        }
        return Tuplas;
    }
    
}