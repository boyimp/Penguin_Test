package com.penguin.task_3.main;

import com.penguin.task_3.repository.RoutineRepository;
import com.penguin.task_3.service.InputTaker;
import com.penguin.task_3.service.RoutineService;
import com.penguin.task_3.service.Validator;


//This Project is created by following MVC design pattern.
public class Main {
    public static void main(String[] args){
        System.out.println("Welcome in Penguin Routine Service @_@");


        //Dependencies
        RoutineRepository routineRepository = new RoutineRepository();
        InputTaker inputTaker = new InputTaker(routineRepository);
        Validator validator = new Validator(routineRepository);
        RoutineService routineService = new RoutineService(routineRepository, validator, inputTaker);

        //Starting point of application
        start(routineService,inputTaker);

    }//end of main

    private static void start( RoutineService routineService,InputTaker inputTaker ){
        while (true){
            //Ask user about choice
            String choice = inputTaker.getUserChoiceFromConsole();
            switch (choice){
                case "A":
                    //Build Routine
                    if(routineService.buildRoutine()){
                        System.out.println("\nAttempt successful");
                    }else{
                        System.out.println("\nAlert!\n" +
                                "Attempt unsuccessful!\n" +
                                "Invalid input!\n" +
                                "Try again...\n");
                    }
                    break;
                    //End of case A
                case "B":
                    //Print Routine
                    routineService.printRoutine();
                    System.out.println();
                    break;
                    //End of case B
                case "C":
                    //Print Courses Details
                    routineService.showCourseDetails();
                    System.out.println();
                    break;
                    //End of case C
                case "D":
                    //Exit point of application
                    return;
                    //End of case D
                default:
                    System.out.println("\nInvalid Choice!!!");
            }//End of switch
        }//End of while
    }//End of start function
}//End of class
