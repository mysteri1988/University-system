package com.foxminded.university.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandlerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        //Class exceptionClass = (Class) request.getAttribute("javax.servlet.error.exception_type");
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        if (servletName == null) {
            servletName = "Unknown";
        }

        if (requestUri == null) {
            requestUri = "Unknown";
        }

        PrintWriter out = response.getWriter();

        response.setContentType("text/html");

        String title = "Error details";
        String docType = "<!DOCTYPE html>";

        out.println(docType + "<html>" + "<head>" + "<title>" + title + "</title>" + "</head>" + "<body>");
        if (code != 500) {
            out.write("<h3>Error Details</h3>");
            out.write("<strong>Status Code</strong>:" + code + "<br>");
            out.write("<strong>Requested URI</strong>:" + requestUri);
        } else {
            out.write("<h3>Exception Details</h3>");
            out.write("<ul><li>Servlet Name:" + servletName + "</li>");
            out.write("<li>Exception Name:" + exception + "</li>");
            out.write("<li>Requested URI:" + requestUri + "</li>");
            out.write("<li>Exception Message:" + errorMessage + "</li>");
            out.write("</ul>");
        }

        out.write("<br><br>");
        out.write("<a href='./university'>Home Page</a>");
        out.write("</body></html>");
        
        /*writer.println("<h1>Error information</h1>");
        writer.println("<p>"+"Exception: "+exception+"</p>");
        writer.println("<p>"+"Exception class: "+exceptionClass+"</p>");
        writer.println("<p>"+"Error message: "+errorMessage+"</p>");
        writer.println("<p>"+"Code: " + code+"</p>");
        writer.println("<p>"+"Request url: "+requestUri+"</p>");
        writer.println("<p>"+"Servlet name: "+servletName+"</p>");
        
        writer.println("</body>");
        writer.println("</html>");*/
    }

}
