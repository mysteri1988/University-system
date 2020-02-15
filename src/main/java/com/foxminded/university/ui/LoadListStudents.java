package com.foxminded.university.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.StudentServiceImpl;
import com.foxminded.university.service.StudentService;

@Controller
public class LoadListStudents {

    private StudentService studentService;
    
    @Autowired
    public LoadListStudents(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model theModel) {
        List<Student> students = studentService.getAll();
        theModel.addAttribute("student_list", students);
        return "list-students";
    }

}
