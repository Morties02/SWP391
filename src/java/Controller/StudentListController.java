///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package Controller;
//
//import DAL.DAO.AccountDAO;
//import Model.Account;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "StudentListController", urlPatterns = {"/student-list"})
//public class StudentListController extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet StudentListController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet StudentListController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//     try {
//            AccountDAO dao = new AccountDAO();
//            List<Account> studentList = dao.getAllStudent();
//            request.setAttribute("studentList", studentList);
//            request.getRequestDispatcher("studentList.jsp").forward(request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StudentListController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//          String action = request.getParameter("action");
//
//        if (action != null) {
//            switch (action) {
//                case "add":
//                    addStudent(request, response);
//                    break;
//                case "update":
//                    updateStudent(request, response);
//                    break;
//                case "delete":
//                    deleteStudent(request, response);
//                    break;
//            }
//        }
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//    
//    private void addStudent(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String studentName = request.getParameter("studentName");
//
//        try {
//            
//            AccountDAO dao = new AccountDAO();
//            
//            Account student = new Account();
//            dao.addStudent(student);
//            response.sendRedirect("StudentServlet");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int studentId = Integer.parseInt(request.getParameter("studentId"));
//        String studentName = request.getParameter("studentName");
//
//        try {
//            Student student = new Student(studentId, studentName);
//            studentDAO.updateStudent(student);
//            response.sendRedirect("StudentServlet");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int studentId = Integer.parseInt(request.getParameter("studentId"));
//
//        try {
//            studentDAO.deleteStudent(studentId);
//            response.sendRedirect("StudentServlet");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
