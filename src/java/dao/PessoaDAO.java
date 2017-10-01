/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;

/**
 *
 * @author danilomonteiro
 */
public class PessoaDAO {
    
    PreparedStatement stmt;
    FactoryConnection con = new FactoryConnection();

    public void cadastrar(Pessoa p) {
       //Class.forName("com.mysql.jdbc.Driver");
    try{    
        
      stmt = con.getConnection().prepareStatement("INSERT INTO pessoa(nome, nivel, senha) VALUES(?,?,?)");
        
      stmt.setString(1, p.getNome());  
      stmt.setInt(2, p.getNivel());  
      stmt.setString(3, p.getSenha());  
        
      stmt.execute();        
      stmt.close();        
    }
    catch(SQLException e){
        System.out.println("erro de conexão" + e.getMessage());                              
        
    } catch(ClassNotFoundException e){
        System.out.println("Driver não encontrado");
        
    }
           
    }
    public ArrayList<Pessoa> listar() {
                
         ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
         
         try{
         
         
         stmt = con.getConnection().prepareStatement("SELECT * from pessoa");
         
         ResultSet rs = stmt.executeQuery();
         
         while(rs.next()){
             
             Pessoa p = new Pessoa();
             p.setNivel(rs.getString("nivel"));
             p.setId(rs.getInt("id"));
             p.setNome(rs.getString("nome"));
             p.setSenha(rs.getString("senha"));
             
             pessoas.add(p);  
         }
          } catch(SQLException e){
        System.out.println("erro de conexão" + e.getMessage());                              
        
    } catch(ClassNotFoundException e){
        System.out.println("Driver não encontrado");
        
    } 
        
         
        return pessoas; 
    }
    
    
    public void deletar(int id){
        
        try {
            stmt = con.getConnection().prepareStatement("DELETE from pessoa WHERE id=?");
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return;
    }
    
    public void atualizar(Pessoa p){
        try {
            stmt = con.getConnection().prepareStatement("UPDATE pessoa SET nome = ?, senha = ?, nivel = ? WHERE id=?");
            stmt.setInt(4, p.getId());
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getSenha());
            stmt.setInt(3, p.getNivel());
                        
            stmt.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return;
    }
    
}
