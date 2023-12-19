package client;

public class ClientEvent {
    private Client client;

    public ClientEvent(Client client) {
        this.client = client;
    }

    public String getClientName(){
        return client.getName();
    }

    public String getClientIP(){
        return client.getIp();
    }
}
