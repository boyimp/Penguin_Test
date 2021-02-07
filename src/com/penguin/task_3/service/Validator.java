package com.penguin.task_3.service;

import com.penguin.task_3.repository.RoutineRepository;


public class Validator {

    private RoutineRepository routineRepository ;

    public Validator(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }

    boolean isDayValid(int dayIndex){
        return ( dayIndex >= 0 ) && ( dayIndex < routineRepository.getRoutine().getMaxDayInAWeek() );
    }

    boolean isHourValid(int hourIndex){
        return (hourIndex >= 0 ) && ( hourIndex < routineRepository.getRoutine().getMaxPeriodInADay() );
    }

    boolean isCourseValid(int courseIndex){
        return ( courseIndex >= 1 ) && ( courseIndex <= routineRepository.getCourses().size() );
    }

}//End of class
