package com.entities;

import static com.Main.listOfColumns;
import static com.Main.listOfMaliciousStudents;

public class Room {
    static Object[][] room;

    public Room(int numberOfRows, int numberOfCols) {
        room = new Object[numberOfRows][numberOfCols];
        populate(room);
    }
//TODO the positions are not correct ( which in turn creates a problem in MonterCarloSimulation class). Need to change it in order to check it if the position is already taken.
    private static void populate(Object[][] room) {
        int numberOfColumns = 6;
        //we put #numberOfColumns columns in the room, one every 15 rows and every 4 cols starting from row 9
        int row = 9;
        //TODO fix columns positions
        while (numberOfColumns != 0) {
            int col = 0;
            Column column = new Column(row, col);
            room[row][col] = column;
            listOfColumns.add(column);
            col += 6;
            Column column1 = new Column(row, col);
            room[row][col] = column1;
            listOfColumns.add(column1);
            col += 5;
            Column column2 = new Column(row, col);
            room[row][col] = column2;
            listOfColumns.add(column2);
            row += 8;
            numberOfColumns -= 1;
        }
        for (int rows = 0; rows < room.length; rows++) {
            for (int col = 0; col < room[rows].length; col++) {
                //populate with data
                if (col % 2 == 0 && rows != 0) {
                    Student student = new Student(rows, col);
                    room[rows][col] = student;
                    if (student.isMalicious()) {
                        listOfMaliciousStudents.add(student);
                    }
                } else {
                    room[rows][col] = new Walkway(rows, col);
                }
            }
        }
    }

    public static Object[][] getRoom() {
        return room;
    }
}
