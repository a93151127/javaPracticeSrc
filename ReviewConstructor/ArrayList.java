package ReviewConstructor;

import java.util.Arrays;

public class ArrayList {
    private Object[] elems; // 使用 Object 陣列收集
    private int next; // 下一個可儲存物件的 索引, 沒有初始化的話, java預設是給 0

    // capacity 指定初始容量
    public ArrayList(int capacity ){
        elems = new Object[capacity];
    }

    public ArrayList() {
        this(16); // 初始容量預設為 16
    }

    // 收集物件的方法
    public void add(Object o){
        System.out.println("next : " + next);
        if(next == elems.length){ // 自動增長 Object 陣列長度
            elems = Arrays.copyOf(elems, elems.length*2);
        }
    }

    public Object get(int index){ // 依 索引 取得收集之物件
        return elems[index];
    }

    // 已收集的物件個數
    public int size(){
        return next;
    }
}
