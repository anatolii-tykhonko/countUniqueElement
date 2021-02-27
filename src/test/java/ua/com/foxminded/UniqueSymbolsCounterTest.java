package ua.com.foxminded;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueSymbolsCounterTest {
    UniqueSymbolsCounter test = new UniqueSymbolsCounter();


    @Test
    void countNumberOfUniqueCharactersThrowIllegalArgumentExceptionWhenInputNull() {
        assertThrows(IllegalArgumentException.class, () -> test.countNumberOfUniqueCharacters(null));
    }

    @Test
    void countNumberOfUniqueCharactersReturnOneWhenInputOneLetter() {
        String inputData = "a";
        String expected = String.format("\"a\" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void countNumberOfUniqueCharactersReturnOneWhenInputOneDigit() {
        String inputData = "4";
        String expected = String.format("\"4\" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void countNumberOfUniqueCharactersReturnTwoLinesWhenInputTwoDifferentDigits() {
        String inputData = "4884";
        String expected = String.format("\"4\" - 2%n"+
                                        "\"8\" - 2%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void countNumberOfUniqueCharactersReturnOneWhenInputOneSpecialSymbol() {
        String inputData = "@";
        String expected = String.format("\"@\" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void countNumberOfUniqueCharactersReturnOneWhenInputOneSpace(){
        String inputData = " ";
        String expected = String.format("\" \" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void countNumberOfUniqueCharactersReturnOneWhenInputTwoSameLetters(){
        String inputData = "aa";
        String expected = String.format("\"a\" - 2%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void countNumberOfUniqueCharactersReturnTwoWhenInputOneLetterAndOneSpace(){
        String inputData = "b ";
        String expected = String.format("\"b\" - 1%n" +
                                        "\" \" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void countNumberOfUniqueCharactersReturnTwoWhenInputTwoDifferentLetter(){
        String inputData = "bc";
        String expected = String.format("\"b\" - 1%n" +
                                        "\"c\" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void countNumberOfUniqueCharactersReturnTwoWhenInputTwoSameLettersUppercaseAndLowercase(){
        String inputData = "bB";
        String expected = String.format("\"b\" - 1%n" +
                                        "\"B\" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void countNumberOfUniqueCharactersTestUsingCacheWhenInputEqualsString(){
        String inputData = "bigBadaBoom";

        String result = test.countNumberOfUniqueCharacters(inputData);
        String resultWithCache = test.countNumberOfUniqueCharacters(inputData);

        assertSame(resultWithCache, result);
    }

}