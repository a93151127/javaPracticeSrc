package ball.ballNew;

public abstract class ball {
    public static int y = 100;

    static{
        int x = 10;
        System.out.println("inside ball static");
    }

    public abstract void show();
}
