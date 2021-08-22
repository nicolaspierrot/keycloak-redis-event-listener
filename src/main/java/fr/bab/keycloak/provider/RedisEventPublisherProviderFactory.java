package fr.bab.keycloak.provider;

import org.keycloak.Config;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.*;

public class RedisEventPublisherProviderFactory implements EventListenerProviderFactory {

    public static final String PROVIDER_ID = "redis_event_publisher";
    private String redisHost;
    private int redisPort;

    @Override
    public EventListenerProvider create(KeycloakSession keycloakSession) {
        return new RedisEventPublisherProvider(keycloakSession, redisHost, redisPort);
    }

    @Override
    public void init(Config.Scope scope) {
        this.redisHost = scope.get("redisHost", "172.17.0.2");
        this.redisPort = Integer.parseInt(scope.get("redisPort", "6379"));
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
