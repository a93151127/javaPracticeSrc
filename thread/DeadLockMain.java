package thread;

public class DeadLockMain {
    public static void main(String[] args) {
        // 死結 的範例
        Resource r1 = new Resource("resource1", 10);
        Resource r2 = new Resource("resource2", 20);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                r1.cooperate(r2);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                r2.cooperate(r1);
            }
        });
        t1.start();
        t2.start();
    }
}

class Resource{
    private String name;
    private int resource;

    public Resource(String name, int resource) {
        this.name = name;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }
    synchronized int doSome(){
        return resource++;
    }
    synchronized void cooperate(Resource resource1){
        resource1.doSome();
        System.out.println(this.getName() + " 整合 " + resource1 +" 的資源");
    }
}
