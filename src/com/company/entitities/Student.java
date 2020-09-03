package com.company.entitities;

import static com.company.Main.courseDifficulty;
import static com.company.enums.CourseDifficulty.EASY;
import static com.company.enums.CourseDifficulty.MEDIUM;
import static com.company.enums.CourseDifficulty.RELATIVELY_EASY;
import static com.company.enums.CourseDifficulty.RELATIVELY_HARD;

public class Student {
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

    public Student() {
        if (Math.random() < maliciousThreshold()) {
            malicious = true;
        } else {
            malicious = false;
        }
    }

    public void cheat() {
        if (isMalicious() && !isCheating()) {
            setCheating(true);
        }
    }

    public void attractAttention() {
        if (!malicious) {
            //TODO change it according to the course's difficulty
            if (Math.random() < 0.1) {
                //set the path of a supervisor to a student
            }
        }
    }

    private double maliciousThreshold() {
        if (EASY.equals(courseDifficulty)) {
            return 0.095;
        } else if (RELATIVELY_EASY.equals(courseDifficulty)) {
            return 0.05;
        } else if (MEDIUM.equals(courseDifficulty)) {
            return 0.025;
        } else if (RELATIVELY_HARD.equals(courseDifficulty)) {
            return 0.02;
        } else {
            return 0.01;
        }
    }
}

