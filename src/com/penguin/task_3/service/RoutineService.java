package com.penguin.task_3.service;

import com.penguin.task_3.model.Period;
import com.penguin.task_3.repository.RoutineRepository;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


public class RoutineService {

    //Dependencies
    private final RoutineRepository routineRepository;
    private final Validator validator;
    private final InputTaker inputTaker;

    //Constructor
    public RoutineService(
            RoutineRepository routineRepository,
            Validator validator,
            InputTaker inputTaker) {

        this.validator = validator;
        this.inputTaker = inputTaker;
        this.routineRepository = routineRepository;
    }

    //Methods
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
        AtomicInteger teacherID = new AtomicInteger(1);


        System.out.println("\nChoose a course from here : ");
        routineRepository.getCourses().forEach(course -> {
            System.out.println(teacherID+" "+course.getCourseName());
            teacherID.getAndIncrement();
        });


        dayIndex = inputTaker.getDayIndexFromConsole();
        //1st if
        if(validator.isDayValid(dayIndex)){
            hourIndex = inputTaker.getHourIndexFromConsole();
            //2nd if
            if(validator.isHourValid(hourIndex)){
                courseIndex = inputTaker.getCourseIndexFromConsole();
                //3rd if
                if(validator.isCourseValid(courseIndex)){
                    Period period = new Period(dayIndex,hourIndex,courseIndex);
                    routineRepository.setRoutine(period);
                    return true;
                }//End of 3rd if
                //3rd else
                else {
                    return false;
                }//End of 3rd else
            }//End of 2nd if
            //2nd else
            else {
                return false;
            }//End of 2nd else
        }//End of 1st if
        //1st else
        else {
            return false;
        }//End of 1st else

    }//End of build routine

    public void printRoutine(){
        System.out.println("\nROUTINE");
        System.out.println("------------------------------------");
        System.out.println("| Day | Hour |    Course Name      |");
        System.out.println("------------------------------------");

        Arrays.stream(routineRepository.getRoutine().getDays()).forEach(day ->
                Arrays.stream(day.getPeriods()).filter(
                        Objects::nonNull).forEach(period ->{

                            //Count spaces needed after a course name
                            int space = (20 - routineRepository.getCourses()
                                    .get(period.getCourseIndex()-1)
                                    .getCourseName()
                                    .length());

                            //Print a period information
                            System.out.println("|  " +
                                    period.getDayIndex() + "  |  " +
                                    period.getHourIndex() + "   | " +
                                    routineRepository.getCourses()
                                            .get( period.getCourseIndex()-1 )
                                            .getCourseName() +
                                    " ".repeat(space) + "|"
                            );

                            //Find end of a day in the routine
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
    }//End of print routine
}//End of class
