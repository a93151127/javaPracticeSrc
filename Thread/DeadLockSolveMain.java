package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockSolveMain {
    public static void main(String[] args) {
        // 死結 的範例
        Resource1 r1 = new Resource1("resource1");
        Resource1 r2 = new Resource1("resource2");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                r1.cooperate(r2);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                r2.cooperate(r1);
            }
        });
        t1.start();
        t2.start();
    }
}

class Resource1 {
    private ReentrantLock lock = new ReentrantLock();
    private String name;

    public Resource1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void cooperate(Resource1 res){
        while(true){
            try{
                if(lockMeAnd(res)){ // 將目前與傳入的res先鎖定
                    // 兩個都鎖定才執行程式
                    System.out.println(this.getName() + " 整合 " + res +" 的資源");
                    break; // 資源整合成功,離開迴圈
                }
            }finally {
                unlockMeAnd(res); // 將這個lock和res釋放
            }
        }
    }

    private boolean lockMeAnd(Resource1 res){
        return this.lock.tryLock() && res.lock.tryLock();
    }

    private void unlockMeAnd(Resource1 res){
        if(this.lock.isHeldByCurrentThread()){
            this.lock.unlock();
        }
        if(res.lock.isHeldByCurrentThread()){
            res.lock.unlock();
        }
    }
}
