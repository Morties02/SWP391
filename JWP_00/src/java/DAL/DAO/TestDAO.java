package DAL.DAO;

import DAL.DbContext;
import Model.Question;
import Model.Test;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDAO {
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public Integer createTest(int classId,String testName, String key){
        
        try {
            
            conn = new DbContext().getConnection();
//          ps = conn.prepareStatement("select * from Test");
            CallableStatement cs = conn.prepareCall("insert into Test(ClassId, Name, EnrollKey) values(?,?, ?)");
            
            cs.setInt(1, classId);
            cs.setString(2, testName);
            cs.setString(3, key); 
            rs = cs.executeQuery();
            
            return getLatestId();
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return getLatestId();
    }
    
    public Test getTestById(int id){
        Test result = new Test(); 
        try{
            String query = "select * from Test where TestId = ?";
            
            conn = new DbContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
               result.setTestId(rs.getInt(1));
               result.setClassId(rs.getInt(2));
               result.setEnrollmentKey(rs.getString(3));
            }
            return result;
            
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        }
        return result;
    }

    public List<Question> getQuestionOfTest(int testId){
        
        List<Question> result = new ArrayList<Question>();
        
        try{
            String query = "select Question.QuestionId, Question.Details, Question.ImageUrl, Question.Option1, "
                    + "Question.Option2, Question.Option3, Question.Option4, Question.Answer\n" +
                "from (Question inner JOIN QuestionOfTest on Question.QuestionId = QuestionOfTest.QuestionId) where QuestionOfTest.TestId = ?";
            
            conn = new DbContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, testId);
            rs = ps.executeQuery();
            
            //Question.QuestionId, Question.Details, Question.ImageUrl, Question.Option1, 
            //Question.Option2, Question.Option3, Question.Option4, Question.Answer
            while(rs.next()){
                result.add(new Question(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            return result;
        
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        }
        return result;
    }
    
    public void addQtoTest(List<Question> list, int testId){
        
        QuestionDAO dao = new QuestionDAO();
        
        List<Integer> listId = dao.addQToBank(list);
        
            try{
            String query = "insert into QuestionOfTest(QuestionId, TestId) values(?, ?)";
            
            conn = new DbContext().getConnection();
            
            for(int i: listId){
                ps = conn.prepareStatement(query);
                ps.setInt(2, testId);
                ps.setInt(1, i);
                ps.executeUpdate();
            }
            
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        }
    }

    public Integer getLatestId(){
        String query = "select * from Test";
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

    public List<Test> getAllTest(){
        String query = "select * from Test";
        List<Test> result = new ArrayList<>();
        
        try {
            conn = new DbContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            //Test(int TestId, int ClassId, String EnrollmentKey)
            while(rs.next()){
               result.add(new Test(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4)));
            }
            return result;

        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
