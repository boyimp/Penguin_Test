package com.penguin.task_3.repository;

import com.penguin.task_3.model.Course;
import com.penguin.task_3.model.Routine;
import java.util.ArrayList;
import java.util.List;

public class RoutineRepository {

    static int count = 0;
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

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public List<Course> getCourses() {
        return courses;
    }

}//class end
