package com.foxminded.university.dao;

import java.util.List;

import com.foxminded.university.domain.Student;

public interface StudentDaoInterface {

    public void create(Student student);

    public Student findById(int id);

    public List<Student> findGroupId(int groupId);

    public void update(Student student);

    public void delete(Student student);

    public List<Student> getAll();

}
