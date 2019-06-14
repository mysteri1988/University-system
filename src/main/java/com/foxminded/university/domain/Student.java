package com.foxminded.university.domain;

public class Student extends Person {

    private String groupName;
    private Group group;

    

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student() {
    };

    public Student(String firstName, String surname, int age) {
        super(firstName, surname, age);
    }

    public Student(String firstName, String surname, int age, String groupName) {
        super(firstName, surname, age);
        this.groupName = groupName;
    }

    public Student(int id, String firstName, String surname, int age, String groupName) {
        super(id, firstName, surname, age);
        this.groupName = groupName;
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
        return "Student [" + super.toString() + " " + group+"]";
    }

}
