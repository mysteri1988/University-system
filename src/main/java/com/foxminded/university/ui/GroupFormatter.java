package com.foxminded.university.ui;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.foxminded.university.domain.Group;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.impl.GroupServiceImpl;

@Component
public class GroupFormatter implements Formatter<Group> {

    private GroupService groupService;

    public GroupFormatter(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public String print(Group group, Locale arg1) {
        int id = group.getId();
        return Integer.toString(id);
    }

    @Override
    public Group parse(String id, Locale arg1) throws ParseException {
        return groupService.findById(Integer.parseInt(id));
    }

}
