package com.foxminded.university.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.StudentService;

@WebServlet("/group")

public class GroupServlet extends HttpServlet {
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
        id = Integer.parseInt(request.getParameter("id"));
        Group group = groupService.findById(id);
        List<Student> students = studentService.findByGroupId(id);
        request.setAttribute("student_list", students);
        request.setAttribute("group", group);
        request.getRequestDispatcher("/group-consist.jsp").forward(request, response);
    }

}
