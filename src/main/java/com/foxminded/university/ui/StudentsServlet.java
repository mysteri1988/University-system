package com.foxminded.university.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.university.domain.Student;
import com.foxminded.university.service.StudentService;
import com.foxminded.university.service.StudentServiceException;

public class StudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        try {
            studentService = new StudentService();
        } catch (Exception e) {
            throw new ServletException("Cannot init StudentServlet", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Student> students = studentService.getAll();
            request.setAttribute("student_list", students);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
