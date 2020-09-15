package com.entitities;

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
        //we put #numberOfColumns columns in the room, one every 15 rows and every 4 cols
        int row = 9;
        while (numberOfColumns != 0) {
            int col = 1;
            room[row][col] = new Column(row, col);
            col += 5;
            room[row][col] = new Column(row, col);
            row += 8;
            numberOfColumns -= 1;
        }
    }

    public static Object[][] getRoom() {
        return room;
    }
}
