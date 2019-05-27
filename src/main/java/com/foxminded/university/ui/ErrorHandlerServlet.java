package com.foxminded.university.ui;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "errorHandler", urlPatterns = "/error", loadOnStartup = 1)

public class ErrorHandlerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
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

        request.setAttribute("exception", exception);
        request.setAttribute("code", code);
        request.setAttribute("errormessage", errorMessage);
        request.setAttribute("requesturi", requestUri);
        request.setAttribute("servletname", servletName);

        request.getRequestDispatcher("/error-handler.jsp").forward(request, response);
    }

}
