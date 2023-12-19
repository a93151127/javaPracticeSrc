package ball;


public class TestMain {
    public static void main(String[] args) {
        SwordMan s = new SwordMan("Martin");
        Role m = new MagicMan("Abi");

        drawFight(s);
        drawFight(m);
    }

    public static void drawFight(Role r){
        r.drawFight();
    }
}

//劍士
class SwordMan extends Role {
    public SwordMan(String name) {
        super(name);
    }

    public void fight(){
        System.out.println("揮劍攻擊");
    }
    @Override
    public void drawFight(){
        System.out.println("名字 : " + this.getName() + ", drawFight 揮劍攻擊");
    }
}

//魔法師
class MagicMan extends Role{
    public MagicMan(String name) {
        super(name);
    }

    public void fight(){
        System.out.println("魔法攻擊");
    }

    public void cure(){
        System.out.println("治療");
    }

    @Override
    public void drawFight(){
        System.out.println("名字 : " + this.getName() + ", drawFight 魔法攻擊");
    }
}