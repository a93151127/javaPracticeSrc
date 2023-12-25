package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceMain {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(()->{
            System.out.println(new java.util.Date());
            try {
                Thread.sleep(2000); // 假設會執行2秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 2000, 1000, TimeUnit.MILLISECONDS);
    }
}
