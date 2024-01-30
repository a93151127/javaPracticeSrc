package thread;

import java.util.Arrays;

public class ArrayListDemoMain {
    public static void main(String[] args) {
        /*
        因 ArrayList 不具備 "執行緒安全"
        因此有機會會發生 ArrayIndexOutOfBoundsException
        在add的method添加 synchronized可避免此狀況
         */
        ArrayTest list = new ArrayTest();
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

class ArrayTest{
    private Object[] elems; // 使用 Object 陣列收集
    private int next; // 下一個可儲存物件的 索引, 沒有初始化的話, java預設是給 0

    // capacity 指定初始容量
    public ArrayTest(int capacity ){
        elems = new Object[capacity];
    }

    public ArrayTest() {
        this(16); // 初始容量預設為 16
    }

    // 收集物件的方法
    public synchronized void add(Object o){
        System.out.println("next : " + next);
        if(next != 0){
            int x = next;
            System.out.println(elems[x-1]);
        }
        System.out.println("===============");

        if(next == elems.length){ // 自動增長 Object 陣列長度
            elems = Arrays.copyOf(elems, elems.length*2);
        }

        elems[next++] = o;
    }

    public Object get(int index){ // 依 索引 取得收集之物件
        return elems[index];
    }

    // 已收集的物件個數
    public int size(){
        return next;
    }
}
