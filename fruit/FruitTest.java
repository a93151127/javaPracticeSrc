package fruit;

public class FruitTest {
    public static void main(String[] args) {
        Fruit f1 = new Apple("martin", "red");
        Fruit f2 = new Orange("abi", "yellow");

    }
}

class Apple extends Fruit{
    public Apple(String name, String color) {
        super(name, color);
    }

    public static String getStr(){
        return "inside Apple " ;
    }
}

class Orange extends Fruit{
    public Orange(String name, String color) {
        super(name, color);
    }

}
