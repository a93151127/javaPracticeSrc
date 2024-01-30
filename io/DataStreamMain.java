package io;

import java.io.*;

public class DataStreamMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Member2[] members = {
                new Member2("B9876", "Welson", 32)
        };
        for(Member2 member2 :members){
            member2.save();
        }
        System.out.println(Member2.load("B9876"));
    }
}

class Member{
    private static String number;
    private static String name;
    private static int age;

    public Member(String number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }

    public static void save() throws IOException {
        try(DataOutputStream output = new DataOutputStream(new FileOutputStream(number))){
            output.writeUTF(number);
            output.writeUTF(name);
            output.writeInt(age);
        }
    }

    public static Member2 load(String number) throws IOException {
        Member2 member2;
        try(DataInputStream input = new DataInputStream(new FileInputStream(number))){
            member2 = new Member2(input.readUTF(), input.readUTF(), input.readInt());
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
