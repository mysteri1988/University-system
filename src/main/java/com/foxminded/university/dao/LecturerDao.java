package com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foxminded.university.domain.Lecturer;

public class LecturerDao implements GenericDao<Lecturer> {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public Lecturer create(Lecturer lecturer) throws DaoException {
        String sql = "insert into lectureres (firstName,surname,age) values(?,?,?)";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, lecturer.getFirstName());
            statement.setString(2, lecturer.getSurname());
            statement.setInt(3, lecturer.getAge());
            ResultSet generatedKey = statement.getGeneratedKeys();
            statement.execute();
            if (generatedKey.next()) {
                lecturer.setId(generatedKey.getInt(1));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot create lecturer", e);
        }
        return lecturer;
    }

    @Override
    public Lecturer findById(int id) throws DaoException {
        String sql = "select * from lectureres where id=?";
        Lecturer lecturer = null;
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lecturer = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find lecturer by id", e);
        }
        return lecturer;
    }

    public List<Lecturer> findBySurname(String surname) throws DaoException {
        List<Lecturer> lectureres = new ArrayList<>();
        String sql = "select * from lectureres where surname=?";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lectureres.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find lecturer by surname", e);
        }
        return lectureres;
    }

    @Override
    public Lecturer update(Lecturer lecturer) throws DaoException {
        String sql = "update lectureres set firstName=?,surname=?, age=? where id=?";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lecturer.getFirstName());
            statement.setString(2, lecturer.getSurname());
            statement.setInt(3, lecturer.getAge());
            statement.setInt(4, lecturer.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException("Updating lecturer failed, no rows affected");
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot update lecturer", e);
        }
        return lecturer;
    }

    @Override
    public void delete(Lecturer lecturer) throws DaoException {
        String sql = "delete from lectureres where id=?";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, lecturer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Cannot delete lecturer", e);
        }
    }

    @Override
    public List<Lecturer> getAll() throws DaoException {
        String sql = "select * from lectureres order by id";
        List<Lecturer> lectureres = new ArrayList<>();
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                lectureres.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot retrieve list of all lectureres", e);
        }
        return lectureres;
    }

    private Lecturer map(ResultSet resultSet) throws SQLException {
        Lecturer lecturer = new Lecturer();
        lecturer.setId(resultSet.getInt("id"));
        lecturer.setFirstName(resultSet.getString("firstName"));
        lecturer.setSurname(resultSet.getString("surname"));
        lecturer.setId(resultSet.getInt("age"));
        return lecturer;
    }

}
