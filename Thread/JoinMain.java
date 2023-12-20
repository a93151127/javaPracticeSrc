package Thread;

public class JoinMain {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        Thread t1 = new Thread(() -> {
            for(int x = 0 ; x<=2; x++){
                System.out.println("t1 執行第 : " + x + " 次");
            }
        });
        Thread t2 = new Thread(() -> {
            for(int w =0; w<=10; w++){
                System.out.println("t2 執行第 : " + w + " 次");
                if(w == 3){
                    System.out.println("t1 開始執行 =======");
                    try {
                        t1.start();
                        t1.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("t1 結束執行 =======");
                }

            }
        });
        t2.start();
    }
}
