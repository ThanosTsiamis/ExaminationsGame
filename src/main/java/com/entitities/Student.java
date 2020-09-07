package com.entitities;

import com.Main;

public class Student {
    final int row;
    final int col;
    private final boolean malicious;
    private boolean cheating;
    private int roundsCheating = 0;
    private boolean hasCheatedSuccessfully = false;

    public boolean isMalicious() {
        return malicious;
    }

    public boolean isCheating() {
        return cheating;
    }

    public void setCheating(boolean cheating) {
        this.cheating = cheating;
    }

    public Student(int row, int col) {
        this.row = row;
        this.col = col;
        if (Math.random() < maliciousThreshold()) {
            malicious = true;
        } else {
            malicious = false;
        }
    }

    public void cheat(int roundNumber) {
        if (!hasCheatedSuccessfully) {
            if (isCheating() && roundsCheating > 4) {
                setCheating(false);
                hasCheatedSuccessfully = true;
            } else if (isCheating() && roundsCheating <= 4) {
                roundsCheating += 1;
            }
            if (isMalicious() && !isCheating() && cheatingChanceGenerator(roundNumber)) {
                roundsCheating += 1;
                setCheating(true);
            }
        }
    }

    public void attractAttention() {
        if (!malicious) {
            //TODO change it according to the course's difficulty.This means more difficult courses attract more attention.
            if (Math.random() < 0.1) {
                //set the path of a supervisor to a student
            }
        }
    }

    private double maliciousThreshold() {
        return Main.courseDifficulty.ordinal() * 0.235 + 0.01;
    }

    private boolean cheatingChanceGenerator(int roundNumber) {
        //TODO implement this
        //if Math.random < some value then return true
        //else return false
        //should return a boolean based on the roundNumber
        return true;
        //we have 380 rounds and
    }
}

