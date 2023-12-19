package client;

import java.util.ArrayList;
import java.util.List;

public class ClientQueue {
    private List<Client> clients = new ArrayList<>(); //收集連線的Client
    // 收集對ClientQueue有興趣的ClientListner
    private List<ClientListner> listners = new ArrayList<>();

    //註冊ClientListner
    public void addClientListner(ClientListner listner){
        listners.add(listner);
    }

    // 增加Client
    public void add(Client client){
        clients.add(client);// 新增Client
        ClientEvent clientEvent = new ClientEvent(client);// 通知資訊包裝為ClientEvent
        for(ClientListner listner : listners){
            listner.clientAdded(clientEvent);// 逐一取出clientEvent通知
        }
    }

    // 移除Client
    public void remove(Client client){
        clients.remove(client); // 移除client
        ClientEvent clientEvent = new ClientEvent(client); // 通知資訊包裝為ClientEvnet
        for(ClientListner listner : listners){
            listner.clientRemoved(clientEvent);
        }
    }
}
