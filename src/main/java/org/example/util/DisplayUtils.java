package org.example.util;

import org.example.mdoel.dto.DecathlonPerformanceDTO;
import org.example.mdoel.dto.ResultDTO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DisplayUtils {

    public static final String xmlFilePath = "results.xml";

    private DisplayUtils() {
    }

    public static void writeToXml(List<DecathlonPerformanceDTO> decathlonResults) {
        Map<Integer, List<String>> results = decathlonResults.stream()
                .map(r -> new ResultDTO(r.getAthleteName(), CalculationUtils.getTotalPoint(r)))
                .collect(Collectors.groupingBy(ResultDTO::getTotalPoint, Collectors.mapping(ResultDTO::getAthleteName, Collectors.toList())));

        List<Integer> orderedPoints = results.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element resultsTag = document.createElement("Results");
            document.appendChild(resultsTag);

            int defaultPosition = 1;
            for (Integer point : orderedPoints) {
                List<String> athletes = results.get(point);
                StringBuilder position = new StringBuilder();
                for (int i = athletes.size(); i > 0; i--) {
                    position.append(defaultPosition);
                    if (i != 1) {
                        position.append(" - ");
                        defaultPosition++;
                    }
                }
                String finalPosition = position.toString();
                athletes.forEach(name -> {
                    Element placementTag = document.createElement("Placement");
                    resultsTag.appendChild(placementTag);

                    Element placeTag = document.createElement("Place");
                    placeTag.appendChild(document.createTextNode(finalPosition));
                    placementTag.appendChild(placeTag);

                    Element athleteNameTag = document.createElement("AthleteName");
                    athleteNameTag.appendChild(document.createTextNode(name));
                    placementTag.appendChild(athleteNameTag);

                    Element pointTag = document.createElement("Point");
                    pointTag.appendChild(document.createTextNode(String.valueOf(point)));
                    placementTag.appendChild(pointTag);
                });

                defaultPosition++;
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }
}
