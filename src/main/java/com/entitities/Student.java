package com.entitities;

import com.Main;
import com.game.Game;

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
        if (Math.random() > maliciousThreshold()) {
            malicious = true;
        } else {
            malicious = false;
        }
    }

    public void cheat() {
        if (!hasCheatedSuccessfully) {
            if (isCheating() && roundsCheating > 4) {
                setCheating(false);
                hasCheatedSuccessfully = true;
            } else if (isCheating() && roundsCheating <= 4) {
                roundsCheating += 1;
            }
            if (isMalicious() && !isCheating() && cheatingChanceGenerator()) {
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
                //use dfs algorithm
            }
        }
    }

    private double maliciousThreshold() {
        return Main.courseDifficulty.ordinal() * 0.235 + 0.01;
    }

    private boolean cheatingChanceGenerator() {
        if (Game.getRoundNumber() <= 60) {
            if (Math.random() < (0.01 / 12) * Game.getRoundNumber()) {
                return true;
            }
        } else if (Game.getRoundNumber() < 356) {
            if (Math.random() < (0.55 / 295) * Game.getRoundNumber()) {
                return true;
            }
        } else {
            return true;
        }
        return false;
    }
}

