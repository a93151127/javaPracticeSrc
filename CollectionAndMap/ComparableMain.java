package CollectionAndMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableMain {
    public static void main(String[] args) {
        List<Account> list = Arrays.asList(
          new Account("a", 2),
          new Account("b", 1)
        );

        Collections.sort(list);
        list.forEach(System.out::println);
    }
}

class Account implements Comparable<Account>{
    private String name;
    private int num;

    public Account(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public int compareTo(Account other) {
        return this.num - other.num;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
