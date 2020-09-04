package com.company.game;

public class Game {
    public static boolean maliciousStudentCaught;

    public static boolean isMaliciousStudentCaught() {
        return maliciousStudentCaught;
    }

    public void playRound() {
        //the order of these functions below is very important as it dictates a way of playing the game
        moveSupervisors();
        studentsCheat();
        visionCheck();
        cheatSuccessfulCheck();
        caughtCheck();
        //Maybe playRound should return a boolean to end the game -->maliciousStudentCaught?

    }

    private void moveSupervisors() {

    }

    private void studentsCheat() {

    }

    private void visionCheck() {

    }

    private void cheatSuccessfulCheck() {

    }

    private void caughtCheck() {

    }

}
