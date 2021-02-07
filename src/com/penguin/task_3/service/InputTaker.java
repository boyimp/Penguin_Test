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
        System.out.print("\nEnter day index(0-"+ (routine.getMaxDayInAWeek()-1) + ") : ");

        String temporary =  null;
        try{
            temporary = input.next();
            Integer.parseInt(temporary);
        }catch (NumberFormatException e){
            e.getCause();
            System.out.println(temporary + " is an invalid input!");
            return -1;
        }

        return Integer.parseInt(temporary);
    }

    public int getHourIndexFromConsole(){
        System.out.print("Enter hour index(0-"+ (routine.getMaxPeriodInADay()-1) + ") : ");

        String temporary =  null;
        try{
             temporary = input.next();
             Integer.parseInt(temporary);
        }catch (NumberFormatException e){
            e.getCause();
            System.out.println(temporary + " is an invalid input!");
            return -1;
        }

        return Integer.parseInt(temporary);
    }

    public int getCourseIndexFromConsole(){
        System.out.print("Enter course index : ");

        String temporary =  null;
        try{
            temporary = input.next();
            Integer.parseInt(temporary);
        }catch (NumberFormatException e){
            e.getCause();
            System.out.println(temporary + " is an invalid input!");
            return -1;
        }

        return Integer.parseInt(temporary);
    }

    public String getUserChoiceFromConsole(){

        System.out.println( "\nMenu :\n" +
                "A. Create Routine \n" +
                "B. Show Routine \n" +
                "C. List Courses with Teachers name \n" +
                "D. Exit");
        System.out.print("Enter choice : ");
        return input.next();
    }

}//End of class
