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

@WebServlet("/student")
public class StudentCardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentService studentService;
    private GroupService groupService;

    @Override
    public void init() {
        studentService = new StudentService();
        groupService=new GroupService();
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
        Group group=groupService.findByStudentId(id);
        if (student == null) {
            request.setAttribute("error", "Can't find selected student");
            request.getRequestDispatcher("/error").forward(request, response);
        }
        request.setAttribute("student", student);
        request.setAttribute("group", group);
        request.getRequestDispatcher("/student-card.jsp").forward(request, response);
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
                int id = Integer.parseInt(request.getParameter("id"));
                int age = Integer.parseInt(request.getParameter("age"));
                String groupName = request.getParameter("groupName");
                Group group=groupService.findByName(groupName);
                int groupId=group.getId();
                Student student = new Student(id, firstName, surname, age, groupId);
                studentService.update(student);
                List<Student> students = studentService.getAll();
                request.setAttribute("student_list", students);
                returnPage = "/list-students.jsp";
            } catch (NumberFormatException e) {
                returnPage = "/error";
            }
        }
        request.getRequestDispatcher(returnPage).forward(request, response);
    }
}
