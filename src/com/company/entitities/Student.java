package com.company.entitities;

import static com.company.Main.courseDifficulty;
import static com.company.enums.CourseDifficulty.EASY;

import static com.company.enums.CourseDifficulty.MEDIUM;
import static com.company.enums.CourseDifficulty.RELATIVELY_EASY;
import static com.company.enums.CourseDifficulty.RELATIVELY_HARD;


public class Student {
    private final boolean malicious;

    public boolean isMalicious() {
        return malicious;
    }

    public Student() {
        if (Math.random()<maliciousThreshold()) {
            malicious = true;
        }else{
            malicious=false;
        }
    }
    private double maliciousThreshold(){
        if (EASY.equals(courseDifficulty)) {
            return 0.095;
        } else if (RELATIVELY_EASY.equals(courseDifficulty)) {
            return 0.05;
        } else if (MEDIUM.equals(courseDifficulty)) {
            return 0.025;
        } else if (RELATIVELY_HARD.equals(courseDifficulty)) {
            return 0.02;
        } else  {
            return 0.01;
        }
    }
}

