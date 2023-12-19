package CollectionAndMap;

public class SimpleLinkedList {
    // 將收集的物件用 Node 封裝
    private Node first;

    private class Node {
        public Node(Object o) {
            this.o = o;
        }
        Object o;
        Node next;

        public Object getO() {
            return o;
        }

        public void setO(Object o) {
            this.o = o;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void addAtSecond(Object o){
        Node node = new Node(o);
        int size = size();
        if(first == null){
            first = node;
        }else{
            //取得index為0的Node
            Node originalNode = findElemnentOf(0);

            if(size == 1){
                originalNode.next = node;
            }else{
                Node nextNode = findElemnentOf(1);
                originalNode.next = node;
                node.next = nextNode;
            }
        }
    }

    public void append(Node node){
        Node last = first;
        while(last.next != null){
            last = last.next;
        }
        last.next = node;
    }

    public Node get(int index){
        checkSize(index);
        return findElemnentOf(index);
    }

    public int size(){
        int count = 0;
        Node last = first;
        while(last != null){
            last = last.next;
            count ++;
        }
        return count;
    }

    private void checkSize(int index){
        int size = size();
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private Node findElemnentOf(int index){
        int count = 0;
        Node last = first;
        while(count < index){
            last = last.next;
            count ++;
        }
        return last;
    }

    public void printOut(){
        int size = size();
        int count = 0;
        while(count < size){
            System.out.println(findElemnentOf(count).getO());
            count ++;
        }
    }
}
