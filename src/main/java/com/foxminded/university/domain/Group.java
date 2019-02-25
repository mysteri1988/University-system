package com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private int id;
    private String name;
    private List<Student> students = new ArrayList<>();

    public Group() {
    };

    public Group(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Invalid parameter of student - null");
        }
        students.add(student);
    }

    public void removeStudents(Student student) {
        if (students == null) {
            throw new IllegalArgumentException("The list of students is empty");
        }

        students.remove(student);
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
        if (!(obj instanceof Group)) {
            return false;
        }
        Group other = (Group) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Group [id=" + id + ", name=" + name + "]";
    }

}
