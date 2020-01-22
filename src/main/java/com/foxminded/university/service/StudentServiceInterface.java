package com.foxminded.university.service;

import java.util.List;

import com.foxminded.university.domain.Student;

public interface StudentServiceInterface {

    public void create(Student student);

    public Student findById(int id);

    public List<Student> findByGroupId(int groupId);

    public void update(Student student);

    public void delete(Student student);

    public List<Student> getAll();
}
