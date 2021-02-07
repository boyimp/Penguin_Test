package com.penguin.task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Double> weightList = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        //prompt for user input
        while(true){
            System.out.print("Enter weight (-1 for exit) : ");
            double temporary = input.nextDouble();
            if(temporary == -1){
                break;
            }else{
                if(temporary <= 1.1 || temporary > 3){
                    System.out.println("Invalid input!!");
                }else{
                    weightList.add(temporary);
                }
            }
        }//prompt for user input

        //Print all weights
        System.out.print("{ ");
        for(double x : weightList){
            System.out.print(x+ ",");
        }
        System.out.println(" }");

        //find result
        int result = janitorIntelligence(weightList);
        System.out.println("Total trip needed : "+result);
    }

    public static int janitorIntelligence(List<Double> weightList){

        //Base case 1
        if(weightList.size() == 0){
            return 0;
        }
        //Base case 2
        else if(weightList.size() == 1){
            return 1;
        }
        //Other case
        else{
            //Initialization
            int trip = 0;
            double sum = 0;
            final double maximumSingleBagSize = 1.9;

            //First Loop
            for(int i = 0; i< weightList.size(); i++){
                int firstBagIndex = 0;
                int secondBagIndex = 0;

                //First if
                if(weightList.get(i) != 0){
                    firstBagIndex = i;

                    //Second if
                    if (weightList.get(i) <= maximumSingleBagSize) {

                        //Second Loop
                        for(int j = i+1; j< weightList.size(); j++){

                            //Third if
                            if(weightList.get(j) != 0){
                                double temporarySum = weightList.get(firstBagIndex) + weightList.get(j);

                                //Fourth if
                                if(temporarySum <= 3 && temporarySum > sum){
                                    secondBagIndex = j;
                                    sum = temporarySum;

                                    if(sum == 3) break;
                                }//Fourth if
                            }//Third if
                        }//Second Loop
                    }//Second if

                    //update current state
                    sum = 0.0;
                    weightList.set(firstBagIndex,0.0);
                    weightList.set(secondBagIndex,0.0);
                    trip++;
                }//First if
            }//First Loop

            return trip;
        }//Other case
    }//Janitor Intelligent function

}//Class
