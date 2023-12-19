package practiceInterface;

public abstract class Fish implements Swimmer{
    private String type;

    public Fish(String type) {
        this.type = type;
    }

    public abstract void swim();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
