package io;

import java.io.*;

public class ObjectStreamMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Member2 m1 = new Member2("B9876", "Welson", 32);
        Member2[] members = {
                m1
        };
        for(Member2 member2 :members){
            member2.save();
        }

        System.out.println(Member2.load("B9876"));
    }
}

 class Member2 implements Serializable{
    private static String number;
    private transient static String name;
    private static int age;

    public Member2(String number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }

    public void save() throws IOException {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(number))){
            output.writeObject(this);
        }
    }

    public static Member2 load(String number) throws IOException, ClassNotFoundException {
        Member2 member2;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(number))){
            member2 = (Member2) input.readObject();
        }
        return member2;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
