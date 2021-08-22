package fr.bab.keycloak.provider;

import org.jboss.logging.Logger;
import org.keycloak.Config;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.*;

public class RedisEventPublisherProviderFactory implements EventListenerProviderFactory {

    public static final String PROVIDER_ID = "redis_event_publisher";
    private static final Logger LOG = Logger.getLogger(RedisEventPublisherProviderFactory.class);
    private static String redisHost;
    private static int redisPort;
    private static String topicName = "keycloak.event.admin";

    @Override
    public EventListenerProvider create(KeycloakSession keycloakSession) {
        return new RedisEventPublisherProvider(keycloakSession, this.redisHost, this.redisPort, this.topicName);
    }

    @Override
    public void init(Config.Scope scope) {
        this.redisHost = scope.get("redisHost", "172.17.0.2");
        this.redisPort = Integer.parseInt(scope.get("redisPort", "6379"));
        this.topicName = scope.get("topicName", "keycloak.events");
        LOG.debug("init");
        LOG.debug(redisHost + " " + redisPort + " " + topicName);
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
