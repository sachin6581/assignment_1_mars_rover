package com.assignment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverMotionTest {

    @Test
    @DisplayName("Rover should moove forward")
    void forward_movement(){
        assertEquals("1 3 N",new Rover(1,2,"N").mooveRover("M"));
    }

}
