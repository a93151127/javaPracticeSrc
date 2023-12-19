package InterfaceDetail;

public interface Action {
    public String Martin = "martin";
    public String Welson = "Welson";
    public int MartinAge = 37;
}

class DoAct{
    public static void main(String[] args) {
        System.out.println("Name : " + Action.Martin + ", Age : " + Action.MartinAge);
    }
}