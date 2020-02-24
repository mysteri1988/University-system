package com.foxminded.university.dao;

import java.util.List;

import com.foxminded.university.domain.Group;

public interface GroupDao extends CrudDao<Group> {

    public void create(Group group);

    public Group findById(int id);

    public Group findByStudentId(int id);

    public Group findByName(String name);

    public void update(Group group);

    public void delete(Group group);

    public List<Group> findAll();

}
