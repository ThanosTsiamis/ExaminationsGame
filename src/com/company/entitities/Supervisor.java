package com.company.entitities;

import static com.company.Main.professorsAttitudeEnum;

public class Supervisor {
    int row;
    int col;
    double awareness;

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

    public void pathTaken(){
        // we could use a stack to pop elements and set the path
    }




}
