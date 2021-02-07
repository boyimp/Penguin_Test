package com.penguin.task_3.main;

import com.penguin.task_3.repository.RoutineRepository;
import com.penguin.task_3.service.InputTaker;
import com.penguin.task_3.service.RoutineService;
import com.penguin.task_3.service.Validator;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome in Penguin Routine Service @_@");

        //Dependencies
        RoutineRepository routineRepository = new RoutineRepository();
        InputTaker inputTaker = new InputTaker(routineRepository);
        Validator validator = new Validator(routineRepository);
        RoutineService routineService = new RoutineService(routineRepository, validator, inputTaker);

        //App's starting point
        start(routineService,inputTaker);

    }//end of main

    private static void start( RoutineService routineService,InputTaker inputTaker ){
        while (true){
            String choice = inputTaker.getUserChoiceFromConsole();
            switch (choice){
                case "A":
                    if(routineService.buildRoutine()){
                        System.out.println("\nAttempt successful");
                    }else{
                        System.out.println("\nAlert!\n" +
                                "Attempt unsuccessful!\n" +
                                "Invalid input!\n" +
                                "Try again...");
                    }
                    System.out.println();
                    break;
                case "B":
                    routineService.printRoutine();
                    System.out.println();
                    break;
                case "C":
                    routineService.showCourseDetails();
                    System.out.println();
                    break;
                case "D":
                    return;
                default:
                    System.out.println("\nInvalid Choice!!!");
            }
        }
    }//End of start function


}//End of class
