package com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foxminded.university.domain.Student;

public class StudentDao implements GenericDao<Student> {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public Student create(Student student) throws DaoException {
        String sql = "insert into students (firstName,surname,age) values(?,?,?)";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                student.setId(generatedKey.getInt(1));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot create student", e);
        }
        return student;
    }

    @Override
    public Student findById(int id) throws DaoException {
        String sql = "select * from students where id=?";
        Student student = null;
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find student by id", e);
        }
        return student;
    }

    public List<Student> findBySurname(String surname) throws DaoException {
        List<Student> students = new ArrayList<>();
        String sql = "select * from students where surname=?";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                students.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find students by surname", e);
        }
        return students;
    }

    public List<Student> findByGroupId(int id) throws DaoException {
        List<Student> students = new ArrayList<>();
        String sql = "select * from students " + "join groups on students.group_id = groups.id where groups.id = ?";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                students.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find students by group id", e);
        }
        return students;
    }

    @Override
    public Student update(Student student) throws DaoException {
        String sql = "update students set firstName=?,surname=?, age=? where id=?";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            statement.setInt(4, student.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException("Updating user failed, no rows affected");
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot update student", e);
        }
        return student;
    }

    @Override
    public void delete(Student student) throws DaoException {
        String sql = "delete from students where id=?";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Cannot delete student", e);
        }
    }

    @Override
    public List<Student> getAll() throws DaoException {
        String sql = "select * from students order by id";
        List<Student> students = new ArrayList<>();
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                students.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot retrieve list of all students", e);
        }
        return students;
    }

    private Student map(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setFirstName(resultSet.getString("firstName"));
        student.setSurname(resultSet.getString("surname"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }

}
