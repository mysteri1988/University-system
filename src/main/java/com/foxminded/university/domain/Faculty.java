package com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private int id;
    private String title;
    private List<Group> groups = new ArrayList<>();
    private List<Lecturer> lecturesStaff = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    
    public Faculty() {
    }

    public Faculty(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group) {
        if (group == null) {
            throw new IllegalArgumentException("Invalid parameter of group - null");
        }
        groups.add(group);
    }

    public void removeGroup(Group group) {
        if (groups == null) {
            throw new IllegalArgumentException("The groups is equal null");
        }
        groups.remove(group);
    }

    public List<Lecturer> getLecturesStaff() {
        return lecturesStaff;
    }

    public void setLecturesStaff(List<Lecturer> lecturesStaff) {
        this.lecturesStaff = lecturesStaff;
    }

    public void addLecturer(Lecturer lecturer) {
        if (lecturer == null) {
            throw new IllegalArgumentException("Invalid parameter of lecturer - null");
        }

        lecturesStaff.add(lecturer);
    }

    public void removeLecturer(Lecturer lecturer) {
        if (lecturesStaff == null) {
            throw new IllegalArgumentException("The lectureresStaff is equal null");
        }
        lecturesStaff.remove(lecturer);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Invalid parameter of lecture - null");
        }
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        if (subjects == null) {
            throw new IllegalArgumentException("The subjects is equal null");
        }
        subjects.remove(subject);
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
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
        if (!(obj instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Faculty [id=" + id + ", title=" + title + "]";
    }

}
