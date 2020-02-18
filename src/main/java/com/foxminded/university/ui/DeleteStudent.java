package com.foxminded.university.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foxminded.university.domain.Student;
import com.foxminded.university.service.StudentService;

@Controller
public class DeleteStudent {

    private StudentService studentService;

    public DeleteStudent(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/deletestudent")
    public String deleteStudent(@RequestParam("id") int theId) {
        Student student = studentService.findById(theId);
        studentService.delete(student);
        return "redirect:/students";
    }

}
