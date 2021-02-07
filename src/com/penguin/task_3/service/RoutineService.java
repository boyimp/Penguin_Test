package com.penguin.task_3.service;

import com.penguin.task_3.model.Course;
import com.penguin.task_3.model.Period;
import com.penguin.task_3.model.Routine;
import com.penguin.task_3.repository.RoutineRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


public class RoutineService {

    private RoutineRepository routineRepository;
    private List<Course> courses;
    private Routine routine;
    private Validator validator;
    private InputTaker inputTaker;

    public RoutineService(
            RoutineRepository routineRepository,
            Validator validator,
            InputTaker inputTaker) {

        this.routineRepository = routineRepository;
        this.validator = validator;
        this.inputTaker = inputTaker;
        this.courses = routineRepository.getCourses();
        this. routine = routineRepository.getRoutine();

    }

    public void showCourseDetails(){
        courses.forEach(course ->
                System.out.println(
                        course.getCourseName() + ", " +
                                course.getTeacherName()));
    }//end of course details

    public boolean buildRoutine(){

        //initialization
        int dayIndex , hourIndex , courseIndex;
        AtomicInteger i = new AtomicInteger(1);

        courses.forEach(course -> {
                    System.out.println(i+" "+course.getCourseName());
                    i.getAndIncrement();
                        });

        dayIndex = inputTaker.getDayIndexFromConsole();
        hourIndex = inputTaker.getHourIndexFromConsole();
        courseIndex = inputTaker.getCourseIndexFromConsole();

        if(validator.isDayValid(dayIndex) &&
                validator.isHourValid(hourIndex) &&
                validator.isCourseValid(courseIndex)){

            Period period = new Period(dayIndex,hourIndex,courseIndex);
            routine.setPeriod(period);

            return true;
        }else{
            return false;
        }
    }//End of build routine

    public void printRoutine(){

        Arrays.stream(routine.getDays()).forEach(day ->
                Arrays.stream(day.getPeriods()).filter(
                        Objects::nonNull).forEach(period ->
                        System.out.println(
                                        period.getDayIndex() + "," +
                                                period.getHourIndex() + "," +
                                                courses.get(period.getCourseIndex()).getCourseName()
                                )));
    }
}
