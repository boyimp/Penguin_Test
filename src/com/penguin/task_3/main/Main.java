package com.penguin.task_3.main;

import com.penguin.task_3.repository.RoutineRepository;
import com.penguin.task_3.service.InputTaker;
import com.penguin.task_3.service.RoutineService;
import com.penguin.task_3.service.Validator;

public class Main {
    public static void main(String[] args){

        //Dependencies
        RoutineRepository routineRepository = new RoutineRepository();
        InputTaker inputTaker = new InputTaker(routineRepository);
        Validator validator = new Validator(routineRepository);
        RoutineService routineService = new RoutineService(routineRepository, validator, inputTaker);

        //App's starting point
        controller(routineService,inputTaker);

    }//end of main

    static void controller(RoutineService routineService,InputTaker inputTaker){
        while (true){
            String choice = inputTaker.getUserChoiceFromConsole();
            switch (choice){
                case "A":
                    routineService.buildRoutine();
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
                    System.out.println("Invalid Choice!!!");
            }
        }

    }
}
