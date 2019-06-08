package com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.foxminded.university.domain.Lesson;

public class LessonDao implements GenericDao<Lesson> {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public Lesson create(Lesson lesson) throws DaoException {
        String sql = "insert into lessons (startTime,endTime) values(?,?)";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setObject(1, lesson.getStartTime());
            statement.setObject(1, lesson.getEndTime());
            ResultSet generatedKey = statement.getGeneratedKeys();
            statement.execute();
            if (generatedKey.next()) {
                lesson.setId(generatedKey.getInt(1));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot create lesson", e);
        }
        return lesson;
    }

    @Override
    public Lesson findById(int id) throws DaoException {
        String sql = "select * from lessons where id=?";
        Lesson lesson = null;
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lesson = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find lesson by id", e);
        }
        return lesson;
    }

    public Lesson findByStartTime(LocalDateTime startTime) throws DaoException {
        Lesson lesson = null;
        String sql = "select * from lessons where startTime=?";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, startTime);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lesson = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find lesson by starttime", e);
        }
        return lesson;
    }

    public Lesson findByEndTime(LocalDateTime endTime) throws DaoException {
        Lesson lesson = null;
        String sql = "select * from lessons where endTime=?";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, endTime);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lesson = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot find lesson by endtime", e);
        }
        return lesson;
    }

    @Override
    public Lesson update(Lesson lesson) throws DaoException {
        String sql = "update lessons set startTime=?, endTime=? where id=?";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, lesson.getStartTime());
            statement.setObject(2, lesson.getEndTime());
            statement.setInt(3, lesson.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException("Updating lessons failed, no rows affected");
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot update lesson", e);
        }
        return lesson;
    }

    @Override
    public void delete(Lesson lesson) throws DaoException {
        String sql = "delete from lessons where id=?";
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, lesson.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Cannot delete lesson", e);
        }
    }

    @Override
    public List<Lesson> getAll() throws DaoException {
        String sql = "select * from lessons order by id";
        List<Lesson> lessons = new ArrayList<>();
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                lessons.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot retrieve list of all lessons", e);
        }
        return lessons;
    }

    private Lesson map(ResultSet resultSet) throws SQLException {
        Lesson lesson = new Lesson();
        lesson.setId(resultSet.getInt("id"));
        lesson.setStartTime(resultSet.getObject("startTime", LocalDateTime.class));
        lesson.setEndTime(resultSet.getObject("endTime", LocalDateTime.class));
        return lesson;
    }

}
