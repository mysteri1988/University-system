package com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foxminded.university.domain.Faculty;

public class FacultyDao implements GenericDao<Faculty> {

    @Override
    public Faculty create(Faculty faculty) throws DaoException {
        String sql = "insert into faculties (title) values(?)";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, faculty.getTitle());
            ResultSet generatedKey = statement.getGeneratedKeys();
            statement.execute();
            if (generatedKey.next()) {
                faculty.setId(generatedKey.getInt(1));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot create faculty", e);
        }
        return faculty;
    }

    @Override
    public Faculty findById(int id) throws DaoException {
        String sql = "select * from faculties where id=?";
        Faculty faculty = null;
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                faculty = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find faculty", e);
        }
        return faculty;
    }

    @Override
    public Faculty update(Faculty faculty) throws DaoException {
        String sql = "update faculties set title=? where id=?";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, faculty.getTitle());
            statement.setInt(2, faculty.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException("Updating faculty failed, no rows affected");
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot update faculty", e);
        }
        return faculty;
    }

    @Override
    public void delete(Faculty faculty) throws DaoException {
        String sql = "delete from faculties where id=?";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, faculty.getId());
        } catch (SQLException e) {
            throw new DaoException("Cannot delete faculty", e);
        }
    }

    @Override
    public List<Faculty> getAll() throws DaoException {
        String sql = "select * from faculties order by id";
        List<Faculty> faculties = new ArrayList<>();
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                faculties.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot retrieve list of all faculties", e);
        }
        return faculties;
    }

    private Faculty map(ResultSet resultSet) throws SQLException {
        Faculty faculty = new Faculty();
        faculty.setId(resultSet.getInt("id"));
        faculty.setTitle(resultSet.getString("Title"));
        return faculty;
    }

}
