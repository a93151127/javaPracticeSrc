package practiceInterface;

public class SwimmerMain {
    public static void main(String[] args) {
        swim(new Shark("Martin"));
        swim(new Human());
        swim(new Submarine());

    }

    public static void swim(Swimmer s){
        s.swim();
    }
}
