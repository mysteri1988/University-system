package com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.foxminded.university.domain.ClassRoom;

public class ClassRoomDao implements GenericDao<ClassRoom> {

    private final static Logger log = LogManager.getLogger(ClassRoomDao.class);

    @Override
    public ClassRoom create(ClassRoom classroom) throws DaoException {
        log.trace("Start creating classroom object");
        String sql = "insert into classrooms (buildingNumber,roomNumber) values(?,?)";
        log.trace("Create connection and statement");
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, classroom.getBuildingNumber());
            log.trace("Create resultSet");
            ResultSet generatedKey = statement.getGeneratedKeys();
            statement.execute();
            if (generatedKey.next()) {
                classroom.setId(generatedKey.getInt(1));
                log.info("Created new {1}", classroom);
            }
        } catch (SQLException e) {
            log.error("An exception occured in process of creating new {1}", classroom, e);
            throw new DaoException("Cannot create classroom", e);
        }
        log.trace("Exit from the method of creating new classroom");
        return classroom;
    }

    @Override
    public ClassRoom findById(int id) throws DaoException {
        log.trace("Start finding classroom by id {1}", id);
        String sql = "select * from classrooms where id=?";
        ClassRoom classroom = null;
        log.trace("Create connection and statement");
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            log.trace("Create resultSet");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                classroom = map(resultSet);
                log.debug("{1} was found", classroom);
            }
        } catch (SQLException e) {
            log.error("An exception occured in process of finding {1} by id", classroom, e);
            throw new DaoException("Cannot find classroom", e);
        }
        log.trace("Exit from the method of finding classroom by id");
        return classroom;
    }

    @Override
    public ClassRoom update(ClassRoom classroom) throws DaoException {
        log.trace("Start updating classroom object with id {1}", classroom.getId());
        String sql = "update classrooms set buildingNumber=?, roomNumber=? where id=?";
        log.trace("Create connection and statement");
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, classroom.getBuildingNumber());
            statement.setInt(2, classroom.getRoomNumber());
            statement.setInt(3, classroom.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.error("The {1} didn't  updated", classroom);
                throw new DaoException("Updating classroom failed, no rows affected");
            }
            log.debug("{1} was updated", classroom);
        } catch (SQLException e) {
            log.error("An exception occured in process of updating {1}", classroom, e);
            throw new DaoException("Cannot update classroom", e);
        }
        log.trace("Exit from the method of updating classroom");
        return classroom;
    }

    @Override
    public void delete(ClassRoom classroom) throws DaoException {
        log.trace("Start deleting classroom with id {1}", classroom.getId());
        String sql = "delete from classrooms where id=?";
        log.trace("Create connecton and statement");
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, classroom.getId());
            statement.executeUpdate();
            log.info("{1} was deleted", classroom);
        } catch (SQLException e) {
            log.error("An exception occured in process of deleting {1}", classroom, e);
            throw new DaoException("Cannot delete classroom", e);
        }
    }

    @Override
    public List<ClassRoom> getAll() throws DaoException {
        log.trace("Start creating list with all classrooms");
        String sql = "select * from classrooms order by id";
        log.trace("Create list for classrooms");
        List<ClassRoom> classrooms = new ArrayList<>();
        log.trace("Create connection, statement and resultset");
        try (Connection connection = DaoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                classrooms.add(map(resultSet));
                log.debug("The list with all classrooms was created");
            }
        } catch (SQLException e) {
            log.error("An exception occured in process of list of all classrooms", e);
            throw new DaoException("Cannot retrieve list of all classrooms", e);
        }
        log.trace("Exit from the method of retriving list of all classrooms");
        return classrooms;
    }

    private ClassRoom map(ResultSet resultSet) throws SQLException {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(resultSet.getInt("id"));
        classRoom.setBuildingNumber(resultSet.getInt("buildingNumber"));
        classRoom.setRoomNumber(resultSet.getInt("roomNumber"));
        return classRoom;
    }

}
