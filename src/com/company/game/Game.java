package com.company.game;

public class Game {
    public static boolean maliciousStudentCaught;

//    public static boolean isMaliciousStudentCaught() {
//        return maliciousStudentCaught;
//    }

    public void playRound() {
        //the order of these functions below is very important as it dictates a way of playing the game
        moveSupervisors();
        studentsCheat();
        visionCheck();
        caughtCheck();
        cheatSuccessfulCheck();
        //Maybe playRound should return a boolean to end the game -->maliciousStudentCaught?

    }
    public void endOfGame(){
        //export cheaters positions to a list
        //export caught results to a list
    }

    private void moveSupervisors() {

    }

    private void studentsCheat() {

    }

    private void visionCheck() {
        //fetch awareness from supervisors
        //fetch awareness from professor
        //based on the position calculate the circle that a supervisor can catch a student
        //maybe return it as a list(?)
    }

    private void caughtCheck() {
        //based on visionCheck check if a student exists on this discrete circle who has isCheating == true
        //if exists then return true
        //if not return false
    }

    private void cheatSuccessfulCheck() {
        //if caught check is false then the student is not caught for each Supervisor
    }


}
