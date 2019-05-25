package com.foxminded.university.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.university.domain.Group;
import com.foxminded.university.service.GroupService;

public class ListGroupsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GroupService groupService;

    public void init() throws ServletException {
        try {
            groupService = new GroupService();
        } catch (Exception e) {
            throw new ServletException("Cannot init GroupServlet", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Group> groups = groupService.getAll();
            request.setAttribute("group_list", groups);
            request.getRequestDispatcher("/list-groups.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Cannot show the list of groups", e);
        }

    }
}
