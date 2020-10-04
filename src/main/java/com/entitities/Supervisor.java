package com.entitities;

import static com.Main.professorsAttitudeEnum;
import static com.helpers.Helpers.moveChanceGenerator;
import static com.helpers.Helpers.pathChooser;

import java.awt.geom.Point2D;
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
        Point2D direction = pathChooser(row,col);
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
}
