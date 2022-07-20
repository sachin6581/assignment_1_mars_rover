package com.assignment;

public class Position {
    private int positionX, positionY;
    private int directionX, directionY;
    private final String direction;

    Position(int posX, int posY, String dir) {
        this.positionX = posX;
        this.positionY = posY;
        this.direction = dir;
    }

    public void setDirection() {
        switch (direction) {
            case "E" -> {
                directionX = 1;
                directionY = 0;
            }
            case "W" -> {
                directionX = -1;
                directionY = 0;
            }
            case "N" -> {
                directionX = 0;
                directionY = 1;
            }
            default -> {
                directionX = 0;
                directionY = -1;
            }
        }
    }

    public String getDirection() {
        if (directionX == 1 && directionY == 0) return "E";
        else if (directionX == -1 && directionY == 0) {
            return "W";
        } else if (directionX == 0 && directionY == 1) {
            return "N";
        }

        return "S";
    }

    public void move() {
        positionX += directionX;
        positionY += directionY;
    }

    public void moveLeft() {
        switch (getDirection()) {
            case "E":
                directionX = 0;
                directionY = 1;
                break;
            case "W":
                directionX = 0;
                directionY = -1;
                break;
            case "N":
                directionX = -1;
                directionY = 0;
                break;
            case "S":
                directionX = 1;
                directionY = 0;
                break;
        }
    }

    public void moveRight() {
        switch (getDirection()) {
            case "E":
                directionX = 0;
                directionY = -1;
                break;
            case "W":
                directionX = 0;
                directionY = 1;
                break;
            case "N":
                directionX = 1;
                directionY = 0;
                break;
            case "S":
                directionX = -1;
                directionY = 0;
                break;
        }
    }

    public String currentPosition() {
        return String.valueOf(positionX) + " " + String.valueOf(positionY) + " " + getDirection();
    }
}
