import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringProcessor {
    public static void processStrings(List<String> strings,
                                      Predicate<String> filter,
                                      Function<String, String> transformer,
                                      Consumer<String> printer) {
        strings.stream()
               .filter(filter)
               .map(transformer)
               .forEach(printer);
    }

    public static void main(String[] args) {
        List<String> words = List.of("Java", "Programchlal", "code");

        Predicate<String> filter = s -> s.length() > 5;
        Function<String, String> transformer = String::toUpperCase;
        Consumer<String> printer = s -> System.out.println("Garshil: " + s);

        processStrings(words, filter, transformer, printer);
    }
}
