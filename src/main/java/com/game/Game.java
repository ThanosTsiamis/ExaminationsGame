package com.game;

import static com.Main.listOfMaliciousStudents;
import static com.Main.listOfSupervisors;

import com.entitities.Student;
import com.entitities.Supervisor;

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
        //the order of these functions below is very important as it dictates the way of playing the game
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
        //call Supervisor.move(xx,yy) where xx and yy will be the path they will take
        //The path implementation TBD
    }

    private void studentsCheat(int roundNumber) {
        for (Student student : listOfMaliciousStudents) {
            student.cheat(roundNumber);
        }
    }

    private void visionCheck() {
        //fetch awareness from supervisors--DONE by traversing the list
        //fetch awareness from professor--DONE by traversing the list
        //based on the position calculate the circle that a supervisor can catch a student
        //within bounds of course
        for (Supervisor supervisor : listOfSupervisors) {
            //do the vision check
            double radius = supervisor.getAwareness();
        }
        //maybe return it as a list(?)
    }

    private boolean caughtCheck() {
        //based on visionCheck check if a student exists on this discrete circle who has isCheating == true
        //this means that it takes the coordinates of the supervisor and calculates the discrete circle
        //next, it checks whether a malicious student in the listOfMaliciousStudents that actively cheats is in the circle
        //if exists then return true
        //if not return false
        for (Supervisor supervisor : listOfSupervisors) {
            //center of the circle
            int x = supervisor.getRow();
            int y = supervisor.getCol();
            if (supervisor.getClass().getSimpleName().equals("Supervisor")) {
                System.out.println(supervisor.getAwareness());
                //discrete circle
            }else{
                //professor
                //discrete circle
                System.out.println(supervisor.getAwareness());
            }
            //double radius =
        }
        return false;
    }

    private boolean cheatSuccessfulCheck() {
        //if caughtCheck is false then this means that the student is not caught and return true
        if (!caughtCheck()) {
            return true;
            //cheaters win (for this round)
        } else {
            //game over good bye
            return false;
        }

    }

}
