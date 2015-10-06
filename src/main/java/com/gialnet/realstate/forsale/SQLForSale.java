/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realstate.forsale;

import connect.PoolConn;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Usuario
 */
public class SQLForSale extends PoolConn {
     private final String version;

    public SQLForSale(String version) throws SQLException, NamingException {
        super();
        this.version = version;
    }
     
     
}
