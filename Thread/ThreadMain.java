package Thread;

public class ThreadMain {
    public static void main(String[] args) {
        // 使用 lamda 語法實作 Thread 的 run()
        Thread t1 = new Thread(() -> {
            int step = 0;
            while(step < 20){
                step ++;
                System.out.println("t1 為 " + step);
            }
        });

        Thread t2 = new Thread(() -> {
            int step = 0;
            while(step < 200){
                step ++;
                System.out.println("t2 為 " + step);
            }
        });

        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}

