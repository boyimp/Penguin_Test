package com.company.test_3;

public class CourseDetails {
    private final String courseName;
    private final String teacherName;

    public CourseDetails(String courseName, String teacherName) {
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

}
