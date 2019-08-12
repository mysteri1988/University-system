package com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foxminded.university.domain.Group;

public class GroupDao implements GenericDao<Group> {

    @Override
    public Group create(Group group) throws DaoException {
        String sql = "insert into groups (name) values(?)";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, group.getName());
            ResultSet generatedKey = statement.getGeneratedKeys();
            statement.execute();
            if (generatedKey.next()) {
                group.setId(generatedKey.getInt(1));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot create group", e);
        }
        return group;
    }

    @Override
    public Group findById(int id) throws DaoException {
        String sql = "select * from groups where id=?";
        Group group = null;
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                group = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find group by id", e);
        }
        return group;
    }

    public Group findByStudentId(int id) throws DaoException {
        String sql = "select * from groups join students on students.group_id = groups.id where students.id = ?";
        Group group = null;
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                group = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find group by student_id", e);
        }
        return group;

    }

    public Group findByName(String name) throws DaoException {
        Group group = null;
        String sql = "select * from groups where name=?";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                group = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find groups by name", e);
        }
        return group;
    }

    @Override
    public Group update(Group group) throws DaoException {
        String sql = "update groups set name=? where id=?";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, group.getName());
            statement.setInt(2, group.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException("Updating group failed, no rows affected");
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot update group", e);
        }
        return group;
    }

    @Override
    public void delete(Group group) throws DaoException {
        String sql = "delete from groups where id=?";
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, group.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Cannot delete group", e);
        }
    }

    public List<Group> getAll() throws DaoException {
        String sql = "select * from groups order by id";
        List<Group> groups = new ArrayList<>();
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                groups.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot retrieve list of all groups", e);
        }
        return groups;
    }

    private Group map(ResultSet resultSet) throws SQLException {
        Group group = new Group();
        group.setId(resultSet.getInt("id"));
        group.setName(resultSet.getString("name"));
        return group;
    }
}
