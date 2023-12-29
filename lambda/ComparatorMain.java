package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorMain {
    public static void main(String[] args) {
        // 寫法1
        String[] strs = {"aa", "a", "aaaaa", "aaa"};
        Comparator<String> com = (s1, s2) -> s1.length() - s2.length();
        Arrays.sort(strs, com);
        Arrays.stream(strs).forEach(System.out::println);

        // 寫法2
        String[] strs1 = {"bb", "b", "bbbbb", "bbb"};
        Comparator<String> com1 = SortedComparator::sort;
        Arrays.sort(strs1, com1);
        Arrays.stream(strs1).forEach(System.out::println);

        // 寫法3
        String[] strs2 = {"cc", "c", "ccccc", "ccc"};
        Arrays.sort(strs2, SortedComparator::sort);
        Arrays.stream(strs2).forEach(System.out::println);
    }
}

class SortedComparator{
    public static int sort(String s1, String s2){
        return s1.length() - s2.length();
    }
}
