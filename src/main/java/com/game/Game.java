package com.game;

import static com.Main.listOfColumns;
import static com.Main.listOfMaliciousStudents;
import static com.Main.listOfSupervisors;
import static com.Main.professorsAttitudeEnum;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import com.entitities.Column;
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
        studentsCheat();
        visionCheck();
        caughtCheck();
        cheatSuccessfulCheck();
        roundNumber += 1;
        sendHomeSupervisor();
    }

    public void endOfGame() {
        //export cheaters positions to a map <int-position xxyy,boolean-caught true/false>
    }

    public boolean isOn() {
        return roundNumber < 360;
    }

    private void moveSupervisors() {
        //call Supervisor.move(xx,yy) where xx and yy will be the path they will take
        for (Supervisor supervisor : listOfSupervisors) {
            supervisor.roundMove();
        }
    }

    private void studentsCheat() {
        for (Student student : listOfMaliciousStudents) {
            student.cheat();
        }
    }

    //TODO implement vision check
    private void visionCheck() {
        //based on the position calculate the circle that a supervisor can catch a student
        //within bounds of course
        //if not hide the next rows and next cols (diagonal squares)until the end of awareness (i.e radius)
        for (Supervisor supervisor : listOfSupervisors) {
            //do the vision check by drawing Bresenham's circle
            //next up find the columns and hide these squares and the
            for (Column column : listOfColumns) {

            }
            //for every malicious Student that is cheating check if they are inside the circle
            for (Student student : listOfMaliciousStudents) {

            }
        }
    }
    //maybe return it as a list(?)

    private boolean caughtCheck() {
        //based on visionCheck check if a student exists on this discrete circle who has isCheating == true
        //this means that it takes the coordinates of the supervisor and calculates the discrete circle
        //next, it checks whether a malicious student in the listOfMaliciousStudents that actively cheats is in the circle
        //if exists then return true
        //if not return false

        //call a function that calculates which students are hidden

        return false;
    }

    private boolean cheatSuccessfulCheck() {
        //if caughtCheck is false then this means that the student is not caught and return true
        if (!caughtCheck()) {
            //cheaters win (for this round)
            return true;
        } else {
            //game over good bye
            return false;
        }
    }

    private void sendHomeSupervisor() {
        // if we are in the late game(i.e. last 100 ticks) and the course difficulty is hard or relatively hard and there are at least two supervisors
        //then delete at least one from the list of supervisors (check if he is a supervisor and not the professor)
        //if the professor is not super tensed or paranoid
        if (professorsAttitudeEnum.ordinal() <= 3) {
            if (roundNumber > 180) {
                //if the list of supervisors contains at least 3 elements then there are at least two supervisors
                if (listOfSupervisors.size() >= 3) {
                    //there is a 70% percent chance (TBD) where only two of the supervisors will stay
                    if (Math.random() < 0.7) {
                        int numberOfSupervisors = listOfSupervisors.size() - 1;
                        //the 2/3 of them go home
                        for (int i = 0; i < (int) (numberOfSupervisors * 2 / 3); i++) {
                            //TODO find a way to remove the items from the list
                        }

                    }
                }
            }
        }
    }

}