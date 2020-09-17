package com;

import java.awt.geom.Point2D;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.entitities.Column;
import com.entitities.Professor;
import com.entitities.Room;
import com.entitities.Student;
import com.entitities.Supervisor;
import com.enums.CourseDifficulty;
import com.enums.ProfessorsAttitude;
import com.game.Game;

public class Main {
    public static Enum<CourseDifficulty> courseDifficulty = CourseDifficulty.EASY;
    public static Enum<ProfessorsAttitude> professorsAttitudeEnum = ProfessorsAttitude.RELAXED;
    public static ArrayList<Student> listOfMaliciousStudents = new ArrayList<>();
    public static ArrayList<Supervisor> listOfSupervisors = new ArrayList<>();
    public static ArrayList<Column> listOfColumns = new ArrayList<>();

    public static void main(String[] args) {
        clearEverything();
        //set the dimensions of the room
        int numberOfRows = 50;
        int numberOfCols = 13;
        Room room = new Room(numberOfRows, numberOfCols);

        //the supervisors come to the room
        int numberOfSupervisors = courseDifficulty.ordinal() + 1;

        for (int counter = 0; counter < numberOfSupervisors; counter++) {
            Supervisor supervisor = new Supervisor();
            listOfSupervisors.add(supervisor);
            //supervisor assumes a position in the room in the first row
            //The position is random in the first row.
            supervisor.assumePosition();
        }

        Professor professor = new Professor();
        listOfSupervisors.add(professor);

        Game game = new Game();

        //Game starts
        while (game.isOn()) {
            //play the game
            game.playRound();
            //if cheater caught then break;
            if (Game.isMaliciousStudentCaught()) {
                break;
            }
        }

        //game ends here
        HashMap<Point2D, Boolean> mapOfStudentPositions = game.endOfGame();

        //store the results in a csv file with two tabs
        createResults();
    }

    private static void createResults() {
        //TODO check if it overwrites deleting the previous results - do it in a scratch file
        try {
            String filename = "Results.xlsx";
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Results");
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void clearEverything() {
        listOfColumns.clear();
        listOfMaliciousStudents.clear();
        listOfSupervisors.clear();
    }
}
