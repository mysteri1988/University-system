package com.foxminded.university.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.StudentService;

@Controller
public class StudentInformation {

    private StudentService studentService;

    private GroupService groupService;

    public StudentInformation(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping("/student")
    public String loadStudentCard(@RequestParam("id") int theId, Model theModel) {
        Student student = studentService.findById(theId);
        Group group = groupService.findByStudentId(theId);
        theModel.addAttribute("student", student);
        theModel.addAttribute("group", group);
        return "student-card";
    }
}
