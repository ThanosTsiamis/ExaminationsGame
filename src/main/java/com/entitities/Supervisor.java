package com.entitities;

import static com.Main.professorsAttitudeEnum;
import static com.entitities.Room.getRoom;

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

    public void pathFollowing() {
        //will return up down left right direction
        Object[][] room = getRoom();

        //will use move function once each turn
        //fetch up down left right element from Room list and if type of Walkway add to the list
        //choose one integer randomly from the list given the size of the list

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
