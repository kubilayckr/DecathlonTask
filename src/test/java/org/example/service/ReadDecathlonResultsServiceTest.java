package org.example.service;

import org.example.mdoel.dto.DecathlonPerformanceDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReadDecathlonResultsServiceTest {

    private ReadDecathlonResultsService readDecathlonResultsService;

    @BeforeEach
    void init() {
        readDecathlonResultsService = new ReadDecathlonResultsService();
    }

    @Test
    void test_getDecathlonResults() {
        List<DecathlonPerformanceDTO> decathlonResults = readDecathlonResultsService.getDecathlonResults("src/test/resources/results.csv");
        assertEquals(6, decathlonResults.size());
    }

    @Test
    void test_getDecathlonResults_FileNotFoundException() {
        Exception exception = assertThrows(RuntimeException.class, () -> readDecathlonResultsService.getDecathlonResults("src/test/resources/results.csv2"));
        assertEquals("File not found!", exception.getMessage());
    }

    @Test
    void test_getDecathlonResults_WrongPatternException() {
        Exception exception = assertThrows(RuntimeException.class, () -> readDecathlonResultsService.getDecathlonResults("src/test/resources/results2.csv"));
        assertEquals("The result file contains missing information!", exception.getMessage());
    }

    @Test
    void test_getDecathlonResults_NumberFormatException() {
        Exception exception = assertThrows(RuntimeException.class, () -> readDecathlonResultsService.getDecathlonResults("src/test/resources/results3.csv"));
        assertEquals("The result file contains incorrect information!", exception.getMessage());
    }
}