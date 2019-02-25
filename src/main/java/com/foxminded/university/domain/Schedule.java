package com.foxminded.university.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<Lesson> lessons = new ArrayList<>();

    public List<Lesson> viewLecturerdaySchedule(String surname, LocalDate date) {
        List<Lesson> studentDayShedule = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getLecturer().getSurname().equals(surname)
                    && lesson.getStartTime().getDayOfMonth() == date.getDayOfMonth()) {
                studentDayShedule.add(lesson);
            }
        }
        return studentDayShedule;
    };

    public List<Lesson> viewGroupdaySchedule(String name, LocalDate date) {
        List<Lesson> groupDayShedule = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getGroup().getName().equals(name)
                    && lesson.getStartTime().getDayOfMonth() == date.getDayOfMonth()) {
                groupDayShedule.add(lesson);
            }
        }
        return groupDayShedule;
    };

    public List<Lesson> viewLecturermonthSchedule(String surname, LocalDate date) {
        List<Lesson> monthShedule = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getLecturer().getSurname().equals(surname)
                    && lesson.getStartTime().getMonthValue() == date.getMonthValue()) {
                monthShedule.add(lesson);
            }
        }
        return monthShedule;
    };

    public List<Lesson> viewGroupMonthSchedule(String name, LocalDate date) {
        List<Lesson> monthShedule = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getGroup().getName().equals(name)
                    && lesson.getStartTime().getMonthValue() == date.getMonthValue()) {
                monthShedule.add(lesson);
            }
        }
        return monthShedule;
    };

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson) {
        if (lesson == null) {
            throw new IllegalArgumentException("Invalid parameter of lesson - null");
        }
        lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        if (lessons == null) {
            throw new IllegalArgumentException("The lessons is null");
        }
        lessons.remove(lesson);
    }

    @Override
    public String toString() {
        return "Schedule: lessons=" + lessons.toString();
    }

}
