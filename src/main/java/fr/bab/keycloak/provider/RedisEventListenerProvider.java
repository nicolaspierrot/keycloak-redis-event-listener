package fr.bab.keycloak.provider;

import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.admin.AdminEvent;

import org.jboss.logging.Logger;
import org.keycloak.events.admin.OperationType;
import org.keycloak.events.admin.ResourceType;
import org.keycloak.models.KeycloakSession;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.net.URI;

public class RedisEventListenerProvider implements EventListenerProvider {

    private static final Logger log = Logger.getLogger(RedisEventListenerProvider.class);
    private final KeycloakSession session;
    private final String redisHost;
    private final JedisPool redisPool;

    public RedisEventListenerProvider(KeycloakSession session) {
        this.session = session;
        this.redisHost = "localhost";
        this.redisPool = new JedisPool(new JedisPoolConfig(), this.redisHost);
    }

    @Override
    public void onEvent(Event event) {
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {
    }

    @Override
    public void close() {

    }
}
