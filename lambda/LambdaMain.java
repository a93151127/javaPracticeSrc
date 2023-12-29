package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaMain {
    public static void main(String[] args) {
        // java 8 以前寫法
        String[] strs = {"aa", "a", "aaaaa", "aaa"};

        Arrays.sort(strs, (s1, s2) -> SoretedTest.byLength(s1, s2));
        Arrays.stream(strs).forEach(System.out::println);

        // java 8 以後寫法(方法參考)
        // 寫法1
        String[] strs1 = {"bb", "b", "bbbbb", "bbb"};
        Arrays.sort(strs1, SoretedTest::byLength);
        Arrays.stream(strs1).forEach(System.out::println);

    }
}

class SoretedTest{
    public static int byLength(String s1, String s2){
        return s1.length() - s2.length();
    }
    public static int byLexicography(String s1, String s2){
        return s1.compareTo(s2);
    }

    public static int byLexicographyIgnoreCase(String s1, String s2){
        return s1.compareToIgnoreCase(s2);
    }
}
