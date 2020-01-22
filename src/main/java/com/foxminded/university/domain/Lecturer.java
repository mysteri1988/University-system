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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Lecturer)) {
            return false;
        }
        Lecturer other = (Lecturer) obj;
        if (subject == null) {
            if (other.subject != null) {
                return false;
            }
        } else if (!subject.equals(other.subject)) {
            return false;
        }
        return true;
    }

}
