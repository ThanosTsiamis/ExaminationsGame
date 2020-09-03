package com.company;

import com.company.entitities.Column;
import com.company.entitities.Student;
import com.company.entitities.Supervisor;
import com.company.entitities.Walkway;
import com.company.enums.CourseDifficulty;
import com.company.enums.ProfessorsAttitude;

public class Main {
    public static Enum<CourseDifficulty> courseDifficulty = CourseDifficulty.MEDIUM;
    Enum<ProfessorsAttitude> professorsAttitudeEnum = ProfessorsAttitude.RELAXED;

    public static void main(String[] args) {
        //populate the Room
        Object[][] room = new Object[50][13];
        populate(room);
        //the supervisors come to the room
        int numberOfSupervisors = courseDifficulty.ordinal()+1;
        for(int number=0;number<numberOfSupervisors;number++){
            Supervisor supervisor = new Supervisor();
            //TODO add x and y to the supervisors

        }
        System.out.println(courseDifficulty.ordinal());
        for (int ticks = 0; ticks < 380; ticks++) {
            //play the game
            //if cheater caught then break;
        }

    }

    private static void populate(Object[][] room) {
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[row].length; col++) {
                //populate with data
                if (col % 2 == 0) {
                    room[row][col] = new Student();
                } else {
                    room[row][col] = new Walkway();
                }
                //we put 6 columns in the space
                room[20][4] = new Column();

            }
        }
    }

}
