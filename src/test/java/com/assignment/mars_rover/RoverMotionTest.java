package com.assignment.mars_rover;

import com.assignment.mars_rover.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverMotionTest {
    @Test
    void roverShouldMoveForward() {
        Rover rover = new Rover(1, 2, "N");
        String actualMovement = rover.moveRover("M");
        assertEquals("1 3 N", actualMovement);
    }

    @Test
    void roverShouldTurnLeft() {
        Rover rover = new Rover(1, 3, "E");
        String actualMovement = rover.moveRover("L");
        assertEquals("1 3 N", actualMovement);

    }

    @Test
    void roverShouldTurnRight() {
        Rover rover = new Rover(1, 3, "W");
        String actualMovement = rover.moveRover("R");
        assertEquals("1 3 N", actualMovement);
    }

    @Test
    void roverPositionShouldBe13N() {
        Rover rover = new Rover(1, 2, "N");
        String actualMovement = rover.moveRover("LMLMLMLMM");
        assertEquals("1 3 N", actualMovement);
    }

    @Test
    void roverPositionShouldBe51E() {
        Rover rover = new Rover(3, 3, "E");
        String actualMovement = rover.moveRover("MMRMMRMRRM");
        assertEquals("5 1 E", actualMovement);
    }

}
