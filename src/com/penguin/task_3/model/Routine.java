package com.penguin.task_3.model;

public class Routine {

    //Dependency
    private final Day[] days;

    //Fields
    private final int maxDayInAWeek = 5;
    private final int maxPeriodInADay = 4;

    //Constructor
    public Routine() {

        //initialization of Day object
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
