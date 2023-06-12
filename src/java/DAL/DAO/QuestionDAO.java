package DAL.DAO;

import DAL.DbContext;
import Model.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Integer> addQToBank(List<Question> list){
        
        List<Integer> idList = new ArrayList<Integer>();

        try{
        String query = "insert into Question(Details, Option1, Option2, Option3, Option4, Answer)"
                                   + "values(?, ?, ?, ?, ?, ?);SELECT SCOPE_IDENTITY();";
//        String query2 = "SELECT SCOPE_IDENTITY()";

            
            for(Question q: list){
                conn = new DbContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, q.getDetails());
                ps.setString(2, q.getOption1());
                ps.setString(3, q.getOption2());
                ps.setString(4, q.getOption3());
                ps.setString(5, q.getOption4());
                ps.setString(6, q.getAnswer());
                ps.executeUpdate();
//              Connection conn2 = new DbContext().getConnection();
//              PreparedStatement ps2 = conn.prepareStatement(query2);
//              rs = ps2.executeQuery();
//              idList.add(rs.getInt(1));
                idList.add(getLatestId());
            }
        
            return idList;
            
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        }   return idList;
    }
    
    public Integer getLatestId(){
        String query = "select * from Question";
        int id = 0;
        try {
            conn = new DbContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1);
            }
            return id;

        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

}
