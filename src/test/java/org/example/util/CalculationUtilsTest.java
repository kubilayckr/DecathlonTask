package org.example.util;

import org.example.mdoel.dto.DecathlonPerformanceDTO;
import org.example.mdoel.enums.ScoringTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationUtilsTest {

    @Test
    void test_getTotalTrackEventsPoint() {
        DecathlonPerformanceDTO decathlonPerformance = new DecathlonPerformanceDTO("Kevin Mayer", 10.55,
                7.80, 16.00, 2.05, 48.42, 13.75, 50.54,
                5.45, 71.90, "4:36.11");
        assertEquals(9126, CalculationUtils.getTotalPoint(decathlonPerformance));
    }

    @Test
    void test_calculateTrackEventPoint() {
        ScoringTable scoringTable = ScoringTable.ONE_HUNDRED_METRES;
        int expected = (int) (scoringTable.getParameterA()
                * Math.pow((scoringTable.getParameterB() - 100.0), scoringTable.getParameterC()));
        assertEquals(expected, CalculationUtils.calculateTrackEventPoint(ScoringTable.ONE_HUNDRED_METRES, 100.0));
    }

    @Test
    void test_calculateFieldEventPoint() {
        ScoringTable scoringTable = ScoringTable.LONG_JUMP;
        int expected = (int) (scoringTable.getParameterA()
                * Math.pow((100.0 - scoringTable.getParameterB()), scoringTable.getParameterC()));
        assertEquals(expected, CalculationUtils.calculateFieldEventPoint(ScoringTable.LONG_JUMP, 100.0));

    }

    @Test
    void test_convertTimeMinuteAndSecondToTimeSecond() {
        assertEquals(3 * 60 + 14.1, CalculationUtils.convertTimeMinuteAndSecondToTimeSecond("3:14.1"));
    }

    @Test
    void test_convertMeterToCentimeter() {
        assertEquals(500.0, CalculationUtils.convertMeterToCentimeter(5.00));
    }
}