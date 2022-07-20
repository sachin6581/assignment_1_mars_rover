package com.assignment;

public class Rover {

    private final Position roverPosition;

    Rover(int positionX, int positionY, String direction) {
        this.roverPosition = new Position(positionX, positionY, direction);
    }

    public String moveRover(String motion) {
        roverPosition.setDirection();
        for (char nextStep : motion.toCharArray()) {
            if (nextStep == 'M') {
                roverPosition.move();
            } else if (nextStep == 'L') {
                roverPosition.moveLeft();
            } else if (nextStep == 'R') {
                roverPosition.moveRight();
            }
        }
        return roverPosition.currentPosition();
    }

}
