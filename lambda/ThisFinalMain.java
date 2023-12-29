package lambda;

public class ThisFinalMain {
    public static void main(String[] args) {
        Hello h = new Hello();
        // 這邊是在Runable的範圍,因此會是兩個記憶體的打印
        h.r1.run();
        h.r2.run();

        // 這邊是在Hello2裡面,因次參照的對象是Hello2
        Hello2 h2 = new Hello2();
        h2.r1.run();
        h2.r2.run();
    }

    static class Hello{
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(toString());
            }
        };

        public String toString(){
            return "hello world!";
        }
    }

    static class Hello2{
        Runnable r1 = () -> System.out.println(this);
        Runnable r2 = () -> System.out.println(toString());

        public String toString(){
            return "hello world";
        }
    }
}
