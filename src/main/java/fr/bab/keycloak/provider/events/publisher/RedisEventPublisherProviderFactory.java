package fr.bab.keycloak.provider.events.publisher;

import org.keycloak.Config;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.*;

public class RedisEventPublisherProviderFactory implements EventListenerProviderFactory {

    public static final String PROVIDER_ID = "redis-event-publisher";
    private RedisEventPublisherProvider eventPublisher;

    @Override
    public EventListenerProvider create(KeycloakSession keycloakSession) {
        return this.eventPublisher; 
    }

    @Override
    public void init(Config.Scope scope) {
        String pubsubType = scope.get("serverType");
        String pubsubHost = scope.get("serverHost");
        int pubsubPort = scope.getInt("serverPort");
        this.eventPublisher = new RedisEventPublisherProvider(pubsubType, pubsubHost, pubsubPort);
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
