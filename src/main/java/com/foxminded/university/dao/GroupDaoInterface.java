package com.foxminded.university.dao;

import java.util.List;

import com.foxminded.university.domain.Group;

public interface GroupDaoInterface {

    public void create(Group group);

    public Group findById(int id);

    public Group findByStudentId(int id);

    public Group findByName(String name);

    public void update(Group group);

    public void delete(Group group);

    public List<Group> getAll();

}
