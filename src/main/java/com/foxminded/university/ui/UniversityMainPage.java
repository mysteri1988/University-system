package com.foxminded.university.ui;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UniversityMainPage extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @GetMapping("/")
    public String loadHomePage() {
        return "university";
    }

}
