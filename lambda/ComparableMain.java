package lambda;

public class ComparableMain {
    public static void main(String[] args) {
        Ball b = new Ball(10);
        Ball b1 = new Ball(20);
        System.out.println(b.compareTo(b1));
        System.out.println(b.greaterThan(b1));
        System.out.println(b.lessThan(b1));
    }
}

class Ball implements Comparable<Ball>{
    private int radius;

    public Ball(int radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Ball ball) {
        return this.radius - ball.radius;
    }
}

interface Comparable<T>{
    int compareTo(T t);

    default boolean lessThan(T that){
        return compareTo(that) < 0;
    }

    default boolean greaterThan(T that){
        return compareTo(that) > 0;
    }
}
