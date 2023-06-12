package DAL.DAO;

import DAL.DbContext;
import Model.Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public void createClass(int LecturerId){
        try{
            String query = "insert into CLASS(LecturerId) values (?)";
            
            conn = new DbContext().getConnection();
            ps = conn.prepareCall(query);
            ps.setInt(1, LecturerId);
            ps.executeUpdate(query);
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        }
    }
    
    public List<Classes> getAllClass() throws SQLException, ClassNotFoundException{
        
        List<Classes> result = new ArrayList<Classes>();
        
        try{
            String query = "select * from CLASS";
            
            conn = new DbContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                result.add(new Classes(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getString(4)));
            }
            return result;
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        } return result;
    }
    
      public List<Classes> getClassOfStudent() throws SQLException, ClassNotFoundException{
        
        List<Classes> result = new ArrayList<Classes>();
        
        try{
            String query = "select CLASS.ClassName, CLASS.ClassId, CLASS.LecturerId from (CLASS inner join StudentOfClass on StudentOfClass.ClassId = CLASS.ClassId) where StudentOfClass.UserId = 2";
            
            conn = new DbContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                result.add(new Classes(rs.getInt(2), rs.getInt(3), rs.getString(1)));
            }
            return result;
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        } return result;
    }
      
      public Classes getClassById(int classId){
          
            Classes result = new Classes();
          
             try{
            String query = "select * from CLASS where ClassId = ?";
            
            conn = new DbContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, classId);
            rs = ps.executeQuery();
            
            while(rs.next()){
               result = new Classes(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getString(4));
            }
            return result;
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        } return result;
      }
    
      public boolean addStudentToClass(int stdId, int classId){
          
          boolean result = false;
             try{
            String query = "insert into StudentOfClass(UserId, ClassId) values (?, ?)";
            
            conn = new DbContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, stdId);
            ps.setInt(2, classId);
            if(    ps.executeUpdate() != 0){
                result = true;
            } return result;
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        } return result;
      }
    
}
