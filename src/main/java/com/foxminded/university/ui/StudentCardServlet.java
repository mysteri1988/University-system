package com.foxminded.university.ui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.StudentService;
import com.foxminded.university.service.StudentServiceException;

@WebServlet("/studentcard")
public class StudentCardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService;
    private GroupService groupService;

    @Override
    public void init() throws ServletException {
        try {
            studentService = new StudentService();
            groupService = new GroupService();
        } catch (Exception exc) {
            throw new ServletException("Cannot init StudentCardServlet", exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("id").matches("[0-9]{3,}")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Group group = groupService.findByStudentId(id);
                Student student = studentService.findById(id);
                if (student == null) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/error-404.html");
                    dispatcher.forward(request, response);
                }
                request.setAttribute("student", student);
                request.setAttribute("group", group);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/student-card.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error-400.html");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

}
