package com.penguin.task_3.repository;

import com.penguin.task_3.model.Course;
import com.penguin.task_3.model.Period;
import com.penguin.task_3.model.Routine;
import java.util.ArrayList;
import java.util.List;

public class RoutineRepository {

    //Fields
    private Routine routine;
    private final List<Course> courses = new ArrayList<Course>(
            List.of(
                    new Course("English Grammar","John Smith"),
                    new Course("Mathematics","Lara Gilbert"),
                    new Course("Physics","Johanna Kabir"),
                    new Course("Chemistry","Danniel Robertson"),
                    new Course("Biology","Larry Cooper")
            )
    );

    //Constructor
    public RoutineRepository() {
        this.routine = new Routine();
    }

    //Methods
    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Period period){
        routine.getDays()[period.getDayIndex()].setPeriod(period.getHourIndex(),period);
    }

    public List<Course> getCourses() {
        return courses;
    }

}//class end
