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
                result.add(new Classes(rs.getInt(1), rs.getInt(3), rs.getString(2)));
            }
            return result;
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        } return result;
    }
}
