package org.example.mdoel.enums;

public enum ScoringTable {

    ONE_HUNDRED_METRES(25.4347,18, 1.81),
    LONG_JUMP(0.14354, 220, 1.4),
    SHOT_PUT(51.39,1.5, 1.05),
    HIGH_JUMP(0.8465, 75, 1.42),
    FOUR_HUNDRED_METRES(1.53775, 82, 1.81),
    ONE_HUNDRED_TEN_METRES_HURDLES(5.74352, 28.5, 1.92),
    DISCUS_THROW(12.91, 4, 1.1),
    POLE_VAULT(0.2797, 100, 1.35),
    JAVELIN_THROW(10.14, 7, 1.08),
    ONE_THOUSAND_FIVE_HUNDRED_METRES(0.03768, 480, 1.85);

    private final double parameterA;
    private final double parameterB;
    private final double parameterC;

    ScoringTable(double parameterA, double parameterB, double parameterC) {
        this.parameterA = parameterA;
        this.parameterB = parameterB;
        this.parameterC = parameterC;
    }

    public double getParameterA() {
        return parameterA;
    }

    public double getParameterB() {
        return parameterB;
    }

    public double getParameterC() {
        return parameterC;
    }
}
