package com.company.entitities;

import static com.company.Main.courseDifficulty;

public class Student {
    final int row;
    final int col;
    private final boolean malicious;
    private boolean cheating;

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
            //TODO store the malicious students objects in a list
        } else {
            malicious = false;
        }
    }

    public void cheat() {
        if (isCheating()) {
            setCheating(false);
        }
        if (isMalicious() && !isCheating()) {
            setCheating(true);
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
        return courseDifficulty.ordinal() * 0.235 + 0.01;
    }
}

