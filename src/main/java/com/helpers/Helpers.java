package com.helpers;

import static com.entities.Room.getRoom;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

public class Helpers {
    public static boolean moveChanceGenerator() {
        //TODO implement move chance generator
        //it will calculate whether the supervisor will move this round (getRoundNumber) or stay put
        //Supervisors tend to be more active during the start of the exams and then they are slow off the mark
        return true;
    }

    public static Point2D pathChooser(int row, int col) {
        //will return up down left right direction
        ArrayList<Point2D> paths = new ArrayList<>();
        if (!checkOutOfBounds(row - 1, col)) {
            paths.add(new Point2D.Double(row - 1, col));
        }
        if (!checkOutOfBounds(row + 1, col)) {
            paths.add(new Point2D.Double(row + 1, col));
        }
        if (!checkOutOfBounds(row, col - 1)) {
            paths.add(new Point2D.Double(row, col - 1));
        }
        if (!checkOutOfBounds(row, col + 1)) {
            paths.add(new Point2D.Double(row, col + 1));
        }
        return paths.get(new Random().nextInt(paths.size()));
    }

    private static boolean checkOutOfBounds(int row, int col) {
        try {
            Object[][] room = getRoom();
            if (room[row][col].getClass().getCanonicalName().equals("com.entities.Walkway")) {
                return false;
            }
            if (room[row][col].getClass().getCanonicalName().equals("com.entities.Student")) {
                return true;
            }
            if (room[row][col].getClass().getCanonicalName().equals("com.entities.Column")) {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
