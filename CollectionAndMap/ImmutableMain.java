package CollectionAndMap;

import java.util.*;

public class ImmutableMain {
    public static void main(String[] args) {
        // java 9 以後 List, Set, Map 有提供of()方法
        Student studen = new Student("Martin");
        List<Student> studentList = List.of(studen);
        System.out.println(studentList.get(0).getName());

        // 因為是淺層複製所以可以這樣修改值,要避免的話要將類別裡的field設為final
//        studentList.get(0).name = "Abigail";
//        System.out.println(studentList.get(0).getName());
    }
}

class Student{
//    String name;
    final String name; // 避免被修改所以設為 final

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}