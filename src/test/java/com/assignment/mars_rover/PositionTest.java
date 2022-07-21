package com.assignment.mars_rover;

import com.assignment.mars_rover.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    @Test
    void positionShouldBe12N() {
        Position position = new Position(1, 2, "N");
        position.setDirection();
        assertEquals("1 2 N", position.currentPosition());
    }
}
