package com.game;

import static com.Main.listOfColumns;
import static com.Main.listOfMaliciousStudents;
import static com.Main.listOfSupervisors;
import static com.Main.professorsAttitudeEnum;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

import com.entitities.Column;
import com.entitities.Room;
import com.entitities.Student;
import com.entitities.Supervisor;

public class Game {
    public static boolean maliciousStudentCaught = false;
    static int roundNumber;
    static final int numberOfRounds = 360;

    public static boolean isMaliciousStudentCaught() {
        return maliciousStudentCaught;
    }

    public static int getRoundNumber() {
        return roundNumber;
    }

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

    public HashMap<Point2D, Boolean> endOfGame() {
        HashMap<Point2D, Boolean> listToExport = new HashMap<>();
        for (Student student : listOfMaliciousStudents) {
            Point2D point2D = new Point2D.Double(student.getRow(), student.getCol());
            listToExport.put(point2D, student.isCaught());
        }
        return listToExport;
    }

    public boolean isOn() {
        return roundNumber < numberOfRounds;
    }

    private void moveSupervisors() {
        for (Supervisor supervisor : listOfSupervisors) {
            supervisor.roundMove();
        }
    }

    private void studentsCheat() {
        for (Student student : listOfMaliciousStudents) {
            student.cheat();
        }
    }

    private void visionCheck() {
        Object[][] room = Room.getRoom();
        //based on the position calculate the circle that a supervisor can catch a student
        for (Supervisor supervisor : listOfSupervisors) {
            ArrayList<Point2D> pointsInTheCircle = new ArrayList<>();
            double radius = supervisor.getAwareness();
            //Step 1
            for (int row = 0; row < room.length; row++) {
                for (int col = 0; col < room[row].length; col++) {
                    int centreX = row - supervisor.getRow();
                    int centreY = col - supervisor.getCol();
                    if ((centreX * centreX) + (centreY * centreY) <= (radius * radius)) {
                        Point2D point2D = new Point2D.Double(row, col);
                        pointsInTheCircle.add(point2D);
                    }
                }
            }
            //STEP 2 : Iterate over the columns and add to a list the left or right elements or top left top rights elements up to awareness radius to a list
            for (Column column : listOfColumns) {

            }
            //STEP 3 : Remove said items from original list
            //STEP 4 : Remove columns from a list
            //The remaining elements are those that are visible to the supervisor
            //If a student is inside those elements and he is cheating he is caught

        }
    }

    private boolean caughtCheck() {
        return maliciousStudentCaught;
    }

    private boolean cheatSuccessfulCheck() {
        //if caughtCheck is false then this means that the student is not caught and return true
        //cheaters win (for this round)
        //game over good bye
        return !caughtCheck();
    }

    private void sendHomeSupervisor() {
        // if we are in the late game(i.e. last 100 ticks) and the course difficulty is hard or relatively hard and there are at least two supervisors
        //then delete at least one from the list of supervisors (check if he is a supervisor and not the professor)
        //if the professor is not super tensed or paranoid
        if (professorsAttitudeEnum.ordinal() <= 2) {
            if (roundNumber > numberOfRounds - 100) {
                //if the list of supervisors contains at least 3 elements (i.e there are at least two supervisors)
                if (listOfSupervisors.size() >= 3) {
                    //there is a 70% percent chance (TBD) where only two of the supervisors will stay
                    if (Math.random() < 0.7) {
                        int numberOfSupervisors = listOfSupervisors.size() - 1;
                        //the 2/3 of them go home
                        int peopleToSendHome = (int) ((2.0 / 3.0) * numberOfSupervisors);
                        while (peopleToSendHome > 0) {
                            int rando = (int) (Math.random() * listOfSupervisors.size());
                            if (listOfSupervisors.get(rando).getClass().getCanonicalName().equals("com.entitities.Supervisor")) {
                                listOfSupervisors.remove(rando);
                                peopleToSendHome -= 1;
                            }
                        }
                    }
                }
            }
        }
    }

}