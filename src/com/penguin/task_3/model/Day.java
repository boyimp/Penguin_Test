package com.penguin.task_3.model;


public class Day {
    private final Period[] periods;

    public Day(int maxPeriod) {
        this.periods = new Period[maxPeriod];
    }

    public Period[] getPeriods() {
        return periods;
    }

    public void setPeriod(int hourIndex,Period period){
        periods[hourIndex] = period;
    }
}
