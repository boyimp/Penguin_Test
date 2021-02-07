package com.penguin.task_3.service;

import com.penguin.task_3.model.Period;
import com.penguin.task_3.repository.RoutineRepository;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


public class RoutineService {

    private final RoutineRepository routineRepository;
    private final Validator validator;
    private final InputTaker inputTaker;

    public RoutineService(
            RoutineRepository routineRepository,
            Validator validator,
            InputTaker inputTaker) {

        this.validator = validator;
        this.inputTaker = inputTaker;
        this.routineRepository = routineRepository;
    }

    public void showCourseDetails(){
        System.out.println("\nCourse Details:");
        routineRepository.getCourses().forEach(course ->
                System.out.println(
                        course.getCourseName() + ", " +
                                course.getTeacherName()));
    }//end of course details

    public boolean buildRoutine(){

        //initialization
        int dayIndex , hourIndex , courseIndex;
        AtomicInteger i = new AtomicInteger(1);


        System.out.println("\nChoose a course from here : ");
        routineRepository.getCourses().forEach(course -> {
            System.out.println(i+" "+course.getCourseName());
            i.getAndIncrement();
        });


        dayIndex = inputTaker.getDayIndexFromConsole();
        if(validator.isDayValid(dayIndex)){
            hourIndex = inputTaker.getHourIndexFromConsole();
            if(validator.isHourValid(hourIndex)){
                courseIndex = inputTaker.getCourseIndexFromConsole();
                if(validator.isCourseValid(courseIndex)){
                    Period period = new Period(dayIndex,hourIndex,courseIndex);
                    routineRepository.setRoutine(period);
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }

    }//End of build routine

    public void printRoutine(){
        System.out.println("\nRoutine");
        System.out.println("------------------------------------");
        System.out.println("| Day | Hour |    Course Name      |");
        System.out.println("------------------------------------");
        Arrays.stream(routineRepository.getRoutine().getDays()).forEach(day ->
                Arrays.stream(day.getPeriods()).filter(
                        Objects::nonNull).forEach(period ->{

                            int space = (20 - routineRepository.getCourses()
                                    .get(period.getCourseIndex()-1)
                                    .getCourseName()
                                    .length());


                            System.out.println("|  " +
                                    period.getDayIndex() + "  |  " +
                                    period.getHourIndex() + "   | " +
                                    routineRepository.getCourses()
                                            .get( period.getCourseIndex()-1 )
                                            .getCourseName() +
                                    " ".repeat(space) + "|"
                            );

                            if( ((period.getHourIndex() %
                                    (routineRepository.getRoutine()
                                            .getMaxPeriodInADay()-1) ) == 0)
                                    &&
                                    (period.getHourIndex() != 0) ){
                                System.out.println("------------------------------------");
                            }

                        }
                        ));
        System.out.println("------------------------------------");
    }
}
