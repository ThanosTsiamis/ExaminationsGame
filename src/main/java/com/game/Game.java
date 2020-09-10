package com.game;

import static com.Main.listOfMaliciousStudents;
import static com.Main.listOfSupervisors;

import com.entitities.Student;
import com.entitities.Supervisor;

public class Game {
    public static boolean maliciousStudentCaught;
    static int roundNumber;

    public static int getRoundNumber() {
        return roundNumber;
    }
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
        sendHomeSupervisor();
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
        //TODO add obstacles (columns) in the discrete circle - add some thoughts
        for (Supervisor supervisor : listOfSupervisors) {
            //center of the circle
            int x_centre = supervisor.getRow();
            int y_centre = supervisor.getCol();

            //discrete circle
            int radius = (int) Math.rint(supervisor.getAwareness());
            //make the discrete circle
            //hide the squares that are blocked by a column
            //if they are on the same row or column hide the next(left or right based on the position) cols or rows respectively
            // until the end of awareness (i.e. radius)
            //if not hide the next rows and next cols (diagonal squares)until the end of awareness (i.e radius)

        }
        //call a function that calculates which students are hidden

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
    private void sendHomeSupervisor(){
        // if we are in the late game(i.e. last 100 ticks) and the course difficulty is hard or relatively hard and there are at least two supervisors
        //then delete at least one from the list of supervisors (check if he is a supervisor and not the professor)
        if (roundNumber>180){
        //remove one supervisor
        }
    }

}
