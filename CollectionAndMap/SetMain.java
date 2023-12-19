package CollectionAndMap;

import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        String a = "apple";
        String b = "boy";
        String c = "cat";

        Set<String> set = new HashSet<>();
        set.add(a);
        set.add(a);
        set.add(a);

        set.forEach(System.out::println);
    }
}
