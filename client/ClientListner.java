package client;

public interface ClientListner {
    public void clientAdded(ClientEvent clientEvent);
    public void clientRemoved(ClientEvent clientEvent);
}
