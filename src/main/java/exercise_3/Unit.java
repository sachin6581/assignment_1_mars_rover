package exercise_3;

public enum Unit {
    MM(Constants.MILLI_TO_MILLI, Type.LENGTH), CM(Constants.CENTI_TO_MILLI, Type.LENGTH), M(Constants.ST_TO_MILLI, Type.LENGTH), KM(Constants.KILO_TO_MILLI, Type.LENGTH),

    KG(Constants.KILO_TO_MILLI, Type.WEIGHT),

    F(5 / 9.0, -320 / 18.0, Type.TEMPERATURE), C(1, Type.TEMPERATURE), K(1, -273.15, Type.TEMPERATURE);

    private static class Constants {
        public static final double MILLI_TO_MILLI = 1;
        public static final double CENTI_TO_MILLI = 10;
        public static final double ST_TO_MILLI = 1000;
        private final static double KILO_TO_MILLI = 1000000;
    }

    public enum Type {
        WEIGHT, LENGTH, TEMPERATURE
    }

    private final double factor;
    private final double constant;
    private final Type type;

    Unit(double factor, Type type) {
        this(factor, 0, type);
    }

    Unit(double factor, double constant, Type type) {
        this.factor = factor;
        this.constant = constant;
        this.type = type;
    }

    public double toStandard(double magnitude) {
        return magnitude * factor + constant;
    }

    public double convertToTargetUnit(double magnitude, Unit target) {
        return (magnitude * factor) / target.factor + (constant - target.constant) / target.factor;
    }

    public boolean isCompatiableWith(Unit otherUnit) {
        return type == otherUnit.type;
    }
}
