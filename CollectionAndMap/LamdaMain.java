package CollectionAndMap;;

public class LamdaMain {
    public static void main(String[] args) {
        // 舊的寫法
        Compare<String> c1 = new Compare<String>() {
            @Override
            public int compare(String t1, String t2) {
                return t1.length() - t2.length();
            }
        };
        System.out.println(c1.compare("100", "6"));
        // lamda 寫法
        Compare<String> c2 = (t1, t2) -> t1.length() - t2.length();
        System.out.println(c2.compare("1000", "6"));
    }
}

interface Compare<T>{
    int compare(T t1, T t2);
}
