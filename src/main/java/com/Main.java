package com;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
        createResults(mapOfStudentPositions);
    }

    private static void createResults(HashMap mapOfStudents) {
        //TODO check if it overwrites deleting the previous results
        String excelFilePath = "Results.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);

            Object[][] bookData = {
                    {"The Passionate Programmer", "Chad Fowler", 16},
                    {"Software Craftmanship", "Pete McBreen", 26},
                    {"The Art of Agile Development", "James Shore", 32},
                    {"Continuous Delivery", "Jez Humble", 41},
            };

            int rowCount = sheet.getLastRowNum();

            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);

                int columnCount = 0;

                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);

                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }

            }

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream("Results.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

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
