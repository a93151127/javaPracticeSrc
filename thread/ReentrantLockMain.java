package thread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain{
    public static void main(String[] args) {
        ArrayListLock<Integer> list = new ArrayListLock<Integer>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(100);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                list.add(10);
            }
        });

        t1.start();
        t2.start();
    }
}
class ArrayListLock<E> {
    Lock lock = new ReentrantLock();
    private Object[] elems;
    private int next;

    public ArrayListLock(int capacity){
        elems = new Object[capacity];
    }
    public ArrayListLock() {
        this(16);
    }

    public void add(E o){
        lock.lock();
        try {
            if(next != 0){
                int x = next;
                System.out.println(elems[x-1]);
            }
            System.out.println("===============");

            if(next == elems.length){ // 自動增長 Object 陣列長度
                elems = Arrays.copyOf(elems, elems.length*2);
            }

            elems[next++] = o;
        } finally {
            lock.unlock();
        }
    }

    public E get(int index){
        lock.lock();
        try{
            return (E) elems[index];
        }finally {
            lock.unlock();
        }
    }

    public int size(){
        lock.lock();
        try{
            return next;
        }finally {
            lock.unlock();
        }
    }
}

