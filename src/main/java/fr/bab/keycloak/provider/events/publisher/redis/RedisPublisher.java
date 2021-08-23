package fr.bab.keycloak.provider.events.publisher.redis;

import java.net.URI;
import redis.clients.jedis.Jedis;
import fr.bab.keycloak.provider.events.publisher.IPublisher;


public class RedisPublisher implements IPublisher {
    private Jedis jedis;

    @Override
    public void init(String hostname, int port) {
        try {
            jedis = new Jedis(hostname, port);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void publish(String channel, String payload) {
        jedis.publish(channel, payload);
    }
}
