import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         List<Integer> list = new ArrayList<>();
         list.add(1);
         list.add(3);

         AAA a = new AAA();
         a.setiList(list);
         System.out.println(a.toString());

         list.add(5);
         list.add(7);
         list.add(9);
        System.out.println(a.toString());

    }
}


class AAA{
    List<Integer> iList;

    public List<Integer> getiList() {
        return iList;
    }

    public void setiList(List<Integer> iList) {
        this.iList = iList;
    }

    @Override
    public String toString() {
        return "AAA{" +
                "iList=" + iList +
                '}';
    }
}