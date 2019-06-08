package com.foxminded.university.service;

import java.util.List;

import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.domain.Student;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public Student create(Student student) {
        return studentDao.create(student);
    }

    public Student findById(int id) {
        return studentDao.findById(id);
    }

    public List<Student> findBySurname(String surname) {
        return studentDao.findBySurname(surname);
    }

    public List<Student> findByGroupId(int id) {
        return studentDao.findByGroupId(id);
    }

    public Student update(Student student) {
        return studentDao.update(student);
    }

    public void delete(Student student) {
        studentDao.delete(student);
    }

    public List<Student> getAll() {
        return studentDao.getAll();
    }

}
