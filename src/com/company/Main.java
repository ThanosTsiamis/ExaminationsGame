package com.company;

import com.company.entitities.Column;
import com.company.entitities.Professor;
import com.company.entitities.Student;
import com.company.entitities.Supervisor;
import com.company.entitities.Walkway;
import com.company.enums.CourseDifficulty;
import com.company.enums.ProfessorsAttitude;
import com.company.game.Game;

public class Main {
    public static Enum<CourseDifficulty> courseDifficulty = CourseDifficulty.MEDIUM;
    public static Enum<ProfessorsAttitude> professorsAttitudeEnum = ProfessorsAttitude.RELAXED;

    public static void main(String[] args) {
        //populate the Room
        int numberOfRows = 50;
        int numberOfCols = 13;

        Object[][] room = new Object[numberOfRows][numberOfCols];
        populate(room);
        //the supervisors come to the room
        int numberOfSupervisors = courseDifficulty.ordinal() + 1;
        for (int number = 0; number < numberOfSupervisors; number++) {
            Supervisor supervisor = new Supervisor();
            //supervisor assumes a position in the room in the first row
            //The position is random in the first row.
            supervisor.assumePosition();
        }
        Professor professor = new Professor();
        Game game = new Game();
        //Game starts
        for (int ticks = 0; ticks < 380; ticks++) { //Each tick is a round
            //play the game
            //if cheater caught then break;
        }

    }

    private static void populate(Object[][] room) {
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[row].length; col++) {
                //populate with data
                if (col % 2 == 0 && row != 0) {
                    room[row][col] = new Student();
                } else {
                    room[row][col] = new Walkway(row, col);
                }
                //we put 6 columns in the space
                room[20][4] = new Column();

            }
        }
    }
}
