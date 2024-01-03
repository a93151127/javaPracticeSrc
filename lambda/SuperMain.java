package lambda;

import java.sql.SQLOutput;

public class SuperMain {
    public static void main(String[] args) {
        D d = new D();
        d.draw();
    }

    Iterable<String> a;
}

interface A{
    default void draw(){
        System.out.println("A");
    }
}

class C implements A{
    private String name;

    @Override
    public String toString() {
        return "C{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("C");
    }
}

class D implements A{

}