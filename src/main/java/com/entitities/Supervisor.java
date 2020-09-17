package com.entitities;

import static com.Main.professorsAttitudeEnum;
import static com.entitities.Room.getRoom;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

public class Supervisor {
    int row;
    int col;
    double awareness;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public double getAwareness() {
        return awareness;
    }

    public Supervisor() {
        this.awareness = professorsAttitudeEnum.ordinal() * 0.75 + 1;
    }

    public void move(int row, int col) {
        //move will also take into consideration pathTaken function to calculate next move
        if (moveChanceGenerator()) {
            this.row = row;
            this.col = col;
        }
    }

    public void roundMove() {
        Point2D direction = pathChooser();
        move((int) direction.getX(), (int) direction.getY());
    }

    public void assumePosition() {
        Random random = new Random();
        int lowestBound = 0;
        int highestBound = 14;
        int result = random.nextInt(highestBound - lowestBound) + lowestBound;
        //TODO move contains a move chance generator . Need to always assume position
        move(0, result);
    }

    private boolean moveChanceGenerator() {
        //TODO implement move chance generator
        //it will calculate whether the supervisor will move this round (getRoundNumber) or stay put
        //Supervisors tend to be more active during the start of the exams and then they are slow off the mark

        return true;
    }

    private Point2D pathChooser() {
        //will return up down left right direction
        //TODO when attractAttention is implemented a big if else is required here
        Object[][] room = getRoom();
        ArrayList<Point2D> paths = new ArrayList<Point2D>();
        try {
            //up
            if (room[row - 1][col].getClass().getCanonicalName().equals("Walkway")) {
                //add up to list
                paths.add(new Point2D.Double(row - 1, col));
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println(indexOutOfBoundsException);
        }
        try {
            //down
            if (room[row + 1][col].getClass().getCanonicalName().equals("Walkway")) {
                //add down to list
                paths.add(new Point2D.Double(row + 1, col));

            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println(indexOutOfBoundsException);
        }
        try {
            //left
            if (room[row][col - 1].getClass().getCanonicalName().equals("Walkway")) {
                //add left to list
                paths.add(new Point2D.Double(row, col - 1));

            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println(indexOutOfBoundsException);
        }
        try {
            //right
            if (room[row][col + 1].getClass().getCanonicalName().equals("Walkway")) {
                //add right to list
                paths.add(new Point2D.Double(row, col + 1));

            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println(indexOutOfBoundsException);
        }
        return paths.get(new Random().nextInt(paths.size()));
    }

}
