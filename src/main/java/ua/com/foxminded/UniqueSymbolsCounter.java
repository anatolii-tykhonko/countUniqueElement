package ua.com.foxminded;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class UniqueSymbolsCounter {
    private static final Map<String, Map<Character, Integer>> cache = new HashMap<>();

    public String countNumberOfUniqueCharacters(String inputString) {
        if (validateDataAndCheckHash(inputString).isPresent()) {
            return formatStringResult(validateDataAndCheckHash(inputString).get());
        }
        Map<Character, Integer> uniqueCharsCounts = countUniqueCharacters(inputString);
        cache.put(inputString, uniqueCharsCounts);
        return formatStringResult(uniqueCharsCounts);
    }

    private Optional<Map<Character, Integer>> validateDataAndCheckHash(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("Null is wrong argument!");
        }
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException("Input is empty. String isn`t contains unique elements!");
        }
        if (cache.containsKey(inputString)) {
            return Optional.of(cache.get(inputString));
        }
        return Optional.empty();
    }

    private Map<Character, Integer> countUniqueCharacters(String inputString) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        inputString.chars().forEach(element -> result.merge((char)element, 1, Integer::sum));
        return result;
    }

    private String formatStringResult(Map<Character, Integer> result) {
        StringBuilder formatResult = new StringBuilder();
        result.forEach((key, value) -> formatResult.append(String.format("\"" + "%s" + "\" - " + "%d%n", key, value)));
        return formatResult.toString();
    }
}
