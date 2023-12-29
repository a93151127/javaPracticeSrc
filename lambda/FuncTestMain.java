package lambda;

import java.util.Arrays;

public class FuncTestMain {
    public static void main(String[] args) {
        Func<String, Integer> func = (name1, name2) -> name1.length() - name2.length();

        String[] strs = {"aa", "a", "aaaaa", "aaa"};
        int result = func.test(strs[0], strs[1]);
        System.out.println("result : " + result);

        FuncVoid f = () -> System.out.println("abcd");
        f.print();

        FuncVoid1 f1 = s -> System.out.println(s);
        f1.print("fff222");
    }
}

interface Func<P, R> {
    R test(P name1, P name2);
}

interface FuncVoid{
    void print();
}

interface FuncVoid1{
    void print(String s);
}
