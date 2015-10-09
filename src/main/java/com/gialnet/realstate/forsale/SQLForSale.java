/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realstate.forsale;

import connect.PoolConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Usuario
 */
public class SQLForSale extends PoolConn {
     //private final String version="1.0";

    /**
     * 
     * @throws SQLException
     * @throws NamingException 
     */
    public SQLForSale() throws SQLException, NamingException {
        super();
        
    }
    
    /**
     * 
     * @param xIDProperty
     * @return
     * @throws SQLException 
     */
     public TuplasForSale getTuplasForSale(int xIDProperty) throws SQLException{
         Connection conn = PGconectar();
         TuplasForSale Tupla = null;
         
      
         try {
          
            PreparedStatement st = conn.prepareStatement("SELECT * from properties_for_sale where id=?");
            st.setInt(1, xIDProperty);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Tupla = new TuplasForSale.Builder(rs.getInt("id")).
                        Owner(rs.getInt("owner")).
                        Tipo_vivienda(rs.getString("tipo_vivienda")).
                        build();
            }
            
            
         } catch (Exception e) {
            
             System.out.println("SELECT * from properties_for_sale where id=? Connection Failed!");
             return null;
             
         } finally{
             
             conn.close();
         }
               
         return Tupla;
     }
    
     
}
