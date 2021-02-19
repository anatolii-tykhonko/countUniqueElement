package ua.com.foxminded;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueSymbolsCounterTest {
    UniqueSymbolsCounter test = new UniqueSymbolsCounter();

    @Test
    void throwIllegalArgumentExceptionWhenInputEmpty() {
        assertThrows(IllegalArgumentException.class, () -> test.countNumberOfUniqueCharacters(""));
    }

    @Test
    void throwIllegalArgumentExceptionWhenInputNull() {
        assertThrows(IllegalArgumentException.class, () -> test.countNumberOfUniqueCharacters(null));
    }

    @Test
    void returnOneWhenInputOneLetter() {
        String inputData = "a";
        String expected = String.format("\"a\" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnOneWhenInputOneDigit() {
        String inputData = "4";
        String expected = String.format("\"4\" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnOneWhenInputOneSpecialSymbol() {
        String inputData = "@";
        String expected = String.format("\"@\" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnOneWhenInputOneSpace(){
        String inputData = " ";
        String expected = String.format("\" \" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnOneWhenInputTwoSameLetters(){
        String inputData = "aa";
        String expected = String.format("\"a\" - 2%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnTwoWhenInputOneLetterAndOneSpace(){
        String inputData = "b ";
        String expected = String.format("\"b\" - 1%n" +
                                        "\" \" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnTwoWhenInputTwoDifferentLetter(){
        String inputData = "bc";
        String expected = String.format("\"b\" - 1%n" +
                                        "\"c\" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnTwoWhenInputTwoSameLettersUppercaseAndLowercase(){
        String inputData = "bB";
        String expected = String.format("\"b\" - 1%n" +
                                        "\"B\" - 1%n");

        String result = test.countNumberOfUniqueCharacters(inputData);

        assertEquals(expected, result);
    }

    @Test
    void testUsingHashWhenInputEqualsString(){
        String inputData = "sakfp fkdn q21e!mvkd>fkv fsdnoef  eifjoiwfkd ei3803)(01";
        long startTimeBeforeUseHash = System.currentTimeMillis();

        test.countNumberOfUniqueCharacters(inputData);
        long timeWorkMethodBeforeUseHash = System.currentTimeMillis() - startTimeBeforeUseHash;
        long startTimeUseHash = System.currentTimeMillis();
        test.countNumberOfUniqueCharacters(inputData);
        long timeWorkMethodUseHash = System.currentTimeMillis() - startTimeUseHash;

        assertTrue(timeWorkMethodUseHash < timeWorkMethodBeforeUseHash);

    }

}