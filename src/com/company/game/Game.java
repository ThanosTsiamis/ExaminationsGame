package com.company.game;

import static com.company.Main.listOfMaliciousStudents;

import com.company.entitities.Student;

public class Game {
    public static boolean maliciousStudentCaught;
    static int roundNumber;

//    public static boolean isMaliciousStudentCaught() {
//        return maliciousStudentCaught;
//    }

    public Game() {
        roundNumber = 0;
    }

    public void playRound() {
        //the order of these functions below is very important as it dictates a way of playing the game
        moveSupervisors();
        studentsCheat(roundNumber);
        visionCheck();
        caughtCheck();
        cheatSuccessfulCheck();
        //Maybe playRound should return a boolean to end the game -->maliciousStudentCaught?
        roundNumber += 1;

    }

    public void endOfGame() {
        //export cheaters positions to a map <int-position xxyy,boolean-caught true/false>
    }

    public boolean isOn() {
        if (roundNumber < 360) {
            return true;
        } else {
            return false;
        }
    }

    public void revertResultsToOriginal() {
        //make sure to revert everything in the end in the original position for the program to run repeatedly
        //malicious Students and roundNumber so far
    }

    private void moveSupervisors() {

    }

    private void studentsCheat(int roundNumber) {
        //students will try to cheat as time progresses
        //it will call cheat
        for (Student student : listOfMaliciousStudents) {
            //I need to implement it in such way that every (malicious) student will
            //cheat with a random chance , and if so he will stop after 2 rounds or so.
            student.cheat(roundNumber);
        }
        //for every malicious Student stored in the list call Math.random in respect to roundNumber
    }

    private void visionCheck() {
        //fetch awareness from supervisors
        //fetch awareness from professor
        //based on the position calculate the circle that a supervisor can catch a student
        //within bounds of course


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
