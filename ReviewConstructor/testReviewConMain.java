package ReviewConstructor;


public class testReviewConMain {
    public static void main(String[] args) {
        //Anonymous inner class
        Object o = new Object(){
            @Override
            public String toString(){
                return "這是個inner class 測試";
            }
        };

        System.out.println(o.toString());

        // 若一個 inteface 只有 "1個" method
        TestLamda test = new TestLamda() {
            @Override
            public void testLamda() {
                System.out.println("java 8 之前測試");
            }
        };
        test.testLamda();
        // lamda語法

        TestLamda some = ()->{
            System.out.println("java 8 lamda 測試");
        };
        some.testLamda();
    }
}

interface TestLamda{
    public void testLamda();
}


