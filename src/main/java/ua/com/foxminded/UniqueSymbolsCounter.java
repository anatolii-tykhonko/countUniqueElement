package ua.com.foxminded;



import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueSymbolsCounter {
    private static final Map<String, Map<Character, Integer>> cache = new HashMap<>();

    public String countNumberOfUniqueCharacters(String inputString) {
        validateData(inputString);
        if(cache.containsKey(inputString)){
           return formatStringResult(cache.get(inputString));
        }
        Map<Character, Integer> uniqueCharsCounts = countUniqueCharacters(inputString);
        cache.put(inputString, uniqueCharsCounts);
        return formatStringResult(uniqueCharsCounts);
    }

    private void validateData(String inputString) {
        if(inputString == null){
            throw new IllegalArgumentException("Null is wrong argument!");
        }
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
