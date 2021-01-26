package com.company.test_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RoutineService {
    private final List<CourseDetails> allCourseDetails = new ArrayList<CourseDetails>();
    private int[][] routine = new int[5][4];

    public RoutineService() {
        allCourseDetails.add(new CourseDetails("English Grammar","John Smith"));
        allCourseDetails.add(new CourseDetails("Mathematics","Lara Gilbert"));
        allCourseDetails.add(new CourseDetails("Physics","Johanna Kabir"));
        allCourseDetails.add(new CourseDetails("Chemistry","Danniel Robertson"));
        allCourseDetails.add(new CourseDetails("Biology","Larry Cooper"));
    }

    public void showCourseDetails(){
        for (CourseDetails courseDetails : allCourseDetails) {
            System.out.println(courseDetails.getCourseName() + ", " + courseDetails.getTeacherName()
            );
        }
    }

    public void buildRoutine(){
        Scanner input = new Scanner(System.in);
        int i =1;
        for (CourseDetails courseDetails : allCourseDetails) {
            System.out.println(i+" "+courseDetails.getCourseName());
            i++;
        }

        System.out.print("Enter dayIndex(0-4) : ");
        int dayIndex = input.nextInt();

        System.out.print("Enter hourIndex(0-3) : ");
        int hourIndex = input.nextInt();

        System.out.print("Enter courseIndex : ");
        int courseIndex = input.nextInt();

        if(dayIndex <= 4 && dayIndex >=0  &&
                hourIndex <= 3 && hourIndex >=0 &&
                courseIndex <=allCourseDetails.size() && courseIndex >=1){

            routine[dayIndex][hourIndex] = courseIndex;
            System.out.println("Successful!!!");
        }
        else{
            System.out.println("Unsuccessful Invalid input!!!");
        }
    }

    public void showRoutine(){
        for(int row = 0; row <= 4; row++){
            for(int column = 0 ; column <= 3; column++){
                if(routine[row][column] != 0){
                    int courseIndex = routine[row][column] - 1;
                    System.out.println(row+" "+column+" "+allCourseDetails.get(courseIndex).getCourseName());
                }
                else {
                    System.out.println(row+" "+column+" "+routine[row][column]);
                }

            }
        }
    }
}
