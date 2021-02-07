package com.penguin.task_3.model;

public class Period {
    private int dayIndex;
    private int hourIndex;
    private int courseIndex;

    public Period(int dayIndex, int hourIndex, int courseIndex) {
        this.dayIndex = dayIndex;
        this.hourIndex = hourIndex;
        this.courseIndex = courseIndex;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public int getHourIndex() {
        return hourIndex;
    }

    public int getCourseIndex() {
        return courseIndex;
    }

}//End of class
