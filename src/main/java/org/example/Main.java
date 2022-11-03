package org.example;

import org.example.mdoel.dto.DecathlonPerformanceDTO;
import org.example.service.ReadDecathlonResultsService;
import org.example.util.DisplayUtils;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name. (If you have a result.csv file in the same location as the jar, you don't need to enter input.: ");
        String fileName = scanner.nextLine();

        if (fileName == null || "".equals(fileName)) {
            fileName = "results.csv";
        }

        ReadDecathlonResultsService readDecathlonResultsService = new ReadDecathlonResultsService();
        //Read decathlon results from csv file
        List<DecathlonPerformanceDTO> decathlonResults = readDecathlonResultsService.getDecathlonResults(fileName);
        //Show scoreboard
        DisplayUtils.writeToXml(decathlonResults);
    }
}
