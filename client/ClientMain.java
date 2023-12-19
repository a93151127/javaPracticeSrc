package client;

public class ClientMain {
    public static void main(String[] args) {
        // 建立Client
        Client c1 = new Client("Martin", "127.0.0.1");
        Client c2 = new Client("Abigail", "127.0.0.2");

        ClientQueue queue = new ClientQueue(){
            @Override
            public void add(Client client){
                System.out.println("新增連線, 名字 : " + client.getName() + ", IP : " + client.getIp());
            }
            @Override
            public void remove(Client client){
                System.out.println("移除連線, 名字 : " + client.getName() + ", IP : " + client.getIp());
            }
        };

        queue.add(c1);
        queue.add(c2);

        queue.remove(c1);
        queue.remove(c2);
    }
}
