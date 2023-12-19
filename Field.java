
class Clothes{
    String color;
    char size;

    @Override
    public String toString() {
        return "Clothes{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
public class Field {
    public static void main(String[] args) {
        Clothes sun = new Clothes();
        Clothes spring = new Clothes();

        sun.color = "red";
        sun.size = 'L';
        spring.color = "green";
        spring.size = 'L';

        System.out.println(sun.toString());
        System.out.println(spring.toString());
    }
}

