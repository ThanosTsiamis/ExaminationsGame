package com;

import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.entitities.Column;
import com.entitities.Supervisor;
import com.entitities.Walkway;
import com.enums.CourseDifficulty;
import com.enums.ProfessorsAttitude;
import com.game.Game;
import com.entitities.Professor;
import com.entitities.Student;

public class Main {
    public static Enum<CourseDifficulty> courseDifficulty = CourseDifficulty.EASY;
    public static Enum<ProfessorsAttitude> professorsAttitudeEnum = ProfessorsAttitude.RELAXED;
    public static ArrayList<Student> listOfMaliciousStudents = new ArrayList<>();

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
        for (int counter = 0; counter < numberOfSupervisors; counter++) {
            Supervisor supervisor = new Supervisor();
            listOfSupervisors.add(supervisor);
            //supervisor assumes a position in the room in the first row
            //The position is random in the first row.
            supervisor.assumePosition();
        }

        Professor professor = new Professor();

        Game game = new Game();

        //Game starts
        while (game.isOn()) {
            //play the game
            game.playRound();
            //if cheater caught then break;
        }

        //game ends here
        game.endOfGame();

        //store the results in a csv file with two tabs
        createResults();

        //after storage revert to original state
        game.revertResultsToOriginal();
        //empty list of Malicious Students
        listOfMaliciousStudents.clear();
    }

    private static void populate(Object[][] room) {
        int numberOfColumns = 6;
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[row].length; col++) {
                //populate with data
                if (col % 2 == 0 && row != 0) {
                    Student student = new Student(row, col);
                    room[row][col] = student;
                    if (student.isMalicious()) {
                        listOfMaliciousStudents.add(student);
                    }
                } else {
                    room[row][col] = new Walkway(row, col);
                }
            }
        }
        //we put #numberOfColumns columns in the room, one every 15 rows and every 4 cols
        int row=10;
        while (numberOfColumns != 0) {
            int col=1;
            room[row][col] = new Column(row,col);
            col +=5;
            room[row][col] = new Column(row,col);
            row+=15;
            //it creates index out of bounds
            //TODO find a different way to implement this
            numberOfColumns -= 1;
        }
    }
    private static void createResults(){
        //TODO check if it overwrites deleting the previous results
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Results");
    }
}
