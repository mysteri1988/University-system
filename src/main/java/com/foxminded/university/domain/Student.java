package com.foxminded.university.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends Person {

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "group_id")
    private Group group;

    public Student() {
    };

    public Student(String firstName, String surname, int age) {
        super(firstName, surname, age);
    }

    public Group getGroup() {
        return group;
    }

    public Student(Group group) {
        super();
        this.group = group;
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
