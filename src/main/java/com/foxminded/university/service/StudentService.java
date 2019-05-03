package com.foxminded.university.service;

import java.util.List;

import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.domain.Student;

public class StudentService {
    private StudentDao studentDao;

    public Student create(Student student) {
        studentDao = new StudentDao();
        return studentDao.create(student);
    }

    public Student findById(int id) {
        studentDao = new StudentDao();
        return studentDao.findById(id);
    }

    public List<Student> findBySurname(String surname) {
        studentDao = new StudentDao();
        return studentDao.findBySurname(surname);
    }

    public Student update(Student student) {
        studentDao = new StudentDao();
        return studentDao.update(student);
    }

    public void delete(Student student) {
        studentDao = new StudentDao();
        studentDao.delete(student);
    }

    public List<Student> getAll() {
        studentDao = new StudentDao();
        return studentDao.getAll();
    }

}
