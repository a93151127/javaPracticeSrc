package CollectionAndMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        // null 要排在最前面, 然後字數多的在前面
        List<String> list = Arrays.asList("aaa", null, "a", "aaaaa", null, "aa", null);
        list.sort(Comparator.nullsFirst(Comparator.reverseOrder()));
        list.forEach(System.out::println);

    }
}

