package exercise_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void convertToStandardUnitTest() {
        assertEquals(10, Unit.CM.convertToTargetUnit(1, Unit.MM));
    }

    @Test
    void convertToGivenUnitTest() {
        assertEquals(1, Unit.MM.convertToTargetUnit(10, Unit.CM));
    }

    @Test
    void convert10C_To_F() {
        assertEquals(50, Unit.C.convertToTargetUnit(10, Unit.F));
    }

    @Test
    void shouldReturnTrueWhenSameType() {
        assertTrue(Unit.KM.isCompatiableWith(Unit.MM));
    }

    @Test
    void shouldReturnFalseWhenDifferentType() {
        assertFalse(Unit.KM.isCompatiableWith(Unit.KG));
    }
}