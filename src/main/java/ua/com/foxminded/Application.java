package ua.com.foxminded;

public class Application {
    public static void main(String[] args) {
        UniqueSymbolsCounter test = new UniqueSymbolsCounter();

        System.out.println(test.countNumberOfUniqueCharacters("hello world!"));
        System.out.println(test.countNumberOfUniqueCharacters("hello world!"));
        System.out.println(test.countNumberOfUniqueCharacters("New hello world!"));
        
    }
}
