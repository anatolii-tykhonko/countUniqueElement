package ua.com.foxminded;

import java.util.*;

public class CounterUniqueElementsInString {
    private static Map<String, Map<String, Integer>> hashPreviousResult = new HashMap<>();

    public String countNumberOfUniqueCharactersInString(String inputString) {
        if (validateDataAndCheckHash(inputString).isPresent()) {
            return formatStringResult(validateDataAndCheckHash(inputString).get());
        }
        Map<String, Integer> uniqueCharAndNumberRepeat = countUniqueCharacters(inputString);
        hashPreviousResult.put(inputString, uniqueCharAndNumberRepeat);
        return formatStringResult(uniqueCharAndNumberRepeat);
    }

    private Optional<Map<String, Integer>> validateDataAndCheckHash(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("Null is wrong argument!");
        }
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException("Input is empty. String isn`t contains unique elements!");
        }
        if (hashPreviousResult.containsKey(inputString)) {
            return Optional.of(hashPreviousResult.get(inputString));
        }
        return Optional.empty();
    }

    private Map<String, Integer> countUniqueCharacters(String inputString) {
        Map<String, Integer> result = new LinkedHashMap<>();
        String[] elementsOfString = inputString.split("");
        for (int i = 0; i < elementsOfString.length; i++) {
            if (result.containsKey(elementsOfString[i])) {
                int value = result.get(elementsOfString[i]);
                value++;
                result.put(elementsOfString[i], value);
            } else {
                result.put(elementsOfString[i], 1);
            }
        }
        return result;
    }

    private String formatStringResult(Map<String, Integer> result) {
        StringBuilder formatResult = new StringBuilder();
        result.forEach((key, value) -> formatResult.append(String.format("\"" + "%s" + "\" - " + "%d%n", key, value)));
        return formatResult.toString();
    }
}
