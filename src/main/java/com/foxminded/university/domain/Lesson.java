package com.foxminded.university.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lesson {

    private int id;
    private Subject subject;
    private Lecturer lecturer;
    private ClassRoom classRoom;
    private Group group;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Invalid parameter of subject - null");
        }
        this.subject = subject;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        if (lecturer == null) {
            throw new IllegalArgumentException("Invalid parameter of lecturer - null");
        }
        if (lecturer.getSubject().equals(subject)) {
            this.lecturer = lecturer;
        } else {
            throw new IllegalArgumentException("This lecturer can't teach this subject");
        }
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        if (classRoom == null) {
            throw new IllegalArgumentException("Invalid parameter of classRoom - null");
        }
        this.classRoom = classRoom;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(int year, int month, int day, int hourOfDay, int minute) {
        this.startTime = LocalDateTime.of(year, month, day, hourOfDay, minute);
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(int year, int month, int day, int hourOfDay, int minute) {
        this.endTime = LocalDateTime.of(year, month, day, hourOfDay, minute);
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
        result = prime * result + ((classRoom == null) ? 0 : classRoom.hashCode());
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result + ((group == null) ? 0 : group.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
        if (!(obj instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) obj;
        if (classRoom == null) {
            if (other.classRoom != null) {
                return false;
            }
        } else if (!classRoom.equals(other.classRoom)) {
            return false;
        }
        if (endTime == null) {
            if (other.endTime != null) {
                return false;
            }
        } else if (!endTime.equals(other.endTime)) {
            return false;
        }
        if (group == null) {
            if (other.group != null) {
                return false;
            }
        } else if (!group.equals(other.group)) {
            return false;
        }
        if (startTime == null) {
            if (other.startTime != null) {
                return false;
            }
        } else if (!startTime.equals(other.startTime)) {
            return false;
        }
        if (subject == null) {
            if (other.subject != null) {
                return false;
            }
        } else if (!subject.equals(other.subject)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm.dd.M.uuuu");
        return group + " " + subject + " [" + startTime.format(formatter) + " " + endTime.format(formatter) + "] "
                + classRoom + " " + lecturer + "\n";
    }

}
