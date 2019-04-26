/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NancyAlarabawy
 */
public class HomePage extends HttpServlet {

    private static String INSERT = "/AddForm.html";
    private static String EDIT = "/EditList.html";
    private static String VIEW = "/ViewAllPage.html";
     private static String HOME = "/index.html";
    private StudentManager stdMan = new StudentManager();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               String forward = "";
        String action = request.getParameter("action");
        //response.setContentType("text/html");
        //PrintWriter out = response.getWriter();
        if (action.equalsIgnoreCase("insert")) {
            //AddServlet AS = new AddServlet();
            forward = INSERT;

        } else if (action.equalsIgnoreCase("edit")) {
            // AddServlet AS = new AddServlet();
            RequestDispatcher view = request.getRequestDispatcher("/EditList");
            view.forward(request, response);
           // forward = EDIT;

        } else if (action.equalsIgnoreCase("view")) {
            RequestDispatcher view = request.getRequestDispatcher("/ViewStudent");
            view.forward(request, response);

        }
        else if (action.equalsIgnoreCase("home")) {
            // AddServlet AS = new AddServlet();
            forward = HOME;

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

}
