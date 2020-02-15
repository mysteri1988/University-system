package com.foxminded.university.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxminded.university.dao.GroupDao;
import com.foxminded.university.dao.GroupDaoImpl;
import com.foxminded.university.domain.Group;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    @Transactional
    public void create(Group group) {
        groupDao.create(group);
    }

    @Override
    @Transactional
    public Group findById(int id) {
        return groupDao.findById(id);
    }

    @Override
    @Transactional
    public Group findByStudentId(int id) {
        return groupDao.findByStudentId(id);
    }

    @Override
    @Transactional
    public Group findByName(String name) {
        return groupDao.findByName(name);
    }

    @Override
    @Transactional
    public void update(Group group) {
        groupDao.update(group);
    }

    @Override
    @Transactional
    public void delete(Group group) {
        groupDao.delete(group);
    }

    @Override
    @Transactional
    public List<Group> getAll() {
        return groupDao.getAll();
    }

}
