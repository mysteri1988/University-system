package com.foxminded.university.ui;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.StudentService;

@Controller
public class LoadStudent {

    private StudentService studentService;

    private GroupService groupService;

    public LoadStudent(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping("/loadstudent")
    public String loadStudent(@RequestParam("id") int theId, Model theModel) {
        List<Group> groups = groupService.findAll();
        Student student = studentService.findById(theId);
        theModel.addAttribute("student", student);
        theModel.addAttribute("group_list", groups);
        return "update-student";
    }
}
