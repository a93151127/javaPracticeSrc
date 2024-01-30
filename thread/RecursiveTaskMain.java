package thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskMain {
    public static void main(String[] args) {
        // 分而治之方法
        Fibonacci fibonacci = new Fibonacci(45);
        ForkJoinPool pool = new ForkJoinPool();
        long startTime = System.currentTimeMillis();
        System.out.println(pool.invoke(fibonacci)); // 開始分而治之
        long endTime = System.currentTimeMillis();
        System.out.println("分而治之方法總花費時間 : " + (endTime - startTime) + " 毫秒");

        // 一般方法
        startTime = System.currentTimeMillis();
        System.out.println(fibonacci(45L));
        endTime = System.currentTimeMillis();
        System.out.println("一般方法總花費時間 : " + (endTime - startTime) + " 毫秒");
    }

    private static long fibonacci(Long n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}

class Fibonacci extends RecursiveTask<Long>{
    final long n;

    public Fibonacci(long n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if(n <= 20){
            return fibonacci(n);
        }
        // 分解出 n-1 的子任務, 請 ForkJoinPool 分配執行緒來執行這個子任務
        ForkJoinTask<Long> subTask = new Fibonacci(n-1).fork();
        // 分解出n-2的子任務並直接運算 加上 子任務的運算結果
        return new Fibonacci(n-2).compute() + subTask.join();
    }

    private long fibonacci(Long n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
