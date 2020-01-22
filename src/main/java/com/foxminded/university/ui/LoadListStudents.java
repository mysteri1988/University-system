package com.foxminded.university.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.StudentServiceInterface;

@Controller
public class LoadListStudents {

    @Autowired
    private StudentServiceInterface studentService;

    @GetMapping("/students")
    public String listStudents(Model theModel) {
        List<Student> students = studentService.getAll();
        theModel.addAttribute("student_list", students);
        return "list-students";
    }

}
