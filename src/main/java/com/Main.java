package com;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
        //store the results in a csv file
        createResults(listOfColumns);
        createResults(mapOfStudentPositions);
    }

    private static void createResults(ArrayList<Column> listOfColumns) {
        String filename = "Results.xlsx";
        try {
            FileInputStream excelFile = new FileInputStream(new File(filename));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            CellStyle headerStyle = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 16);
            font.setBold(true);
            headerStyle.setFont(font);

            for (Column column : listOfColumns) {
                sheet.getRow(column.getRow()).getCell(column.getCol()).setCellValue("Column");
            }

            File currDir = new File(".");
            String path = currDir.getAbsolutePath();
            String fileLocation = path.substring(0, path.length() - 1) + "Results.xlsx";

            FileOutputStream outputStream;
            outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO SKANE TA COLUMNS - prepei na exei sxesi me to +1 twn rows
    private static void createResults(HashMap<Point2D, Boolean> mapOfEntities) {
        String filename = "Results.xlsx";
        try {
            FileInputStream excelFile = new FileInputStream(new File(filename));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            for (Map.Entry<Point2D, Boolean> entry : mapOfEntities.entrySet()) {
                int row = (int) entry.getKey().getX();
                int col = (int) entry.getKey().getY();
                if (!entry.getValue()) {
                    CellType cellType = sheet.getRow(row).getCell(col).getCellTypeEnum();
                    double value;
                    if (cellType.equals(CellType.NUMERIC)) {
                        value = sheet.getRow(row).getCell(col).getNumericCellValue();
                    } else {
                        value = Double.parseDouble(sheet.getRow(row).getCell(col).getStringCellValue());
                    }
                    sheet.getRow(row).getCell(col).setCellValue(value + 1);
                }
            }

            File currDir = new File(".");
            String path = currDir.getAbsolutePath();
            String fileLocation = path.substring(0, path.length() - 1) + "Results.xlsx";

            FileOutputStream outputStream;
            outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void clearEverything() {
        listOfColumns.clear();
        listOfMaliciousStudents.clear();
        listOfSupervisors.clear();
    }
}
