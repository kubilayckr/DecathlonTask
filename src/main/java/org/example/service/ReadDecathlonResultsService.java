package org.example.service;

import org.example.mdoel.dto.DecathlonPerformanceDTO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDecathlonResultsService {

    public List<DecathlonPerformanceDTO> getDecathlonResults(String fileName) {
        List<DecathlonPerformanceDTO> decathlonPerformances = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] decathlonPerformanceInput = line.split(";");

                if ("".equals(line)) {
                    continue;
                } else if (decathlonPerformanceInput.length != 11) {
                    throw new RuntimeException("The result file contains missing information!");
                }

                DecathlonPerformanceDTO decathlonPerformance =
                        new DecathlonPerformanceDTO(
                                decathlonPerformanceInput[0],
                                Double.parseDouble(decathlonPerformanceInput[1]),
                                Double.parseDouble(decathlonPerformanceInput[2]),
                                Double.parseDouble(decathlonPerformanceInput[3]),
                                Double.parseDouble(decathlonPerformanceInput[4]),
                                Double.parseDouble(decathlonPerformanceInput[5]),
                                Double.parseDouble(decathlonPerformanceInput[6]),
                                Double.parseDouble(decathlonPerformanceInput[7]),
                                Double.parseDouble(decathlonPerformanceInput[8]),
                                Double.parseDouble(decathlonPerformanceInput[9]),
                                decathlonPerformanceInput[10]);

                decathlonPerformances.add(decathlonPerformance);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found!");
        }catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the file!");
        } catch (NumberFormatException e) {
            throw new RuntimeException("The result file contains incorrect information!");
        }

        return decathlonPerformances;
    }
}
