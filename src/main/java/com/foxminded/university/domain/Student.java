package com.foxminded.university.domain;

public class Student extends Person {

    private Group group;

    public Student() {
    };

    public Student(String firstName, String surname, int age) {
        super(firstName, surname, age);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        if (group == null) {
            throw new IllegalArgumentException("Invalid parameter of group - null");
        }

        this.group = group;
    }

    @Override
    public String toString() {
        return "Student [" + super.toString() + " " + group + "]";
    }

}
