package thread;

public class InterruptedMain {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(9999);
            } catch (InterruptedException e) {
                System.out.println("我醒了");
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t1.interrupt();
    }
}
