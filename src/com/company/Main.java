package com.company;

import java.util.ArrayList;

import com.company.entitities.Professor;
import com.company.entitities.Student;
import com.company.entitities.Supervisor;
import com.company.entitities.Walkway;
import com.company.enums.CourseDifficulty;
import com.company.enums.ProfessorsAttitude;
import com.company.game.Game;

public class Main {
    public static Enum<CourseDifficulty> courseDifficulty = CourseDifficulty.EASY;
    public static Enum<ProfessorsAttitude> professorsAttitudeEnum = ProfessorsAttitude.RELAXED;

    public static void main(String[] args) {
        //set the dimensions of the room
        int numberOfRows = 50;
        int numberOfCols = 13;
        Object[][] room = new Object[numberOfRows][numberOfCols];

        //populate the Room
        populate(room);

        //the supervisors come to the room
        int numberOfSupervisors = courseDifficulty.ordinal() + 1;
        ArrayList<Supervisor> listOfSupervisors = new ArrayList<>();
        for (int number = 0; number < numberOfSupervisors; number++) {
            Supervisor supervisor = new Supervisor();
            listOfSupervisors.add(supervisor);
            //supervisor assumes a position in the room in the first row
            //The position is random in the first row.
            supervisor.assumePosition();
        }

        Professor professor = new Professor();

        Game game = new Game();

        //Game starts
        for (int ticks = 0; ticks < 380; ticks++) { //Each tick is a round
            //play the game
            game.playRound();
            //if cheater caught then break;
        }

        //game ends here
        game.endOfGame();
        //store the results in a csv file with two tabs

    }

    private static void populate(Object[][] room) {
        int numberOfColumns = 6;
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[row].length; col++) {
                //populate with data
                if (col % 2 == 0 && row != 0) {
                    room[row][col] = new Student(row, col);
                } else {
                    room[row][col] = new Walkway(row, col);
                }
            }
        }
        //we put #numberOfColumns columns in the room
        for (int counter = 0; counter < numberOfColumns; counter++) {
            //   room[20][4] = new Column(20, 4);
        }
    }
}
