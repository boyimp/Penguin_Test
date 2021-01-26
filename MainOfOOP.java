package com.company.test_3;

import java.util.Scanner;

public class MainOfOOP {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        RoutineService mRoutineService = new RoutineService();

        while (true){
            System.out.println( "A. Create Routine \n" +
                    "B. Show Routine \n" +
                    "C. List Courses with Teachers name \n" +
                    "D. Exit");
            System.out.print("Enter choice : ");
            String choice = input.next();

            switch (choice){
                case "A":
                    mRoutineService.buildRoutine();
                    break;
                case "B":
                    mRoutineService.showRoutine();
                    break;
                case "C":
                    mRoutineService.showCourseDetails();
                    break;
                case "D":
                    return;
                default:
                    System.out.println("Invalid Choice!!!");
            }
        }

    }
}
