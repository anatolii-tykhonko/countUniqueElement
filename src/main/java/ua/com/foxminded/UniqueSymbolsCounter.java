package ua.com.foxminded;


import java.util.*;

public class UniqueSymbolsCounter {
    private static final Map<String, Map<Character, Integer>> cashe = new HashMap<>();

    public String countNumberOfUniqueCharacters(String inputString) {
        if (validateDataAndCheckHash(inputString).isPresent()) {
            return formatStringResult(validateDataAndCheckHash(inputString).get());
        }
        Map<Character, Integer> uniqueCharsCounts = countUniqueCharacters(inputString);
        cashe.put(inputString, uniqueCharsCounts);
        return formatStringResult(uniqueCharsCounts);
    }

    private Optional<Map<Character, Integer>> validateDataAndCheckHash(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("Null is wrong argument!");
        }
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException("Input is empty. String isn`t contains unique elements!");
        }
        if (cashe.containsKey(inputString)) {
            return Optional.of(cashe.get(inputString));
        }
        return Optional.empty();
    }

    private Map<Character, Integer> countUniqueCharacters(String inputString) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        char[] elementsOfString = inputString.toCharArray();
        for (int i = 0; i < elementsOfString.length; i++) {
            result.merge(elementsOfString[i], 1, Integer::sum);
        }
//        List<String> elementsOfString = Arrays.asList(inputString.split(""));
//        elementsOfString.forEach(element -> result.merge(element, 1, (oldVal, newVal) -> oldVal + newVal));
        return result;
    }

    private String formatStringResult(Map<Character, Integer> result) {
        StringBuilder formatResult = new StringBuilder();
        result.forEach((key, value) -> formatResult.append(String.format("\"" + "%s" + "\" - " + "%d%n", key, value)));
        return formatResult.toString();
    }
}
