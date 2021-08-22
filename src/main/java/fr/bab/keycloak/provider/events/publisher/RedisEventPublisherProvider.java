package fr.bab.keycloak.provider.events.publisher;

import fr.bab.keycloak.provider.events.publisher.redis.RedisPublisher;
import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.admin.AdminEvent;

import org.keycloak.models.KeycloakSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RedisEventPublisherProvider implements EventListenerProvider {
    private final KeycloakSession session;
    private IPublisher publisher = null;

    public RedisEventPublisherProvider(KeycloakSession session, String pubSubType, String redisHost, int redisPort) {
        this.session = session;

        switch(pubSubType) {
            case "redis":
                this.publisher = new RedisPublisher();
                break;
        }
        if(this.publisher == null) {
            throw new RuntimeException(pubSubType + " publisher not implemented");
        }
    }

    @Override
    public void onEvent(Event event) {
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {
        String payload = adminEvent.getRepresentation();
        this.publisher.publish(this.buildTopic(adminEvent), payload);
    }

    private String buildTopic(AdminEvent event) {
        List<String> topicWords = new ArrayList<>();
        topicWords.add("keycloak.events.admin");
        topicWords.add(event.getResourceType().toString().toLowerCase(Locale.ROOT));
        topicWords.add(event.getOperationType().toString().toLowerCase(Locale.ROOT));
        return String.join(".", topicWords);
    }

    @Override
    public void close() {

    }
}
