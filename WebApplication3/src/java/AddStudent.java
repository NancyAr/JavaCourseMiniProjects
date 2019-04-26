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
public class AddStudent extends HttpServlet {

    private StudentManager stdMan = new StudentManager();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        Student S;
        S = stdMan.getstudent();
        PrintWriter out = response.getWriter();
        String title = "\"Your data is added successfully!\"";
        String docType
                = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";
        out.println(docType
                + "<html>\n"
                + "<head><title>" + title + "</title></head>\n"
                + "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" >"
                + "<link rel=\"stylesheet\" href=\"https://bootswatch.com/4/journal/bootstrap.min.css\">"
                + "<body bgcolor=\"#f0f0f0\">\n "
                + "<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n"
                + "<a class=\"navbar-brand\" href=\"#\">Navbar</a>\n"
                + "  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarColor01\" aria-controls=\"navbarColor01\" aria-label=\"Toggle navigation\">\n"
                + "    <span class=\"navbar-toggler-icon\"></span>\n"
                + "  </button>\n"
                + "\n"
                + "  <div class=\"collapse navbar-collapse\" id=\"navbarColor01\">\n"
                + "    <ul class=\"navbar-nav mr-auto\">\n"
                + "      <li class=\"nav-item active\">\n"
                + "        <a class=\"nav-link\" href=\"HomePage?action=home\">Home <span class=\"sr-only\">(current)</span></a>\n"
                + "      </li>\n"
                + "      <li class=\"nav-item\">\n"
                + "        <a class=\"nav-link\" href=\"HomePage?action=edit\">Edit Student</a>\n"
                + "      </li>\n"
                + "      <li class=\"nav-item\">\n"
                + "        <a class=\"nav-link\" href=\"HomePage?action=view\">View Students</a>\n"
                + "      </li>\n"
                + "    </ul>\n"
                + "    \n"
                + "  </div>\n"
                + "</nav>"
                + "<div class=\"alert alert-dismissible alert-success\">\n"
                + "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
                + "  <strong>Well done!</strong> You successfully <a href=\"#\" class=\"alert-link\">added this student</a>.\n"
                + "</div> \n"
                + "<ul>\n"
                + "  <li><b> ID</b>: "
                + S.getID() + "\n"
                + "  <li><b> Name</b>: "
                + S.getName() + "\n"
                + "</ul>\n"
                + "<div><p><a href=\"HomePage?action=insert\"><input type=\"submit\" class=\"btn btn-secondary\" value=\"Add Another Student?\" name=\"AddStudent\" style=\"text-align: left\" /> </a></p><div>"
                + "</body></html>");
    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        boolean error = false;
        PrintWriter out = response.getWriter();
        Student S;
        S = new Student();
        if (stdMan.students.size() > 0) {
            for (int i = 0; i < stdMan.students.size(); i++) {
                if (stdMan.students.get(i).getID() == Integer.parseInt(request.getParameter("ID"))) {
                    error = true;
                    RequestDispatcher view = request.getRequestDispatcher("/error.html");
                    view.forward(request, response);
                }
            }
        }
        if(request.getParameter("ID").length()==0 || request.getParameter("Name").length()==0 || request.getParameter("GPA").length()==0 || request.getParameter("Department").length()==0 || request.getParameter("Graduation Year").length()==0){
            error = true;
            RequestDispatcher view = request.getRequestDispatcher("/error2.html");
            view.forward(request, response);
        }
        if(error==false){
        S.setID(Integer.parseInt(request.getParameter("ID")));
        S.setName(request.getParameter("Name"));
        S.setDpt(request.getParameter("Department"));
        float f = Float.valueOf(request.getParameter("GPA").trim()).floatValue();
        S.setGPA(f);
        S.setGradYear(Integer.parseInt(request.getParameter("Graduation Year")));
        stdMan.Addstudent(S);

        doGet(request, response);
        }

    }

}
