package CollectionAndMap;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push("a");// 加入資料
        stack.push("b");
        stack.push("c");

        System.out.println(stack.pop());// 移除資料
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static class Stack {
        private Deque deque = new ArrayDeque();
        private int capacity;

        public Stack(int capacity) {
            this.capacity = capacity;
        }

        private boolean isFull() {
            return deque.size() + 1 > capacity;
        }

        public int size() {
            return deque.size();
        }

        public Object pop() {
            return deque.pollLast();
        }

        public Object peek() {
            return deque.peekLast();
        }

        public boolean push(Object element) {
            if (isFull()) {
                return false;
            }
            return deque.offerLast(element);
        }
    }
}
