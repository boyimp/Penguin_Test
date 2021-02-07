package com.penguin.task_3.model;

import java.util.Arrays;

public class Routine {

    //Fields
    private final Day[] days;
    private final int maxDayInAWeek = 5;
    private final int maxPeriodInADay = 4;

    //Constructor
    public Routine() {
        days = new Day[maxDayInAWeek];
        for(int index = 0; index < maxDayInAWeek; index++){
                days[index] = new Day(maxPeriodInADay);
        }
    }

    //Methods

    public Day[] getDays() {
        return days;
    }

    public int getMaxDayInAWeek() {
        return maxDayInAWeek;
    }

    public int getMaxPeriodInADay() {
        return maxPeriodInADay;
    }

}//End of class
