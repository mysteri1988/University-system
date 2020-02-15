package com.foxminded.university.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.GroupService;

@Controller
public class LoadStudentForm {

    private GroupService groupService;

    @Autowired
    public LoadStudentForm(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/loadstudentform")
    public String loadStudentForm(Model theModel) {
        Student student = new Student();
        List<Group> groups = groupService.getAll();
        theModel.addAttribute("group_list", groups);
        theModel.addAttribute("student", student);
        return "add-student-form";
    }
}
