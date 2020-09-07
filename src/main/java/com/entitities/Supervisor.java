package com.entitities;

import static com.Main.professorsAttitudeEnum;

import java.util.Random;

public class Supervisor {
    int row;
    int col;
    double awareness;

    //TODO round awareness to an integer to represent the vision of the Supervisors
    public double getAwareness() {
        return awareness;
    }

    public Supervisor() {
        this.awareness = professorsAttitudeEnum.ordinal() * 0.23 + 1;
    }

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void pathTaken() {
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

}
