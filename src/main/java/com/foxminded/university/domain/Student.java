package com.foxminded.university.domain;

public class Student extends Person {

    private Group group;
    private int groupId;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Student() {
    };

    public Student(String firstName, String surname, int age) {
        super(firstName, surname, age);
    }

    public Student(String firstName, String surname, int age, int groupId) {
        super(firstName, surname, age);
        this.groupId = groupId;
    }

    public Student(int id, String firstName, String surname, int age, int groupId) {
        super(id, firstName, surname, age);
        this.groupId = groupId;
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
        return "Student [" + super.toString() + " " + group + groupId + "]";
    }

}
