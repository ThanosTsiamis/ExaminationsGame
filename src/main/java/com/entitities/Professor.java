package com.entitities;

public class Professor extends Supervisor {
    int row;
    int col;

    public Professor() {
        this.row = 0;
        this.col = 5;
    }

    @Override
    public double getAwareness() {
        return super.getAwareness() * 1.75;
    }

    @Override
    public void move(int row, int col) {
        super.move(0, 5);
    }
}
