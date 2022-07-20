package com.assignment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverMotionTest {

    @Test
    @DisplayName("Rover should moove forward")
    void forward_movement() {
        assertEquals("1 3 N", new Rover(1, 2, "N").mooveRover("M"));
    }

    @Test
    @DisplayName("Rover should turn left")
    void should_turn_left() {
        assertEquals("1 3 N", new Rover(1, 3, "E").mooveRover("L"));

    }

    @Test
    @DisplayName("Rover should turn right")
    void should_turn_right() {
        assertEquals("1 3 N", new Rover(1, 3, "W").mooveRover("R"));
    }

    @Test
    @DisplayName("Test Case 1")
    void should_be_1_3_N() {
        assertEquals("1 3 N", new Rover(1, 2, "N").mooveRover("LMLMLMLMM"));
    }

    @Test
    @DisplayName("Test Case 2")
    void should_be_5_1_E() {
        assertEquals("5 1 E", new Rover(3, 3, "E").mooveRover("MMRMMRMRRM"));
    }

}
