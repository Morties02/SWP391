/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAO.ClassDAO;
import Model.Classes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "StudentHomeController", urlPatterns = {"/student-home"})
public class StudentHomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            ClassDAO dao = new ClassDAO();
            
            List<Classes> stdClasses = dao.getClassOfStudent();
            List<Classes> listClass = dao.getAllClass();
            
            request.setAttribute("stdId", 2);
            
            request.setAttribute("stdClasses", stdClasses);
            request.setAttribute("allClasses", listClass);
            
            request.getRequestDispatcher("studentHome.jsp").forward(request, response);
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
            ClassDAO dao = new ClassDAO();
            
        try {
             List<Classes> stdClasses = dao.getClassOfStudent();
             List<Classes> listClass = dao.getAllClass();
            
            request.setAttribute("count", stdClasses.size());
            request.setAttribute("stdClasses", stdClasses);
            request.setAttribute("allclass", listClass);
            
            request.getRequestDispatcher("studentHome.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(StudentHomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentHomeController.class.getName()).log(Level.SEVERE, null, ex);
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
           ClassDAO dao = new ClassDAO();
           
           String searchString = request.getParameter("searchString");
            
        try {
             List<Classes> stdClasses = dao.getClassOfStudent();
             List<Classes> allClass = dao.getAllClass();
             List<Classes> listClass = new ArrayList<>();
             
             for(Classes c: allClass){
                 if(c.getClassName().contains(searchString)){
                     listClass.add(c);
                 }
             }
            
            request.setAttribute("count", stdClasses.size());
            request.setAttribute("stdClasses", stdClasses);
            request.setAttribute("allclass", listClass);
            
            request.getRequestDispatcher("studentHome.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(StudentHomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
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
