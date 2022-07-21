package exercise_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static exercise_3.Measurement.*;
import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {
    @Nested
    class Distance {
        @Test
        void expectTrueWhen_1km_Is_1km() {
            Measurement distance = kilometers(1);
            Measurement otherDistance = kilometers(1);
            assertEquals(distance, otherDistance);
        }

        @Test
        void expectTrueWhen_1km_Is_1000m() {
            Measurement distance = kilometers(1);
            Measurement otherDistance = meters(1000);
            assertEquals(distance, otherDistance);
        }

        @Test
        void expectTrueWhen_1km_Is_100000cm() {
            Measurement distance = kilometers(1);
            Measurement otherDistance = centimeters(100000);
            assertEquals(distance, otherDistance);
        }

        @Test
        void expectTrueWhen_1m_Is_1000mm() {
            Measurement distance = meters(1);
            Measurement otherDistance = millimeters(1000);
            assertEquals(distance, otherDistance);
        }

        @Test
        void expect_2km_WhenAdding_1km_1km() throws DifferentUnitException {
            Measurement distance = kilometers(1);
            Measurement anotherDistance = kilometers(1);
            Assertions.assertEquals(kilometers(2), distance.add(anotherDistance));
        }

        @Test
        void expect_2km_WhenAdding_1km_1000m() throws DifferentUnitException {
            Measurement distance = kilometers(1);
            Measurement anotherDistance = meters(1000);
            Assertions.assertEquals(kilometers(2), distance.add(anotherDistance));
        }

        @Test
        void dontExpect_101m_WhenAdding_1km_10m() throws DifferentUnitException {
            Measurement distance = kilometers(1);
            Measurement anotherDistance = meters(10);
            assertNotEquals(meters(1.01), distance.add(anotherDistance));
        }

        @Test
        @DisplayName("Check Hash")
        void expectSameHashWhen_1km_Is_1000m() {
            Measurement distance = kilometers(1);
            Measurement anotherDistance = meters(1000);
            assertEquals(distance.hashCode(), anotherDistance.hashCode());
        }

        @Test
        void expectFail_11m_WhenAdding_10m_100cm() throws DifferentUnitException {
            Assertions.assertEquals(meters(11), meters(10).add(centimeters(100)));
        }

        @Test
        void expectFail_1100cm_WhenAdding_10m_100cm() throws DifferentUnitException {
            assertNotEquals(centimeters(1100).toString(), meters(10).add(centimeters(100)).toString());
        }
    }

    @Nested
    class Weight {
        @Test
        void expect_1Kg_when_1Kg() {
            assertEquals(kilograms(1), (kilograms(1)));
        }

        @Test
        void do_not_expect_1Kg_when_1Km() {
            assertNotEquals(kilograms(1), kilometers(1));
        }
    }

    @Nested
    class Temperature {
        @Test
        void expect100C_Equals_212F() {
            assertEquals(celsius(100), fahrenheit(212));
        }
    }

    @Test
    void cannotAdd1KG_with_2KM() {
        assertThrows(DifferentUnitException.class, () -> {
            kilograms(1).add(kilometers(2));
        });
    }

    /*@Test
    void cannotAdd1C_with_1C() throws DifferentUnitException {
        assertEquals(celsius(2).toString(),
           celsius(1).add(celsius(2)).toString());
    }*/
}