package com.foxminded.university.domain;

public class Lecturer extends Person {

    private Subject subject;

    public Lecturer() {
    };

    public Lecturer(String firstName, String surname, int age, Subject subject) {
        super(firstName, surname, age);
        this.subject = subject;
    }

    public Subject getLecture() {
        return subject;
    }

    public void setLecture(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Invalid parameter of subject - null");
        }

        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Lecturer [" + super.toString() + " " + subject + "]";
    }
}
