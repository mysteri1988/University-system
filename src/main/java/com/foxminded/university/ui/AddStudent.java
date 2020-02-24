package com.foxminded.university.ui;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.StudentService;

@Controller
public class AddStudent {

    private StudentService studentService;
    private GroupService groupService;

    
    public AddStudent(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @PostMapping("/addstudent")
    public String addStudent(@ModelAttribute("student") @Validated Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Group> groups = groupService.findAll();
            model.addAttribute("group_list", groups);
            return "add-student-form";
        }
        studentService.create(student);
        return "redirect:/students";
    }
}
