package com.foxminded.university.domain;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

public class UniversityTest {

    Student student = new Student("Sasha", "Petrov", 20);
    Student student1 = new Student("Roman", "Pritula", 21);
    Subject subject = new Subject("Physics");
    Subject subject1 = new Subject("Mathematical");
    Lecturer lecturer = new Lecturer("Andrey", "Ivanov", 30, subject);
    Lecturer lecturer1 = new Lecturer("Roman", "Ivanov", 29, subject1);
    Group group = new Group("TEP");
    Group group1 = new Group("MAP");
    Faculty faculty = new Faculty("Mathematical faculty");
    Faculty faculty1 = new Faculty("Physical faculty");
    Lesson lesson = new Lesson();
    Lesson lesson1 = new Lesson();
    Schedule schedule = new Schedule();
    ClassRoom class1 = new ClassRoom(1, 1);
    ClassRoom class2 = new ClassRoom(2, 2);

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfGroupStillNotCreated() throws IllegalArgumentException {
        student.setGroup(null);
        faculty.setGroups(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfLectureStillNotCreated() throws IllegalArgumentException {
        lecturer.setLecture(null);
        faculty.setSubjects(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfStudentStillNotCreated() throws IllegalArgumentException {
        group.addStudent(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfLecturerStillNotCreated() throws IllegalArgumentException {
        lecturer.setLecture(null);
        faculty.setLecturesStaff(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfCabinetStillNotCreated() throws IllegalArgumentException {
        lesson.setClassRoom(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfLessonStillNotCreated() throws IllegalArgumentException {
        schedule.addLesson(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfListOfLessonEqualNull() throws IllegalArgumentException {
        schedule.setLessons(null);
        schedule.removeLesson(lesson);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfListOfGroupsIsEqualNull() throws IllegalArgumentException {
        faculty.setGroups(null);
        faculty.removeGroup(group);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfListOfLectureresIsEqualNull() throws IllegalArgumentException {
        faculty.setLecturesStaff(null);
        faculty.removeLecturer(lecturer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfListOfSubjectsIsEqualNull() throws IllegalArgumentException {
        faculty.setSubjects(null);
        faculty.removeSubject(subject);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfStudentsIsEqualNull() throws IllegalArgumentException {
        group.setStudents(null);
        group.removeStudents(student);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfListOfLectureresOfSubjectIsEqualNull()
            throws IllegalArgumentException {
        subject.setLectureres(null);
        subject.removeLecturer(lecturer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfsettingLecturerCanNotTeachSubject()
            throws IllegalArgumentException {
        subject.setId(1);
        subject1.setId(2);
        lesson.setSubject(subject);
        lesson.setLecturer(lecturer1);
        System.out.println(lesson.getLecturer());
    }

    @Test
    public void ShouldreturnDayScheduleForLecturer() {
        class1.setRoomNumber(5);
        lesson.setClassRoom(class1);
        lesson.setSubject(subject);
        lesson.setLecturer(lecturer);
        lesson.setGroup(group);
        lesson.setStartTime(2010, 11, 16, 14, 00);
        lesson.setEndTime(2010, 11, 16, 15, 00);
        schedule.addLesson(lesson);

        lesson1.setClassRoom(class1);
        lesson1.setSubject(subject1);
        lesson1.setLecturer(lecturer);
        lesson1.setGroup(group);
        lesson1.setStartTime(2010, 10, 17, 15, 00);
        lesson1.setEndTime(2010, 10, 17, 16, 00);
        schedule.addLesson(lesson1);

        LocalDate date = LocalDate.of(2010, 11, 16);

        List<Lesson> lecturerDaySchedule = schedule.viewLecturerdaySchedule("Ivanov", date);
        assertTrue(lecturerDaySchedule.contains(lesson));

    }

    @Test
    public void ShouldreturnDayScheduleForGroup() {

        class1.setRoomNumber(5);
        lesson.setClassRoom(class1);
        lesson.setSubject(subject);
        lesson.setLecturer(lecturer);
        lesson.setGroup(group);
        lesson.setStartTime(2010, 10, 16, 14, 00);
        lesson.setEndTime(2010, 10, 16, 15, 00);
        schedule.addLesson(lesson);

        lesson1.setClassRoom(class1);
        lesson1.setSubject(subject1);
        lesson1.setLecturer(lecturer);
        lesson1.setGroup(group);
        lesson1.setStartTime(2010, 10, 17, 15, 00);
        lesson1.setEndTime(2010, 10, 17, 16, 00);
        schedule.addLesson(lesson1);

        LocalDate date = LocalDate.of(2010, 11, 16);

        List<Lesson> groupDaySchedule = schedule.viewGroupdaySchedule("TEP", date);
        assertTrue(groupDaySchedule.contains(lesson));
    }

    @Test
    public void ShouldreturnMonthScheduleForLecturer() {
        class1.setRoomNumber(5);
        lesson.setClassRoom(class1);
        lesson.setSubject(subject);
        lesson.setLecturer(lecturer);
        lesson.setGroup(group);
        lesson.setStartTime(2010, 10, 16, 14, 00);
        lesson.setEndTime(2010, 10, 16, 15, 00);
        schedule.addLesson(lesson);

        lesson1.setClassRoom(class1);
        lesson1.setSubject(subject1);
        lesson1.setLecturer(lecturer);
        lesson1.setGroup(group);
        lesson1.setStartTime(2010, 10, 17, 15, 00);
        lesson1.setEndTime(2010, 10, 17, 16, 00);
        schedule.addLesson(lesson1);

        LocalDate date = LocalDate.of(2010, 10, 16);

        List<Lesson> lecturerMonthSchedule = schedule.viewLecturermonthSchedule("Ivanov", date);
        assertTrue(lecturerMonthSchedule.contains(lesson));
    }

    @Test
    public void ShouldreturnMonthScheduleForGroup() {
        class1.setRoomNumber(5);
        lesson.setClassRoom(class1);
        lesson.setSubject(subject);
        lesson.setLecturer(lecturer);
        lesson.setGroup(group);
        lesson.setStartTime(2010, 10, 16, 14, 00);
        lesson.setEndTime(2010, 10, 16, 15, 00);
        schedule.addLesson(lesson);

        lesson1.setClassRoom(class1);
        lesson1.setSubject(subject1);
        lesson1.setLecturer(lecturer);
        lesson1.setGroup(group);
        lesson1.setStartTime(2010, 10, 17, 15, 00);
        lesson1.setEndTime(2010, 10, 17, 16, 00);
        schedule.addLesson(lesson1);

        LocalDate date = LocalDate.of(2010, 10, 16);

        List<Lesson> groupMonthSchedule = schedule.viewGroupMonthSchedule("TEP", date);
        assertTrue(groupMonthSchedule.contains(lesson));

    }

    @Test
    public void ShouldreturnTwoSubjectsForGroupInOneDay() {
        class1.setRoomNumber(5);
        lesson.setClassRoom(class1);
        lesson.setSubject(subject);
        lesson.setLecturer(lecturer);
        lesson.setGroup(group);
        lesson.setStartTime(2010, 10, 16, 14, 00);
        lesson.setEndTime(2010, 10, 16, 15, 00);
        schedule.addLesson(lesson);

        lesson1.setClassRoom(class1);
        lesson1.setSubject(subject1);
        lesson1.setLecturer(lecturer);
        lesson1.setGroup(group);
        lesson1.setStartTime(2010, 10, 16, 15, 00);
        lesson1.setEndTime(2010, 10, 16, 16, 00);
        schedule.addLesson(lesson1);

        LocalDate date = LocalDate.of(2010, 10, 16);

        List<Lesson> groupDaySchedule = schedule.viewGroupdaySchedule("TEP", date);
        assertTrue(groupDaySchedule.contains(lesson) && groupDaySchedule.contains(lesson1));
    }

    @Test
    public void ShouldreturnTrueIfStudentEqual() {
        student.setId(1);
        student1.setId(1);
        ;
        student1.setFirstName("Sasha");
        student1.setSurname("Petrov");
        student1.setAge(20);
        assertEquals(true, student.equals(student1));
    }

    @Test
    public void ShouldreturnFalseForDifferentStudents() {
        student.setId(1);
        student1.setId(2);
        assertFalse(student.hashCode() == student1.hashCode());
    }

    @Test
    public void ShouldreturnDescriptionClassOfStudent() {
        student.setGroup(group);
        String expected = "Student [" + "id=" + student.getId() + ", firstName=" + student.getFirstName() + ", surname="
                + student.getSurname() + ", age=" + student.getAge() + " " + group +"]";
        assertEquals(expected, student.toString());
    }

    @Test
    public void ShouldreturnTrueIGroupsEqual() {
        group.setId(1);
        group1.setId(1);
        group1.setName("TEP");
        assertTrue(group.equals(group1));
    }

    @Test
    public void ShouldreturnFalseForDifferentGroups() {
        group.setId(1);
        group1.setId(2);
        assertFalse(group.hashCode() == group1.hashCode());
    }

    @Test
    public void ShouldreturnDescriptionClassGroup() {
        String expected = "Group [id=" + group.getId() + ", name=" + group.getName() + "]";
        assertEquals(expected, group.toString());
    }

    @Test
    public void shouldReturnTrueIfLecturerEqual() {
        lecturer1.setFirstName("Andrey");
        lecturer1.setSurname("Ivanov");
        lecturer1.setAge(30);
        assertTrue(lecturer.hashCode() == lecturer1.hashCode());
    }

    @Test
    public void shouldReturnFalseForDifferentLuctureres() {
        lecturer1.setId(1);
        lecturer.setId(2);
        assertFalse(lecturer1.equals(lecturer));
    }

    @Test
    public void shouldReturnDescriptionClassLecturer() {
        String expected = "Lecturer [" + "id=" + lecturer.getId() + ", firstName=" + lecturer.getFirstName()
                + ", surname=" + lecturer.getSurname() + ", age=" + lecturer.getAge() + " " + subject + "]";
        assertEquals(expected, lecturer.toString());
    }

    @Test
    public void shouldReturnTrueIfSubjectsEqual() {
        subject1.setTitle("Physics");
        assertTrue(subject.hashCode() == subject1.hashCode());
    }

    @Test
    public void shouldReturnFalseForDifferentSubjects() {
        subject.setId(1);
        subject1.setId(2);
        subject.setTitle("Physics");
        assertFalse(subject1.equals(subject));
    }

    @Test
    public void shouldReturnDescriptionClassLecture() {
        String expected = "Subject [id=" + subject.getId() + ", title=" + subject.getTitle() + "]";
        assertEquals(expected, subject.toString());
    }

    @Test
    public void shouldReturnTrueIfClassRoomEqual() {
        class2.setRoomNumber(1);
        class1.setBuildingNumber(1);
        class2.setBuildingNumber(1);
        assertTrue(class1.hashCode() == class2.hashCode());
    }

    @Test
    public void shoulReturnFalseForDifferentClasses() {
        class1.setId(1);
        class2.setId(1);
        class1.setBuildingNumber(1);
        class2.setBuildingNumber(2);
        assertFalse(class1.equals(class2));
    }

    @Test
    public void shouldReturnDescriptionClassRooomClass() {
        String expected = "ClassRoom [id=" + class1.getId() + ", roomNumber=" + class1.getRoomNumber()
                + ", buildingNumber=" + class1.getBuildingNumber() + "]";
        assertEquals(expected, class1.toString());
    }

    @Test
    public void shouldReturnTrueIfFacultyFEqual() {
        faculty.setTitle("Bilogical");
        faculty1.setTitle("Mathematical");
        assertTrue(faculty.hashCode() == faculty1.hashCode());
    }

    @Test
    public void shoulReturnFalseForDifferentFaculties() {
        faculty1.setId(1);
        faculty.setId(2);
        assertFalse(faculty1.hashCode() == faculty.hashCode());
    }

    @Test
    public void shouldReturnDescriptionFacultyClass() {
        String expected = "Faculty [id=" + faculty1.getId() + ", title=" + faculty1.getTitle() + "]";
        assertEquals(expected, faculty1.toString());
    }

    @Test
    public void shouldReturnTrueIfLessonEqual() {

        class1.setRoomNumber(5);
        lesson.setClassRoom(class1);
        lesson.setSubject(subject);
        lesson.setLecturer(lecturer);
        lesson.setGroup(group);
        lesson.setStartTime(2010, 10, 16, 14, 00);
        lesson.setEndTime(2010, 10, 16, 15, 00);

        class1.setRoomNumber(5);
        lesson1.setClassRoom(class1);
        lesson1.setSubject(subject);
        lesson1.setLecturer(lecturer);
        lesson1.setGroup(group);
        lesson1.setStartTime(2010, 10, 16, 14, 00);
        lesson1.setEndTime(2010, 10, 16, 15, 00);
        assertTrue(lesson.hashCode() == lesson1.hashCode());
    }

    @Test
    public void shoulReturnFalseForDifferentLessons() {

        lesson.setClassRoom(class1);
        lesson.setSubject(subject);
        lesson.setGroup(group);
        lesson.setStartTime(2010, 10, 16, 14, 00);
        lesson.setEndTime(2010, 10, 16, 15, 00);

        lesson1.setClassRoom(class2);
        lesson1.setSubject(subject);
        lesson1.setGroup(group);
        lesson1.setStartTime(2010, 10, 16, 15, 00);
        lesson1.setEndTime(2010, 10, 16, 16, 00);

        assertFalse(lesson.equals(lesson1));
    }

    @Test
    public void shouldReturnDescriptionScheduleClass() {
        subject1.addLecturer(lecturer);
        lesson.setClassRoom(class1);
        lesson1.setSubject(subject1);
        lesson1.setLecturer(lecturer);
        lesson1.setGroup(group);
        lesson1.setStartTime(2010, 10, 16, 15, 00);
        lesson1.setEndTime(2010, 10, 16, 16, 00);
        schedule.addLesson(lesson1);
        String expected = "Schedule: lessons=" + "[" + lesson1.toString() + "]";
        assertEquals(expected, schedule.toString());
    }

}
