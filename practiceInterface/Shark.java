package practiceInterface;

public class Shark extends Fish{
    public Shark(String type) {
        super(type);
    }

    @Override
    public void swim() {
        System.out.println("Shark swim");
    }
}
