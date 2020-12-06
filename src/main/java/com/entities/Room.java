package com.entities;

import static com.Main.listOfColumns;
import static com.Main.listOfMaliciousStudents;
import static com.Main.numberOfColumns;

public class Room {
    static Object[][] room;

    public Room(int numberOfRows, int numberOfCols) {
        room = new Object[numberOfRows][numberOfCols];
        populate(room);
    }

    private static void populate(Object[][] room) {
        int row = 9;
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
                if (room[rows][col] == null) { //if it's not a column
                    if (col % 2 == 0 && rows != 0) { //if it's not on the first row and every two columns
                        Student student = new Student(rows, col);
                        room[rows][col] = student; // populate with a student
                        if (student.isMalicious()) {
                            listOfMaliciousStudents.add(student);
                        }
                    } else {
                        room[rows][col] = new Walkway(rows, col); //else put a walkway
                    }
                }
            }
        }
    }

    public static Object[][] getRoom() {
        return room;
    }
}
