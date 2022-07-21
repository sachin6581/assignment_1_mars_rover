package exercise_3;

public class Measurement extends Metrics {

    public Measurement(double value, Unit unit) {
        super(value, unit);
        this.value = value;
        this.unit = unit;
    }

    public Measurement add(Measurement measurement) throws DifferentUnitException {
        if (!this.unit.isCompatiableWith(measurement.unit)) {
            throw new DifferentUnitException("Incomparable units: " + this.unit + " cannot be added with " + measurement.unit);
        }
        double valueSum = measurement.unit.convertToTargetUnit(measurement.value, this.unit) + this.value;
        return new Measurement(valueSum, this.unit);
    }
}
