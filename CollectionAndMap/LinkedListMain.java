package CollectionAndMap;

public class LinkedListMain {
    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();
        String a = "apple";
        String c = "cat";
        String b = "boy";
        list.addAtSecond(a);
        list.addAtSecond(b);
        list.addAtSecond(c);

        list.printOut();
        String d = "dog";
        list.addAtSecond(d);
        System.out.println("==========");
        list.printOut();
    }
}
