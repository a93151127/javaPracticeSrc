package CollectionAndMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMain {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("a", "b", "c");
        List<Integer> intList = Arrays.asList(1, 2, 3);
        String str = test(strList, 1);
        Integer inti = test(intList, 1);
        System.out.println(str);
        System.out.println(inti);
    }
    public static <T> T test(List<T> list, int index){
        return list.get(index);
    }
}
