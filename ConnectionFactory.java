/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escolajdbc;
import java.sql.*;

/**
 *
 * @author Yuri Francisco Domingos 
 * Data 02 - 06 - 2020
 * Objectivo : Descrever  a main 
 */
public class ConnectionFactory {
    
    private static String driver = "org.postgresql.Driver";
    private static String url = "jdbc : postgresql ://localhost : 5432 //dbname";
    private static String user = " root";
    private static String pass = "";
    
    
    public static Connection getConnection()
    {
        try{
            
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
            
        }catch(ClassNotFoundException | SQLException ex )
        {
            throw new RuntimeException(" error could not open "+ex);
        }
     
    }
    
    
    
    public static void closeConnection(Connection con)
    {
        
        if ( con != null)
        {
            try{
                con.close();
            }catch(SQLException ex)
            {
                System.err.println(""+ex);
            }
        }
        
    }
    
    
    //--  
      
    public static void closeConnection(Connection con, PreparedStatement stmt)
            
    {
        
        if ( stmt!= null)
        {
            try{
                stmt.close();
            }catch(SQLException ex)
            {
                System.err.println(""+ex);
            }
        }
        
        closeConnection(con);
        
    }
    
    
      
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs)
    {
        
        if ( rs != null)
        {
            try{
                rs.close();
            }catch(SQLException ex)
            {
                System.err.println(""+ex);
            }
        }
        closeConnection(con,stmt);
    }
    
}



     
    
 
