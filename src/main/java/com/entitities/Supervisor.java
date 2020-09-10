package com.entitities;

import static com.Main.professorsAttitudeEnum;

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
            assumePosition();
            this.row = row;
            this.col = col;
        }
    }

    public void pathFollowing() {
        // we could use a stack to pop elements and set the path
        //have them go up and down the walkways by keeping track of the col and going all the way up (or down)
    }

    public void assumePosition() {
        Random random = new Random();
        int lowestBound = 0;
        int highestBound = 14;
        int result = random.nextInt(highestBound - lowestBound) + lowestBound;
        move(0, result);
    }

    private boolean moveChanceGenerator() {
        //TODO implement move chance generator
        //it will calculate whether the supervisor will move this round (getRoundNumber) or stay put
        //Supervisors tend to be more active during the start of the exams and then they are slow off the mark

        return true;
    }

}
