package fr.bab.keycloak.provider.events.publisher;

import fr.bab.keycloak.provider.events.publisher.redis.RedisPublisher;
import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.admin.AdminEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RedisEventPublisherProvider implements EventListenerProvider {
    private IPublisher publisher = null;

    public RedisEventPublisherProvider(String pubSubType, String redisHost, int redisPort) {
        
        if("redis".equals(pubSubType)) {
            this.publisher = new RedisPublisher();
        }
        
        if(this.publisher == null) {
            throw new RuntimeException(pubSubType + " publisher not found");
        }
        this.publisher.init(redisHost, redisPort);
    }

    @Override
    public void onEvent(Event event) {
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {
        String payload = adminEvent.getRepresentation();
        this.publisher.publish(this.buildTopic(adminEvent), payload != null ? payload : "");

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
