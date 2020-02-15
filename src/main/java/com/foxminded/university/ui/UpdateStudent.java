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
public class UpdateStudent {

    private StudentService studentService;

    private GroupService groupService;

    @Autowired
    public UpdateStudent(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @PostMapping("/updatestudent")
    public String updateStudent(@ModelAttribute("student") @Validated Student student, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            List<Group> groups = groupService.getAll();
            model.addAttribute("group_list", groups);
            return "update-student";
        }
        studentService.update(student);
        return "redirect:/students";
    }

}
