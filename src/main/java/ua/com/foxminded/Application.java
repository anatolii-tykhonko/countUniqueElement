package ua.com.foxminded;

public class Application {
    public static void main(String[] args) {
        CounterUniqueElementsInString test = new CounterUniqueElementsInString();

        System.out.println(test.countNumberOfUniqueCharactersInString("hello world!"));
        System.out.println(test.countNumberOfUniqueCharactersInString("hello world!"));
        System.out.println(test.countNumberOfUniqueCharactersInString("New hello world!"));
    }
}
