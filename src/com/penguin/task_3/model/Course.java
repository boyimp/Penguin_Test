package com.penguin.task_3.model;

public class Course {

    //Fields
    private final String courseName;
    private final String teacherName;

    //Constructor
    public Course(String courseName, String teacherName) {
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

    //Methods
    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

}
