package com.foxminded.university.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.university.domain.Student;
import com.foxminded.university.service.StudentService;
import com.foxminded.university.service.StudentServiceException;

@WebServlet("/com.foxminded/Students")
public class StudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        try {
            studentService = new StudentService();
        } catch (StudentServiceException exc) {
            throw new ServletException("Cannot init StudentServlet", exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("studentId") != null) {
                loadStudent(request, response);
            } else {
                listStudents(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    } 

    private void loadStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("studentId"));
        Student theStudent = studentService.findById(id);
        request.setAttribute("STUDENT", theStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student-card.jsp");
        dispatcher.forward(request, response);
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = studentService.getAll();
        request.setAttribute("STUDENT_LIST", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
