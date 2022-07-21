package exercise_3;

import java.util.Objects;

public class Measurement {
    private Unit unit;
    private double value;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Measurement add(Measurement measurement) throws DifferentUnitException {
        if(!this.unit.isCompatiableWith(measurement.unit)){
            throw new DifferentUnitException("Incomparable units: " + this.unit + " cannot be added with " + measurement.unit);
        }
        double valueSum = measurement.unit.convertToTargetUnit(measurement.value, this.unit) + this.value;
        return new Measurement(valueSum, this.unit);
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

        Measurement otherMeasurement = (Measurement) obj;
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

    public static Measurement celsius(double magnitude) {
        return new Measurement(magnitude, Unit.C);
    }

    public static Measurement fahrenheit(double magnitude) {
        return new Measurement(magnitude, Unit.F);
    }
}
