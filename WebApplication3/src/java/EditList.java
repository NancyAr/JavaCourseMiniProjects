/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NancyAlarabawy
 */
public class EditList extends HttpServlet {

    private StudentManager stdMan = new StudentManager();
    public static String Students = "";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String docType
                = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";
        out.println(docType
                + "<html>\n"
                + "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n <meta charset=\"UTF-8\">\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" >\n"
                + "<link rel=\"stylesheet\" href=\"https://bootswatch.com/4/journal/bootstrap.min.css\">\n"
                + "    "
                + "<title>Student List</title></head>\n"
                + "<h1 align=\"center\"> Please select a student</h1>\n"
                + "<body>\n"
                + "<div class=\"form-group\">\n"
                + "<label for=\"exampleSelect1\">Students Names</label>"
                + "<form action=\"EditStudent\" method=\"GET\">"
                + "<select name=\"Students\" class=\"form-control\" id=\"exampleSelect1\" width: \"100px\">\n");
        for (int i = 0; i < stdMan.students.size(); i++) {
            out.println("<option value=\"" + i + "\">" + stdMan.students.get(i).getName() + "</option>\n");
        }
        out.println("</select>\n ");
        out.println("\n"
                + "<p><a href=\"EditStudent?action=edit\"><input type=\"submit\" class =\"btn btn-primary\" value=\"Edit Student\" name=\"EditStudent\" /> </a></p>\n"
                + "</form>\n"
                + " </body>\n"
                + " </html>");

        doPost(request, response);

    }

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    }
}
