package com.penguin.task_3.model;


public class Day {

    //Dependency
    private final Period[] periods;

    //Constructor
    public Day(int maxPeriod) {

        //initialization of Period object
        this.periods = new Period[maxPeriod];
    }

    //Methods
    public Period[] getPeriods() {
        return periods;
    }

    public void setPeriod(int hourIndex,Period period){
        periods[hourIndex] = period;
    }
}
