package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WaitNotifyMain {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(1);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

class Producer implements Runnable{
    private BlockingQueue<Integer> productQueue;

    public Producer(BlockingQueue<Integer> productQueue) {
        this.productQueue = productQueue;
    }

    @Override
    public void run() {
        System.out.println("生產者開始生產貨品");
        for (int product = 0; product < 10; product++) {
            try {
                productQueue.put(product);
                System.out.println("生產者 : 生產產品 " + product);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable{
    private BlockingQueue<Integer> productQueue;

    public Consumer(BlockingQueue<Integer> consumerQueue) {
        this.productQueue = consumerQueue;
    }

    @Override
    public void run() {
        System.out.println("消費者開始取走商品");
        for (int i = 0; i < 10; i++) {
            try {
                int product = productQueue.take();
                System.out.println("消費者 : 拿走產品 " + product);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }    
    }
}