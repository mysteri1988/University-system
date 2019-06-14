package com.foxminded.university.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.university.domain.Group;
import com.foxminded.university.service.GroupService;

@WebServlet("/loadgroup")
public class LoadGroup extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GroupService groupService;

    @Override
    public void init() {
        groupService = new GroupService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Group> groups = groupService.getAll();
        request.setAttribute("group_list", groups);
        request.getRequestDispatcher("/add-student-form.jsp").forward(request, response);
    }

}
