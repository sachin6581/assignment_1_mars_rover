package com.assignment;

public class Rover {

    private final Position roverPosition;

    Rover(int posX, int posY, String dir) {
        this.roverPosition = new Position(posX, posY, dir);
    }

    public String mooveRover(String motion) {

        for (char nextStep : motion.toCharArray()) {
            if (nextStep == 'M') {
                roverPosition.moove();
            } else if (nextStep == 'L') {
                roverPosition.mooveLeft();
            } else if (nextStep == 'R') {
                roverPosition.mooveRight();
            }
        }
        return roverPosition.currentPosition();
    }

}
