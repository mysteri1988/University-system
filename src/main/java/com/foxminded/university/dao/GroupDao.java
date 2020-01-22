package com.foxminded.university.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Student;

@Repository
public class GroupDao implements GroupDaoInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Group group) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(group);
    }

    @Override
    public Group findById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Group.class, id);
    }

    @Override
    public Group findByStudentId(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student student = currentSession.get(Student.class, id);
        return student.getGroup();
    }

    @Override
    public Group findByName(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Group.class, name);
    }

    @Override
    public void update(Group group) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(group);
    }

    @Override
    public void delete(Group group) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(group);
    }

    @Override
    public List<Group> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Group order by id", Group.class).getResultList();
    }
}
