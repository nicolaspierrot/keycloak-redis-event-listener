package fr.bab.keycloak.provider.events.publisher;

public interface IPublisher {

    public void init(String hostname, int port);

    public void publish(String channel, String payload);

}
