package ua.com.foxminded;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterUniqueElementsInStringTest {
    CounterUniqueElementsInString test = new CounterUniqueElementsInString();

    @Test
    void throwIllegalArgumentExceptionWhenInputEmpty() {
        assertThrows(IllegalArgumentException.class, () -> test.countNumberOfUniqueCharactersInString(""));
    }

    @Test
    void throwIllegalArgumentExceptionWhenInputNull() {
        assertThrows(IllegalArgumentException.class, () -> test.countNumberOfUniqueCharactersInString(null));
    }

    @Test
    void returnOneWhenInputOneLetter() {
        String inputData = "a";
        String expected = String.format("\"a\" - 1%n");

        String result = test.countNumberOfUniqueCharactersInString(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnOneWhenInputOneDigit() {
        String inputData = "4";
        String expected = String.format("\"4\" - 1%n");

        String result = test.countNumberOfUniqueCharactersInString(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnOneWhenInputOneSpecialSymbol() {
        String inputData = "@";
        String expected = String.format("\"@\" - 1%n");

        String result = test.countNumberOfUniqueCharactersInString(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnOneWhenInputOneSpace(){
        String inputData = " ";
        String expected = String.format("\" \" - 1%n");

        String result = test.countNumberOfUniqueCharactersInString(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnOneWhenInputTwoSameLetters(){
        String inputData = "aa";
        String expected = String.format("\"a\" - 2%n");

        String result = test.countNumberOfUniqueCharactersInString(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnTwoWhenInputOneLetterAndOneSpace(){
        String inputData = "b ";
        String expected = String.format("\"b\" - 1%n" +
                                        "\" \" - 1%n");

        String result = test.countNumberOfUniqueCharactersInString(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnTwoWhenInputTwoDifferentLetter(){
        String inputData = "bc";
        String expected = String.format("\"b\" - 1%n" +
                                        "\"c\" - 1%n");

        String result = test.countNumberOfUniqueCharactersInString(inputData);

        assertEquals(expected, result);
    }

    @Test
    void returnTwoWhenInputTwoSameLettersUppercaseAndLowercase(){
        String inputData = "bB";
        String expected = String.format("\"b\" - 1%n" +
                                        "\"B\" - 1%n");

        String result = test.countNumberOfUniqueCharactersInString(inputData);

        assertEquals(expected, result);
    }

    @Test
    void testUsingHashWhenInputEqualsString(){
        String inputData = "sakfp fkdn q21e!mvkd>fkv fsdnoef  eifjoiwfkd ei3803)(01";
        long startTimeBeforeUseHash = System.currentTimeMillis();

        test.countNumberOfUniqueCharactersInString(inputData);
        long timeWorkMethodBeforeUseHash = System.currentTimeMillis() - startTimeBeforeUseHash;
        long startTimeUseHash = System.currentTimeMillis();
        test.countNumberOfUniqueCharactersInString(inputData);
        long timeWorkMethodUseHash = System.currentTimeMillis() - startTimeUseHash;

        assertTrue(timeWorkMethodUseHash < timeWorkMethodBeforeUseHash);

    }

}