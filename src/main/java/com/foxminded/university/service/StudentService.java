package com.foxminded.university.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.domain.Student;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public void create(Student student) {
        studentDao.create(student);
    }

    @Override
    @Transactional
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    @Transactional
    public List<Student> findByGroupId(int groupId) {
        return studentDao.findGroupId(groupId);
    }

    @Override
    @Transactional
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        studentDao.delete(student);
    }

    @Override
    @Transactional
    public List<Student> getAll() {
        return studentDao.getAll();
    }
}
