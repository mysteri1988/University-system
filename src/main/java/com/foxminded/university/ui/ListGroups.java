package com.foxminded.university.ui;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foxminded.university.domain.Group;
import com.foxminded.university.service.GroupService;

@Controller
public class ListGroups {

    private GroupService groupService;

    public ListGroups(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(path = "/groups")
    public String listGroups(Model theModel) {
        List<Group> groups = groupService.findAll();
        theModel.addAttribute("group_list", groups);
        return "list-groups";
    }
}
