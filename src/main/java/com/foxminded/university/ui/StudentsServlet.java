package com.foxminded.university.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.domain.Student;

/**
 * Servlet implementation class StudentsServlet
 */

public class StudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            studentDao = new StudentDao();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String theCommand = request.getParameter("command");
        try {
            if (theCommand == null) {
                theCommand = "LIST";
            }
            // route to the appropriate method
            switch (theCommand) {
            case "LIST":
                listStudents(request, response);
                break;
            case "LOAD":
                loadStudent(request, response);
                break;
            default:
                listStudents(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void loadStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("studentId"));
        Student theStudent = studentDao.findById(id);
        request.setAttribute("STUDENT", theStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student-card.jsp");
        dispatcher.forward(request, response);
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = studentDao.getAll();
        request.setAttribute("STUDENT_LIST", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
