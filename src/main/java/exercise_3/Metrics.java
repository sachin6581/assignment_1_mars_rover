package exercise_3;

import java.util.Objects;

public class Metrics {
    Unit unit;
    double value;

    public Metrics(double magnitude, Unit c) {
        this.value = magnitude;
        this.unit = c;
    }

    public static Metrics celsius(double magnitude) {
        return new Metrics(magnitude, Unit.C);
    }

    public static Metrics fahrenheit(double magnitude) {
        return new Metrics(magnitude, Unit.F);
    }

    public static Measurement kilometers(double value) {
        return new Measurement(value, Unit.KM);
    }

    public static Measurement meters(double value) {
        return new Measurement(value, Unit.M);
    }

    public static Measurement centimeters(double value) {
        return new Measurement(value, Unit.CM);
    }

    public static Measurement millimeters(double value) {
        return new Measurement(value, Unit.MM);
    }

    public static Measurement kilograms(double value) {
        return new Measurement(value, Unit.KG);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Metrics otherMeasurement = (Metrics) obj;
        if (!unit.isCompatiableWith(otherMeasurement.unit)) {
            return false;
        }

        return this.unit.toStandard(this.value) == otherMeasurement.unit.toStandard(otherMeasurement.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(unit.convertToTargetUnit(value, Unit.C));
    }

    @Override
    public String toString() {
        return Double.toString(value) + unit;
    }
}
