package com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foxminded.university.domain.Subject;

public class SubjectDao implements GenericDao<Subject> {


    @Override
    public Subject create(Subject subject) throws DaoException {
        String sql = "insert into subjects (Title) values(?)";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, subject.getTitle());
            ResultSet generatedKey = statement.getGeneratedKeys();
            statement.execute();
            if (generatedKey.next()) {
                subject.setId(generatedKey.getInt(1));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot create subject", e);
        }
        return subject;
    }

    @Override
    public Subject findById(int id) throws DaoException {
        Subject subject = null;
        String sql = "select * from subjects where title=?";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                subject = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find subject by id", e);
        }
        return subject;
    }

    public Subject findByTitle(String title) throws DaoException {
        Subject subject = null;
        String sql = "select * from subjects where title=?";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                subject = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Canot find subject by title", e);
        }
        return subject;
    }

    @Override
    public Subject update(Subject subject) throws DaoException {
        String sql = "update subjects set title=? where id=?";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, subject.getTitle());
            statement.setInt(2, subject.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException("Updating subject failed, no rows affected");
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot update subject", e);
        }
        return subject;
    }

    @Override
    public void delete(Subject subject) throws DaoException {
        String sql = "delete from subjects where id=?";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, subject.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public List<Subject> getAll() throws DaoException {
        String sql = "select * from subjects order by id";
        List<Subject> subjects = new ArrayList<>();
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                subjects.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot retrieve list of all subjects", e);
        }
        return subjects;
    }

    private Subject map(ResultSet resultSet) throws SQLException {
        Subject subject = new Subject();
        subject.setId(resultSet.getInt("id"));
        subject.setTitle(resultSet.getString("Title"));
        return subject;
    }

}
