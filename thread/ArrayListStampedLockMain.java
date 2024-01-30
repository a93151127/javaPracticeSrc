package thread;

import java.util.Arrays;
import java.util.concurrent.locks.StampedLock;

public class ArrayListStampedLockMain {
    public static void main(String[] args) {
        ArrayListStampedLock<Integer> list = new ArrayListStampedLock();
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                list.add(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                list.add(2);
            }
        });

        t1.start();
        t2.start();
    }
}

class ArrayListStampedLock<E>{
    private StampedLock lock = new StampedLock();
    private Object[] elems;
    private int next;

    public ArrayListStampedLock(int capacity){
        elems = new Object[capacity];
    }

    public ArrayListStampedLock() {
        this(16);
    }

    public void add(E o){
        long stamp = lock.writeLock();
        try{
            System.out.println("next : " + next);
            if(next == elems.length){
                elems = Arrays.copyOf(elems, elems.length*2);
            }
            elems[next ++] = o;
        }finally {
            lock.unlock(stamp);
        }
    }

    public E get(int index){
        long stamp = lock.tryOptimisticRead();
        if(!lock.validate(stamp)){
            lock.readLock();
            try{
                return (E) elems[index];
            }finally{
                lock.unlock(stamp);
            }
        }
        return (E) elems;
    }

    public int size(){
        long stamp = lock.tryOptimisticRead();
        if(!lock.validate(stamp)){
            lock.readLock();
            try{
                return next;
            }finally {
                lock.unlock(stamp);
            }
        }
        return next;
    }
}
