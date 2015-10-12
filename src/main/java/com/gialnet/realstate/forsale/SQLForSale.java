/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realstate.forsale;

import connect.PoolConn;
import static connect.PoolConn.PGconectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.naming.NamingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
                        Num_bedrooms(rs.getInt("num_bedrooms")).
                        Num_bathrooms(rs.getInt("num_bathrooms")).
                        Num_toilets(rs.getInt("num_toilets")).
                        Num_kitchens(rs.getInt("num_kitchens")).
                        Num_saloons(rs.getInt("num_saloons")).
                        Garage(rs.getInt("garage")).
                        Terrace(rs.getInt("terrace")).
                        Other_features(rs.getString("other_features")).
                        Views(rs.getString("views")).
                        Zona(rs.getString("zona")).
                        Urbanization(rs.getString("urbanization")).
                        Price(rs.getBigDecimal("price")).
                        Meters(rs.getInt("meters")).
                        Photos(rs.getString("photos")).
                        Keys(rs.getString("keys")).
                        Direccion(rs.getString("direccion")).
                        Objeto(rs.getString("objeto")).
                        Poblacion(rs.getString("poblacion")).
                        Remarks(rs.getString("remarks")).
                        Nota_simple(rs.getBytes("nota_simple")).
                        Estado(rs.getString("estado")).
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
    
     /**
      * Propiedades ordenadas por las más recientes
      * @param NumPage
      * @param SizePage
      * @return
      * @throws SQLException 
      */
     public List<TuplasForSale> getTuplasForSale(int NumPage,int SizePage) throws SQLException{
         
         Connection conn = PGconectar();
         List<TuplasForSale> tf = new ArrayList<>();
         
         try {

            int Offset = SizePage * (NumPage-1);
            PreparedStatement st = conn.prepareStatement("SELECT * from vw_properties order by id desc LIMIT ? OFFSET ?");
            st.setInt(1, SizePage);
            st.setInt(2, Offset);
            
            ResultSet rs = st.executeQuery();


            while (rs.next()) {

                tf.add( new TuplasForSale.Builder(rs.getInt("id")).
                        Tipo_vivienda(rs.getString("tipo_vivienda")).
                        Num_bedrooms(rs.getInt("num_bedrooms")).
                        Garage(rs.getInt("garage")).
                        Zona(rs.getString("zona")).
                        Urbanization(rs.getString("urbanization")).
                        Price(rs.getBigDecimal("price")).
                        build(Locale.GERMANY));
                
            }
            
            st.close();

        } catch (SQLException e) {

            System.out.println("vw_properties Connection Failed!");

        } finally {

            conn.close();
        }
        
        return tf;
         
     }
     
     /**
      * 
      * @param SearchFilter
      * @param NumPage
      * @param SizePage
      * @return
      * @throws SQLException 
      */
     public List<TuplasForSale> getTuplasForSale(String SearchFilter, int NumPage,int SizePage) throws SQLException{
         
         Connection conn = PGconectar();
         List<TuplasForSale> tf = new ArrayList<>();
         
         // Analizar el filtro de busqueda
         AnalizeFilter(SearchFilter);
         
         // Componer el qwery en función del filtro de busqueda
         // SELECT * from vw_properties order by id desc LIMIT ? OFFSET ?
         
         try {

            int Offset = SizePage * (NumPage-1);
            PreparedStatement st = conn.prepareStatement("SELECT * from vw_properties order by id desc LIMIT ? OFFSET ?");
            st.setInt(1, SizePage);
            st.setInt(2, Offset);
            
            ResultSet rs = st.executeQuery();


            while (rs.next()) {

                tf.add( new TuplasForSale.Builder(rs.getInt("id")).
                        Tipo_vivienda(rs.getString("tipo_vivienda")).
                        Num_bedrooms(rs.getInt("num_bedrooms")).
                        Garage(rs.getInt("garage")).
                        Zona(rs.getString("zona")).
                        Urbanization(rs.getString("urbanization")).
                        Price(rs.getBigDecimal("price")).
                        build(Locale.GERMANY));
                
            }
            
            st.close();

        } catch (SQLException e) {

            System.out.println("vw_properties Connection Failed!");

        } finally {

            conn.close();
        }
        
        return tf;
         
     }
     
     /**
      * 
      * @param Searchfilter 
      */
     private void AnalizeFilter(String Searchfilter){
        
         
         StringBuilder sb = new StringBuilder();
         
         JSONObject jsonObject = null;
                    
                    // 
                    try {
                        
                     jsonObject = (JSONObject) new JSONParser().parse(Searchfilter);
                     
                    } catch (ParseException e) {
                     throw new RuntimeException("Unable to parse json " + Searchfilter);
                    }

                    /*
                     * '{   "num_bedrooms": "3", 
                            "garage": "yes",
                            "tipo_vivienda": "flat",
                            "price": "< 300 mil"
                        }'::json
                     */
                    
                    String num_bedrooms = (String) jsonObject.get("num_bedrooms");
                    sb.append("num_bedrooms=").append(num_bedrooms);
                    
                    
         if ("Hola".equals(Searchfilter))
         {
             Searchfilter="";
         }
     }
     
}
