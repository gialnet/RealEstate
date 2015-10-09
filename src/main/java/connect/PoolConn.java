/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author antonio https://github.com/gialnet/RealEstate.git
 */

public abstract class PoolConn {
    
    private static DataSource datasource;
    //protected Connection connection;
    private final String QuePool="jdbc/RealEstate";
    
    public PoolConn() throws SQLException, NamingException {
        
            Context ctx = new javax.naming.InitialContext();

            // 	 jdbc/myEmpresa001
            datasource = (DataSource) ctx.lookup(QuePool);

    }
    
    /**
     * Sobre carga del constructor para guardar compatibilidad con versiones
     * anteriores.
     * @param myPool
     * @throws SQLException
     * @throws NamingException 
     */
    public PoolConn(String myPool) throws SQLException, NamingException {
        
            Context ctx = new javax.naming.InitialContext();

            // 	 jdbc/myEmpresa001
            datasource = (DataSource) ctx.lookup(myPool);

    }
    
    /**
     * entregar una conexión a PostgreSQL desde el Pool de Glassfish
     * @return una conexión JDBC a PostgreSQL 9.2
     * @throws SQLException
     */
    public static Connection PGconectar() throws SQLException
    {

            Connection connection = null;

            synchronized (datasource) {
			connection = datasource.getConnection();
			}
            
            if (connection == null) {
                System.out.println("no se obtuvo la conexion");
            }
            
        return connection;
    }
    
}
