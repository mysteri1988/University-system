package com.foxminded.university.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxminded.university.dao.GroupDao;
import com.foxminded.university.dao.impl.GroupDaoImpl;
import com.foxminded.university.domain.Group;
import com.foxminded.university.service.GroupService;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao;

    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void create(Group group) {
        groupDao.create(group);
    }

    @Override
    public Group findById(int id) {
        return groupDao.findById(id);
    }

    @Override
    public Group findByStudentId(int id) {
        return groupDao.findByStudentId(id);
    }

    @Override
    public Group findByName(String name) {
        return groupDao.findByName(name);
    }

    @Override
    public void update(Group group) {
        groupDao.update(group);
    }

    @Override
    public void delete(Group group) {
        groupDao.delete(group);
    }

    @Override
    public List<Group> findAll() {
        return groupDao.findAll();
    }

}
