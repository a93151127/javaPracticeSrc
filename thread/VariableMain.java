package thread;

public class VariableMain {
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            while(true){
                Variable1.one();
            }
        });

        Thread t2 = new Thread(() ->{
            while(true){
                Variable1.two();
            }
        });
        t1.start();
        t2.start();
    }
}

class Variable1{
    volatile static int i = 0;
    volatile static int j = 0;

    static void one(){
        i ++;
        j ++;
    }

    static synchronized void two(){
        System.out.println("i : " + i + ", j : " + j);
    }
}
