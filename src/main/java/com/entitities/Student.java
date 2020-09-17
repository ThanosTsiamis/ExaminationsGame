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
    private boolean caught = false;

    public boolean isMalicious() {
        return malicious;
    }

    public boolean isCheating() {
        return cheating;
    }

    public void setCheating(boolean cheating) {
        this.cheating = cheating;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isCaught() {
        return caught;
    }

    public void setCaught(boolean caught) {
        this.caught = caught;
    }

    public Student(int row, int col) {
        this.row = row;
        this.col = col;
        malicious = Math.random() > maliciousThreshold();
    }

    public void cheat() {
        if (!hasCheatedSuccessfully) {
            int roundsCheatingNeededToWin = 4;
            if (isCheating() && roundsCheating > roundsCheatingNeededToWin) {
                setCheating(false);
                hasCheatedSuccessfully = true;
            } else if (isCheating() && roundsCheating <= roundsCheatingNeededToWin) {
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
            return Math.random() < (0.01 / 12) * Game.getRoundNumber();
        } else if (Game.getRoundNumber() < 356) {
            return Math.random() < (0.55 / 295) * Game.getRoundNumber();
        } else {
            return true;
        }
    }
}

