package CollectionAndMap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapMain {
    public static void main(String[] args) {
        // 實作 Comparator 排序
        Map<Integer, String> map = new TreeMap<>((s1, s2) -> s2 - s1);
        map.put(2, "a");
        map.put(1, "c");
        map.put(5, "6");
        map.forEach((key, value) ->
                System.out.println(" key : " + key + ", value : " + value));
    }
}
