package lambda;

import java.util.Arrays;

public class ParallelArrayMain {
    public static void main(String[] args) {
        // parallelPrefix
        int[] arrs = {1, 2, 3, 4, 5};
        Arrays.parallelPrefix(arrs, (left, right) -> left + right);
        Arrays.stream(arrs).forEach(System.out::println);


        // parallelSetAll
        Arrays.parallelSetAll(arrs, index -> +2);
        System.out.println(arrs[0]);

    }
}
