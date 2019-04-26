/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NancyAlarabawy
 */
public class ViewStudent extends HttpServlet {

    private StudentManager stdMan = new StudentManager();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n"
                + "    <head>\n"
                + "        <title>Add Student</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" >\n"
                + "    <link rel=\"stylesheet\" href=\"https://bootswatch.com/4/journal/bootstrap.min.css\">\n"
                + "    </head>\n"
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
                + "        <a class=\"nav-link\" href=\"HomePage?action=edit\">Edit Student</a>\n"
                + "      </li>\n"
                + "      <li class=\"nav-item\">\n"
                + "        <a class=\"nav-link\" href=\"HomePage?action=insert\">Add Students</a>\n"
                + "      </li>\n"
                + "    </ul>\n"
                + "    \n"
                + "  </div>\n"
                + "</nav>"
                + "<table class=\"table table-hover\">\n"
                + "  <thead>\n"
                + "    <tr>\n"
                + "      <th scope=\"col\">ID</th>\n"
                + "      <th scope=\"col\">Name</th>\n"
                + "      <th scope=\"col\">Department</th>\n"
                + "      <th scope=\"col\">GPA</th>\n"
                + "       <th scope=\"col\">Year</th>\n"
                + "    </tr>\n"
                + "  </thead>\n"
        );

        for (int i = 0; i < stdMan.students.size(); i++) {
            out.println("<tbody>\n"
                    + "    <tr class=\"table-primary\">\n"
                    + "     <th scope=\"row\">" + stdMan.students.get(i).getID() + "</th>\n"
                    + "      <td>" + stdMan.students.get(i).getName() + "</td>\n"
                    + "      <td>" + stdMan.students.get(i).getDpt() + "</td>\n"
                    + "      <td>" + stdMan.students.get(i).getGPA() + "</td>\n"
                    + "      <td>" + stdMan.students.get(i).getGradYear() + "</td>\n"
                    + "    </tr>\n");
        }

        out.println(
                "  </tbody>\n"
                + "</table> "
                + "</body>"
                + "</html>");
    }
}
