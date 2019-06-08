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

@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet {
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
        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        String groupName = request.getParameter("groupName");
        List<Group> groups = groupService.getAll();
        String returnPage = "";
        for (Group group : groups) {
            if (group.getName().equals(groupName)) {
                Group currentGroup = groupService.findByName(groupName);
                int groupId = currentGroup.getId();
                Student student = new Student(id,firstName, surname, age, groupId);
                studentService.update(student);
                returnPage = "/listofstudents";
            } else {
                request.setAttribute("error", "Can't find current group for Student");
                returnPage = "/error";
            }
        }
        request.getRequestDispatcher(returnPage).forward(request, response);
    }
}
