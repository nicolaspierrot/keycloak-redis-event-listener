package fr.bab.keycloak.provider;

import org.jboss.logging.Logger;
import org.keycloak.Config;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.*;

public class RedisEventListenerProviderFactory implements EventListenerProviderFactory {

    public static final String PROVIDER_ID = "webhook_events_listener";
    private static final Logger LOG = Logger.getLogger(RedisEventListenerProviderFactory.class);

    @Override
    public EventListenerProvider create(KeycloakSession keycloakSession) {
        return new RedisEventListenerProvider(keycloakSession);
    }

    @Override
    public void init(Config.Scope scope) {
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
