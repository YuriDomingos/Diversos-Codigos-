/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escolajdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author  Yuri Francisco Domingos 
 * Data : 02 - 06 - 2020
 * Objectivo  : DAO ( DATA-ACCESS -OBJECT 
 */
public class estudanteDAO {
    
    
   //--- in this class I'll write all things about a lesson 
    
    
    private Connection con = null;

    public estudanteDAO() {
        
        con = ConnectionFactory.getConnection();
        
    }
    
    
    public boolean actualizar(estudante est)
    {
            PreparedStatement stmt = null;
            
            String sql = "UPDATE estudante SET estudante.nome = (?) WHERE estudante.id = (?)";
            
            try{
                stmt = con.prepareStatement(sql);
                
                stmt.setString(2, est.getNome());
                stmt.executeQuery();
                return true;
                
            }catch(SQLException ex)
            {
                System.err.println("err"+ex);
                return false;
                
            }finally
            {
                ConnectionFactory.closeConnection(con);
            }  

    }
    
    
    public boolean delete(estudante est)
    {
        PreparedStatement stmt = null;
        String sql = " DELETE FROM estudante WHERE estudante.id = (?)";
        
        try{
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(3, est.getID());
            stmt.executeUpdate();
            return true;
            
        }catch(SQLException ex)
        {
            System.err.println(""+ex);
            return false;
        }
        finally {
            
            ConnectionFactory.closeConnection(con);
        }
        
    }
    
    
    public List<estudante> findAll()
    {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<estudante> estudantes = new ArrayList<>();
        
        String sql = " SELECT *FROM estudante ";
        
        
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                estudante est = new estudante();
                
                est.setNome(rs.getString(sql));
                
                estudantes.add(est);
            }
            
            return estudantes;
            
            
        }catch(SQLException ex)
        {
            System.err.println("err"+ex);
            
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
        }
        return estudantes;
    }
    
    
    public boolean save(estudante etudier)
    {
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO estudantes VALUES (?)";
        
        try{
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, etudier.getNome());
            stmt.executeUpdate();
            return true;
            
        }catch(SQLException ex )
        {
            return false;
        }
        
    }
    
    
    
    
  
    
    
    

    
}
