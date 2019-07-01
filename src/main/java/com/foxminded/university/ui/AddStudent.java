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

@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentService studentService;
    private GroupService groupService;

    @Override
    public void init() {
        studentService = new StudentService();
        groupService=new GroupService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String returnPage = "";
        if (firstName.isEmpty() || surname.isEmpty()) {
            request.setAttribute("exception", "The firstName or surname field is empty");
            returnPage = "/error";
        } else {
            try {
                int age = Integer.parseInt(request.getParameter("age"));
                String groupName = request.getParameter("groupName");
                Group group=groupService.findByName(groupName);
                int groupId=group.getId();
                Student student = new Student(firstName, surname, age, groupId);
                studentService.create(student);
                returnPage = "list-students.jsp";
            } catch (NumberFormatException e) {
                returnPage = "/error";
            }
        }
        request.getRequestDispatcher(returnPage).forward(request, response);
    }
}
