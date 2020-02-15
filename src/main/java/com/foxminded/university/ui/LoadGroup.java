package com.foxminded.university.ui;

import java.util.List;

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
public class LoadGroup {

    private StudentService studentService;

    private GroupService groupService;

    @Autowired
    public LoadGroup(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping("/group")
    public String loadGroup(@RequestParam("id") int theId, Model theModel) {
        Group group = groupService.findById(theId);
        List<Student> students = studentService.findByGroupId(theId);
        theModel.addAttribute("student_list", students);
        theModel.addAttribute("group", group);
        return "group-consist";

    }

}
