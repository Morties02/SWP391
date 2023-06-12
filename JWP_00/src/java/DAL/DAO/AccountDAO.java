/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.DAO;

import DAL.DbContext;
import Model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccountDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
       public List<Account> getAllAccount() throws SQLException, ClassNotFoundException{
            String query = "select * from ACCOUNT";
            List<Account> listAccount = new ArrayList<>();

            try{
                conn = new DbContext().getConnection();
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                
                
                while(rs.next()){
                   listAccount.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), 0, 0));
                } 
                
                return listAccount;
            } catch(SQLException ex){
            } catch (ClassNotFoundException ex){
        } return listAccount;
        }
        
       public Account login(String username, String password) throws SQLException {
           
         AccountDAO dao = new AccountDAO();
         Account result = new Account();
           
        try {
            List<Account> listAccount = dao.getAllAccount();
            
            for(Account a: listAccount){
                if(a.getUsername().equals(username) && a.getPWD().equals(password)){
                    
                    result = a;
                    
                    return result;
                }
            }
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
       
        public List<Account> getAllStudent() throws SQLException, ClassNotFoundException{
            String query = "select * from ACCOUNT where RoleId = 3";
            List<Account> listAccount = new ArrayList<>();

            try{
                conn = new DbContext().getConnection();
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                
                
                while(rs.next()){
                   listAccount.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 0));
                } 
                
                return listAccount;
            } catch(SQLException ex){
            } catch (ClassNotFoundException ex){
        } return listAccount;
        }

}
