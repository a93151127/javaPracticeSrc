package CollectionAndMap;

import java.util.HashMap;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        forEachSelf(map.entrySet());
    }
    private static void forEachSelf(Iterable<Map.Entry<String, Integer>> iterator){
        for(Map.Entry<String, Integer> entry : iterator){
            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
        }
    }
}
