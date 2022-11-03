package org.example.util;

import org.example.mdoel.dto.DecathlonPerformanceDTO;
import org.example.mdoel.enums.ScoringTable;

public class CalculationUtils {

    private CalculationUtils() {
    }

    public static int getTotalPoint(DecathlonPerformanceDTO decathlonPerformance) {
        int totalPoint = 0;
        totalPoint += calculateTrackEventPoint(ScoringTable.ONE_HUNDRED_METRES, decathlonPerformance.getOneHundredMetres());
        totalPoint += calculateFieldEventPoint(ScoringTable.LONG_JUMP, convertMeterToCentimeter(decathlonPerformance.getLongJump()));
        totalPoint += calculateFieldEventPoint(ScoringTable.SHOT_PUT, decathlonPerformance.getShotPut());
        totalPoint += calculateFieldEventPoint(ScoringTable.HIGH_JUMP, convertMeterToCentimeter(decathlonPerformance.getHighJump()));
        totalPoint += calculateTrackEventPoint(ScoringTable.FOUR_HUNDRED_METRES, decathlonPerformance.getFourHundredMetres());
        totalPoint += calculateTrackEventPoint(ScoringTable.ONE_HUNDRED_TEN_METRES_HURDLES,
                decathlonPerformance.getOneHundredTenMetresHurdles());
        totalPoint += calculateFieldEventPoint(ScoringTable.DISCUS_THROW, decathlonPerformance.getDiscusThrow());
        totalPoint += calculateFieldEventPoint(ScoringTable.POLE_VAULT, convertMeterToCentimeter(decathlonPerformance.getPoleVault()));
        totalPoint += calculateFieldEventPoint(ScoringTable.JAVELIN_THROW, decathlonPerformance.getJavelinThrow());
        totalPoint += calculateTrackEventPoint(ScoringTable.ONE_THOUSAND_FIVE_HUNDRED_METRES,
                convertTimeMinuteAndSecondToTimeSecond(decathlonPerformance.getOneThousandFiveHundredMetres()));
        return totalPoint;
    }

    public static int calculateTrackEventPoint(ScoringTable scoringTable, Double performance) {
        // Formula is INT(A(B — P)^C) for track events
        return (int) (scoringTable.getParameterA()
                * Math.pow((scoringTable.getParameterB() - performance), scoringTable.getParameterC()));
    }

    public static int calculateFieldEventPoint(ScoringTable scoringTable, Double performance) {
        // Formula is INT(A(P — B)^C) for field events
        return (int) (scoringTable.getParameterA()
                * Math.pow((performance - scoringTable.getParameterB()), scoringTable.getParameterC()));
    }

    public static double convertTimeMinuteAndSecondToTimeSecond(String timeMinuteANDSecond) {
        String[] time = timeMinuteANDSecond.split(":");
        return Double.parseDouble(time[0]) * 60 + Double.parseDouble(time[1]);
    }

    public static double convertMeterToCentimeter(double meter) {
        return meter * 100;
    }
}
