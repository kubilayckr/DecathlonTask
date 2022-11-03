package org.example.util;

import org.example.mdoel.dto.DecathlonPerformanceDTO;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;

class DisplayUtilsTest {

    @Test
    void display() {
        try (MockedStatic<CalculationUtils> calculationUtilsMockedStatic = Mockito.mockStatic(CalculationUtils.class)) {
            List<DecathlonPerformanceDTO> decathlonResults = new ArrayList<>();
            DecathlonPerformanceDTO decathlonPerformance = new DecathlonPerformanceDTO("Kevin Mayer", 10.55,
                    7.80, 16.00, 2.05, 48.42, 13.75, 50.54,
                    5.45, 71.90, "4:36.11");
            decathlonResults.add(decathlonPerformance);
            DisplayUtils.writeToXml(decathlonResults);
            calculationUtilsMockedStatic.verify(() -> CalculationUtils.getTotalPoint(decathlonPerformance), times(1));
        }
    }
}