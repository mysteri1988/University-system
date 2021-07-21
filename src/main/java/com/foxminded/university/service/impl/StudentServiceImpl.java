package com.foxminded.university.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.dao.impl.StudentDaoImpl;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void create(Student student) {
        studentDao.create(student);
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findByGroupId(int groupId) {
        return studentDao.findGroupId(groupId);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        studentDao.delete(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
