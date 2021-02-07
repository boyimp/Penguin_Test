package com.penguin.task_3.service;

import com.penguin.task_3.model.Routine;
import com.penguin.task_3.repository.RoutineRepository;
import java.util.Scanner;

public class InputTaker {

    //Fields
    private final Scanner input = new Scanner(System.in);
    Routine routine ;

    //Constructor
    public InputTaker(RoutineRepository routineRepository) {
        this.routine = routineRepository.getRoutine();
    }

    //Methods
    public int getDayIndexFromConsole(){
        System.out.println();
        System.out.print("Enter day index(0-"+ (routine.getMaxDayInAWeek()-1) + ") : ");
        return input.nextInt();
    }

    public int getHourIndexFromConsole(){
        System.out.print("Enter hour index(0-"+ (routine.getMaxPeriodInADay()-1) + ") : ");
        return input.nextInt();
    }

    public int getCourseIndexFromConsole(){
        System.out.print("Enter course index : ");
        return input.nextInt();
    }

    public String getUserChoiceFromConsole(){
        System.out.println();
        System.out.println( "Menu :\n" +
                "A. Create Routine \n" +
                "B. Show Routine \n" +
                "C. List Courses with Teachers name \n" +
                "D. Exit");
        System.out.print("Enter choice : ");
        return input.next();
    }

}//End of class
