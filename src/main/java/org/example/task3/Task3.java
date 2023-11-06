package org.example.task3;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.task3.POJO.TestsPOJO;
import org.example.task3.POJO.ValuesPOJO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            System.out.println("Input path of tests json");
            Path filePath1 = Paths.get(new Scanner(System.in).nextLine());
            System.out.println("Input path of values json");
            Path filePath2 = Paths.get(new Scanner(System.in).nextLine());

            Map<String, List<TestsPOJO>> testsMap = objectMapper.readValue(new File(filePath1.toUri()), new TypeReference<Map<String, List<TestsPOJO>>>() {
            });
            Map<String, List<ValuesPOJO>> valuesMap = objectMapper.readValue(new File(filePath2.toUri()), new TypeReference<Map<String, List<ValuesPOJO>>>() {
            });
            List<TestsPOJO> testsPOJOS = testsMap.get("tests");
            List<ValuesPOJO> valuesPOJOS = valuesMap.get("values");

            setValues(testsPOJOS,valuesPOJOS);
            Map<String, List<TestsPOJO>> reportsMap = new HashMap<>();
            reportsMap.put("reports", testsPOJOS);


            objectMapper.writeValue(new File("reports.json"),reportsMap);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void setValues(List<TestsPOJO> testsPOJOS, List<ValuesPOJO> valuesPOJOS) {
        for (TestsPOJO testsPOJO : testsPOJOS) {
            for (int j = 0; j < valuesPOJOS.size(); j++) {
                if (testsPOJO.getValues() != null) {
                    List<TestsPOJO> testsPOJOS1 = Arrays.asList(testsPOJO.getValues());
                    setValues(testsPOJOS1, valuesPOJOS);
                }
                if (testsPOJO.getId() == valuesPOJOS.get(j).getId()) {
                    testsPOJO.setValue(valuesPOJOS.get(j).getValue());
                }
            }
        }
    }

}
