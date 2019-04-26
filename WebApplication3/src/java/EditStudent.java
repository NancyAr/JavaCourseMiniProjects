/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NancyAlarabawy
 */
public class EditStudent extends HttpServlet {

    private StudentManager stdMan = new StudentManager();
    private static String EDIT = "/EditList.html";

    private EditList listMan = new EditList();
    private int idx;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("Students");
        idx = Integer.parseInt(name);
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>\n"
                + "<head>\n "
                + "<title>Edit Student</title>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "\n<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" >\n"
                + "    <link rel=\"stylesheet\" href=\"https://bootswatch.com/4/journal/bootstrap.min.css\">\n"
                + "    \n "
                + "</head>"
                + "    <body>\n"
                + "     <nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n"
                + "  <a class=\"navbar-brand\" href=\"#\">Navbar</a>\n"
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
                + "        <a class=\"nav-link\" href=\"HomePage?action=insert\">Add Student</a>\n"
                + "      </li>\n"
                + "      <li class=\"nav-item\">\n"
                + "        <a class=\"nav-link\" href=\"HomePage?action=view\">View Students</a>\n"
                + "      </li>\n"
                + "    </ul>\n"
                + "    \n"
                + "  </div>\n"
                + "</nav>"
                + "<body>\n"
                + "<div>\n "
                + "<label for=\"staticEmail\" class=\"col-sm-2 col-form-label\">Name: </label>"
                + "<label  class=\"\">" + stdMan.students.get(idx).getName() + "</label>"
                + "  <div class=\"form-group\">\n"
                + "<form action=\"EditStudent\" method=\"POST\">\n"
                + "ID <input type=\"number\" class=\"form-control\" name=\"ID\" placeholder\""+stdMan.students.get(idx).getID()+"\"/>\n"
                + "<br />\n"
                + "Department <input type=\"text\" class=\"form-control\" name=\"Department\" placeholder =\""+stdMan.students.get(idx).getDpt()+"\"/>\n"
                + "<br />\n"
                + "GPA <input type=\"number\" step=\"0.01\" class=\"form-control\" name=\"GPA\" placeholder =\""+stdMan.students.get(idx).getGPA()+"\"/>\n"
                + "<br />\n"
                + "Graduation Year <input type=\"number\" class=\"form-control\" name=\"Graduation Year\" placeholder =\""+stdMan.students.get(idx).getGradYear()+"\"/>\n"
                + "<input type=\"submit\" class=\"btn btn-primary\" value=\"Submit\" />\n"
                + "</form>\n"
                + "</div>\n"
                + "</body>\n"
                + "</html>");

    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        boolean error = false;
        if (stdMan.students.size() > 0) {
            for (int i = 0; i < stdMan.students.size(); i++) {
                if (stdMan.students.get(i).getID() == Integer.parseInt(request.getParameter("ID"))) {
                    
                    error = true;
                    //if(stdMan.students.get(idx).getID() == Integer.parseInt(request.getParameter("ID"))){
                    //error = false;
                    
                    //}
                   // if(error = true){
                    RequestDispatcher view = request.getRequestDispatcher("/error.html");
                    view.forward(request, response);
                
                    }
            
            }
        }
        //if(request.getParameter("ID")){ error = true;  RequestDispatcher view = request.getRequestDispatcher("/error.html");
          //  view.forward(request, response);}
        if(request.getParameter("ID").length()==0|| request.getParameter("Name").length()==0 || request.getParameter("GPA").length()==0 || request.getParameter("Department").length()==0|| request.getParameter("Graduation Year").length()==0){
            error = true;
            RequestDispatcher view = request.getRequestDispatcher("/error.html");
            view.forward(request, response);
        }
        if(error==false){
        String forward = "";
        String action = request.getParameter("action");
        stdMan.students.get(idx).setID(Integer.parseInt(request.getParameter("ID")));
        stdMan.students.get(idx).setDpt(request.getParameter("Department"));
        float f = Float.valueOf(request.getParameter("GPA").trim()).floatValue();
        stdMan.students.get(idx).setGPA(f);
        stdMan.students.get(idx).setGradYear(Integer.parseInt(request.getParameter("Graduation Year")));
        String title = "\"Your data is added successfully!\"";
        String docType
                = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";
        PrintWriter out = response.getWriter();
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
                + "        <a class=\"nav-link\" href=\"HomePage?action=insert\">Add Student</a>\n"
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
                + "  <strong>Well done!</strong> You successfully <a href=\"#\" class=\"alert-link\">edited this student</a>.\n"
                + "</div> \n"
                + "<ul>\n"
                + "  <li><b> ID</b>: "
                + stdMan.students.get(idx).getID()+ "\n"
                + "<li><b>Name</b>: \n"
                + stdMan.students.get(idx).getName() + "\n"
                + "<li><b>Department</b>: \n"
                + stdMan.students.get(idx).getDpt() + "\n"
                + "<li><b>GPA</b>: \n"
                + stdMan.students.get(idx).getGPA() + "\n"
                + "<li><b>Grad Year</b>: \n"
                + stdMan.students.get(idx).getGradYear() + "\n"
                + "</ul>\n"
                + "</body></html>");
        }
       

    }
}
