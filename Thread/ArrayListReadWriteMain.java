package Thread;

import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ArrayListReadWriteMain {
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

class ArrayListReadWrite<E>{
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Object[] elems;
    private int next;

    public ArrayListReadWrite(int capacity){
        elems = new Object[capacity];
    }

    public ArrayListReadWrite() {
        this(16);
    }

    public void add(E o){
        lock.writeLock().lock();
        try{
            System.out.println("next : " + next);
            if(next == elems.length){
                elems = Arrays.copyOf(elems, elems.length*2);
            }
            elems[next ++] = o;
        }finally {
            lock.writeLock().unlock();
        }
    }

    public E get(int index){
        lock.readLock().lock();
        try{
            return (E) elems[index];
        }finally{
            lock.readLock().unlock();
        }
    }

    public int size(){
        lock.readLock().lock();
        try{
            return next;
        }finally {
            lock.readLock().unlock();
        }
    }
}
