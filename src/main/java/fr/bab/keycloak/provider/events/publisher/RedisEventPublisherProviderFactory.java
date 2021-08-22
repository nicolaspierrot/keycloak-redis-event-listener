package fr.bab.keycloak.provider.events.publisher;

import org.keycloak.Config;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.*;

public class RedisEventPublisherProviderFactory implements EventListenerProviderFactory {

    public static final String PROVIDER_ID = "redis_event_publisher";
    private String pubsubType;
    private String pubsubHost;
    private int pubsubPort;

    @Override
    public EventListenerProvider create(KeycloakSession keycloakSession) {
        return new RedisEventPublisherProvider(keycloakSession, pubsubType, pubsubHost, pubsubPort);
    }

    @Override
    public void init(Config.Scope scope) {
        this.pubsubType = scope.get("pubsubType", "redis");
        this.pubsubHost = scope.get("pubsubHost", "localhost");
        this.pubsubPort = Integer.parseInt(scope.get("pubsubPort", "6379"));
    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

}
