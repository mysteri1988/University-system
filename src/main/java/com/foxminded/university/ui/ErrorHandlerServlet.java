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
        Class exceptionClass = (Class) request.getAttribute("javax.servlet.error.exception_type");
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        PrintWriter writer = response.getWriter();

        response.setContentType("text/html");

        String title = "Error Handling";
        String docType = "<!DOCTYPE html>";

        writer.println(docType + "<html>" + "<head>" + "<title>" + title + "</title>" + "</head>" + "<body>");

        writer.println("<h1>Error information</h1>");
        writer.println("Exception: "+exception);
        writer.println("Exception class: "+exceptionClass);
        writer.println("Error message: "+errorMessage);
        writer.println("Code: " + code);
        writer.println("Request url: "+requestUri);
        writer.println("Servlet name: "+servletName);
        
        writer.println("</body>");
        writer.println("</html>");
    }

}
