package com.foxminded.university.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(student);
    }

    @Override
    public Student findById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Student.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> findGroupId(int groupId) {
        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "From Student student where student.group.id=:group_id";
        Query query = currentSession.createQuery(sql);
        query.setParameter("group_id", groupId);
        return query.getResultList();
    }

    @Override
    public void update(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(student);
    }

    @Override
    public void delete(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student currentStudent = currentSession.get(Student.class, student.getId());
        currentSession.delete(currentStudent);
    }

    @Override
    public List<Student> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Student order by id", Student.class).getResultList();

    }

}
