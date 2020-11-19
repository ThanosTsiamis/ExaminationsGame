package com.entities;

import static com.Main.professorsAttitudeEnum;
import static com.entities.Room.getRoom;
import static com.helpers.Helpers.moveChanceGenerator;
import static com.helpers.Helpers.pathChooser;

import java.awt.geom.Point2D;
import java.util.Random;

import squidpony.squidgrid.Direction;
import squidpony.squidgrid.Radius;

public class Supervisor {
    int row;
    int col;
    double awareness;
    float[][] visibilityMatrix = new float[getRoom().length][getRoom()[0].length];

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
        //TODO fix awareness threshold
        this.awareness = professorsAttitudeEnum.ordinal() * 0.75 + 1;
    }

    public void move(int row, int col) {
        if (moveChanceGenerator()) {
            this.row = row;
            this.col = col;
        }
    }

    public void roundMove() {
        Point2D direction = pathChooser(row, col);
        move((int) direction.getX(), (int) direction.getY());
    }

    public void assumePosition() {
        Random random = new Random();
        int lowestBound = 0;
        int highestBound = 14;
        int column = random.nextInt(highestBound - lowestBound) + lowestBound;
        //TODO move contains a move chance generator . Need to always assume position
        move(0, column);
    }

    public float[][] calculateFOV() {
        visibilityMatrix[getRow()][getCol()] = 1;//light the starting cell
        for (Direction d : Direction.DIAGONALS) {
            castLight(1, 1.0f, 0.0f, 0, d.deltaX, d.deltaY, 0);
            castLight(1, 1.0f, 0.0f, d.deltaX, 0, 0, d.deltaY);
        }
        return visibilityMatrix;
    }

    private void castLight(int row, float start, float end, int xx, int xy, int yx, int yy) {
        float newStart = 0.0f;
        if (start < end) {
            return;
        }
        boolean blocked = false;
        for (int distance = row; distance <= getAwareness() && !blocked; distance++) {
            int deltaY = -distance;
            for (int deltaX = -distance; deltaX <= 0; deltaX++) {
                int currentX = getRow() + deltaX * xx + deltaY * xy;
                int currentY = getCol() + deltaX * yx + deltaY * yy;
                float leftSlope = (deltaX - 0.5f) / (deltaY + 0.5f);
                float rightSlope = (deltaX + 0.5f) / (deltaY - 0.5f);

                if (!(currentX >= 0 && currentY >= 0 && currentX < getRoom().length && currentY < getRoom()[0].length) || start < rightSlope) {
                    continue;
                } else if (end > leftSlope) {
                    break;
                }

                //check if it's within the lightable area and light if needed
                Radius radiusStrategy = Radius.CIRCLE;
                if (radiusStrategy.radius(deltaX, deltaY) <= getAwareness()) {
                    float bright = (float) (1 - (radiusStrategy.radius(deltaX, deltaY) / getAwareness()));
                    visibilityMatrix[currentX][currentY] = bright;
                }

                if (blocked) { //previous cell was a blocking one
                    if (getRoom()[currentX][currentY].getClass().getCanonicalName().equals("com.entities.Column")) {//hit a wall
                        newStart = rightSlope;
                    } else {
                        blocked = false;
                        start = newStart;
                    }
                } else {
                    if (getRoom()[currentX][currentY].getClass().getCanonicalName().equals("com.entities.Column") && distance < getAwareness()) {//hit a wall within sight line
                        blocked = true;
                        castLight(distance + 1, start, leftSlope, xx, xy, yx, yy);
                        newStart = rightSlope;
                    }
                }
            }
        }
    }
}
