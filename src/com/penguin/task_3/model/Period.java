package com.penguin.task_3.model;

public class Period {

    //Fields
    private final int dayIndex;
    private final int hourIndex;
    private final int courseIndex;

    //Constructor
    public Period(int dayIndex, int hourIndex, int courseIndex) {
        this.dayIndex = dayIndex;
        this.hourIndex = hourIndex;
        this.courseIndex = courseIndex;
    }

    //Methods
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
