package com.assignment;

public class Position {
    private int posX, posY;
    private int dirX, dirY;
    Position(int posX, int posY, String dir) {
        this.posX = posX;
        this.posY = posY;
        setDirection(dir);
    }

    private void setDirection(String dir) {
        if (dir.equals("E")) {
            dirX = 1;
            dirY = 0;
        } else if (dir.equals("W")) {
            dirX = -1;
            dirY = 0;
        } else if (dir.equals("N")) {
            dirX = 0;
            dirY = 1;
        } else {
            dirX = 0;
            dirY = -1;
        }
    }

    public String getDirection() {
        if (dirX == 1 && dirY == 0) return "E";
        else if (dirX == -1 && dirY == 0) {
            return "W";
        } else if (dirX == 0 && dirY == 1) {
            return "N";
        } else {
            return "S";
        }
    }

    public void moove(){
        posX += dirX;
        posY += dirY;
    }

    public String currentPosition(){
        return String.valueOf(posX)+" "+String.valueOf(posY)+" "+getDirection();
    }
}
