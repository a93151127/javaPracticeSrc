package lambda;

import java.util.Map;
import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        System.out.println(getNumber("boy"));
        System.out.println(getNumber("Martin"));

    }

    static Optional<String> getNumber(String name){
        Map<String, String> map = Map.of(
                "Martin", "1",
                "Abigail", "2",
                "Welson", "3"
        );
        String number = map.get(name);
        return Optional.ofNullable(map.get(name));
    }
}
