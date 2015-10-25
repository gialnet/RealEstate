/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realestate.customers;

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
public class SQLCustomersType extends PoolConn {

    public SQLCustomersType() throws SQLException, NamingException {
        super();
    }
    
    /**
     * Leer la lista de tipos de proveedores
     * @return
     * @throws SQLException
     * @throws NamingException 
     */
    public List<TuplasCustomersType> getTuplasCustomersType() throws SQLException, NamingException {

        
        Connection conn = PGconectar();

        List<TuplasCustomersType> Tuplas = new ArrayList<>();

        try {

            PreparedStatement st = conn.prepareStatement("SELECT * from customers_type order by id");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Tuplas.add(new TuplasCustomersType.Builder(rs.getInt("id")).
                        Descripcion(rs.getString("descripcion")).
                        Cuenta(rs.getString("cuenta")).
                        Gasto(rs.getString("gasto")).
                        build());
            }
            
            st.close();

        } catch (SQLException e) {

            System.out.println("customers_type Connection Failed!");
            return null;

        } finally {

            conn.close();
        }
        return Tuplas;
    }
    
}