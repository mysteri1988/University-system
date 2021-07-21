package com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private int id;
    private String title;
    private List<Lecturer> lectureres = new ArrayList<>();

    public Subject() {
    };

    public Subject(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Lecturer> getLectureres() {
        return lectureres;
    }

    public void setLectureres(List<Lecturer> lectureres) {
        this.lectureres = lectureres;
    }

    public void addLecturer(Lecturer lecturer) {
        if (lecturer == null) {
            throw new IllegalArgumentException("Invalid parameter of lecturer - null");
        }

        lectureres.add(lecturer);
    }

    public void removeLecturer(Lecturer lecturer) {
        if (lectureres == null) {
            throw new IllegalArgumentException("The list of lecturers is null");
        }
        lectureres.remove(lecturer);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Subject [id=" + id + ", title=" + title + "]";
    }

}
