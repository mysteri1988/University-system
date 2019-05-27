package com.foxminded.university.ui;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.university.domain.Student;
import com.foxminded.university.service.StudentService;

@WebServlet("/listofstudents")

public class StudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService;

    @Override
    public void init() {
        studentService = new StudentService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Student> students = studentService.getAll();
            request.setAttribute("student_list", students);
            request.getRequestDispatcher("/list-students.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Cannot show the list of all student", e);
        }
    }
}
