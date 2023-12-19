package CollectionAndMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Justin", "1");
        map.put("Monica", "給Monica的敲敲畫");
        map.put("Irene", "2");
        map.forEach((key, value) ->
                System.out.println(" key : " + key + ", value : " + value));

        System.out.println("abcdsefd");
    }
}
