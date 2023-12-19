package CollectionAndMap;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class student2Test {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        Student s1 = new Student("martin", "1");
        Student s2 = new Student("abi", "1");
        Student s3 = new Student("welson", "1");

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.forEach(System.out::println);
    }
    static class Student{
        private String name;
        private String number;

        public Student(String name, String number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return number.equals(student.number);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }
}
