package com.foxminded.university.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.StudentService;

@WebServlet("/studentcard")
public class StudentCardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentService studentService;
    private GroupService groupService;

    @Override
    public void init() {
        studentService = new StudentService();
        groupService = new GroupService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            request.getRequestDispatcher("/error").forward(request, response);
        }
        Student student = studentService.findById(id);
        if (student == null) {
            request.setAttribute("error", "Can't find selected student");
            request.getRequestDispatcher("/error").forward(request, response);
        }
        Group group = groupService.findByStudentId(id);
        request.setAttribute("student", student);
        request.setAttribute("group", group);
        request.getRequestDispatcher("/student-card.jsp").forward(request, response);
    }
}
