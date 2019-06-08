package com.foxminded.university.service;

import java.util.List;

import com.foxminded.university.dao.GroupDao;
import com.foxminded.university.domain.Group;

public class GroupService {

    private GroupDao groupDao = new GroupDao();

    public Group create(Group group) {
        return groupDao.create(group);
    }

    public Group findById(int id) {
        return groupDao.findById(id);
    }
    
    public Group findByStudentId(int id) {
        return groupDao.findByStudentId(id);
    }

    public Group findByName(String name) {
        return groupDao.findByName(name);
    }

    public Group update(Group group) {
        return groupDao.update(group);
    }

    public void delete(Group group) {
        groupDao.delete(group);
    }

    public List<Group> getAll() {
        return groupDao.getAll();
    }

}
