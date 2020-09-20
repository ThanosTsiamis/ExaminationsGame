package com.entitities;

import static com.Main.listOfColumns;
import static com.Main.listOfMaliciousStudents;

public class Room {
    static Object[][] room;

    public Room(int numberOfRows, int numberOfCols) {
        this.room = new Object[numberOfRows][numberOfCols];
        populate(room);
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
        //we put #numberOfColumns columns in the room, one every 15 rows and every 4 cols starting from row 9
        int row = 9;
        //TODO fix columns positions
        while (numberOfColumns != 0) {
            int col = 1;
            Column column = new Column(row, col);
            room[row][col] = column;
            listOfColumns.add(column);
            col += 5;
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
    }

    public static Object[][] getRoom() {
        return room;
    }
}
