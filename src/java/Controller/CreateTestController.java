package Controller;

import DAL.DAO.ClassDAO;
import DAL.DAO.QuestionDAO;
import DAL.DAO.TestDAO;
import Model.Classes;
import Model.Question;
import Model.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "TestController", urlPatterns = {"/create-test"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 50, // 50MB
    maxRequestSize = 1024 * 1024 * 50)
public class CreateTestController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ClassDAO dao = new ClassDAO();

            List<Classes> listClass = dao.getAllClass();

            request.setAttribute("listClass", listClass);

            request.getRequestDispatcher("createTest.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateTestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            TestDAO testDao = new TestDAO();
            QuestionDAO dao = new QuestionDAO();
            
            Part filePart = request.getPart("questionFile");
            String testName = request.getParameter("testName");
            String enrollKey = request.getParameter("enrollKey");
            
//            String fileName = filePart.getSubmittedFileName();
//            for (Part part : request.getParts()) {
//                part.write("/var/root/NetBeansProjects/JWP_00/web/src/img/" + fileName);
//            }
            InputStream contents = filePart.getInputStream();
            Scanner scan = new Scanner(contents);
            scan.useDelimiter("-|\n");
             
            List<Question> listQ = new ArrayList<Question>();
                     
             while(scan.hasNext()){
                 String details = scan.next();
                 String opt1 = scan.next();
                 String opt2 = scan.next();
                 String opt3 = scan.next();
                 String opt4 = scan.next();
                 String answ = scan.next();
                listQ.add(new Question(details,opt1, opt2, opt3, opt4, answ));
                }
             try {
                scan.close();
                contents.close();
            } catch (IOException ex) {
            }
            
//          List<Integer> listQId = dao.addQToBank(listQ);
            int testId = testDao.createTest(1,testName, enrollKey);
            testDao.addQtoTest(listQ, testId);
//          testDao.getQuestionOfTest(testId);
            List<Test> listTest = testDao.getAllTest();
            

            request.setAttribute("listTest", listTest);
            
           request.getRequestDispatcher("listTest.jsp").forward(request, response);
        }catch(Exception e){
        }
//        } catch (SQLException ex) {
//            Logger.getLogger(CreateTestController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(CreateTestController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
