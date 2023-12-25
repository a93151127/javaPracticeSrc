package Thread;

import java.util.concurrent.*;

public class FutureCallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println("老闆,第10個值我等等來拿");

        Future<Long> the30Num = executorService.submit(()-> fibonacci(10));

        while(!the30Num.isDone()){
            System.out.println("還沒好...");
        }
        System.out.println(the30Num.get());
    }

    static Long fibonacci(long n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n - 2);
    }
}


