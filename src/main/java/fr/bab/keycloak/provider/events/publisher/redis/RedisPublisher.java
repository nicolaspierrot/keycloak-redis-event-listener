package fr.bab.keycloak.provider.events.publisher.redis;

import fr.bab.keycloak.provider.events.publisher.IPublisher;
import redis.clients.jedis.Jedis;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class RedisPublisher implements IPublisher {
    private static Jedis jedis;

    @Override
    public void init(String hostname, int port) {
        try {
            URI uri = new URI(hostname);
            jedis = new Jedis(uri, port);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void publish(String channel, String payload) {
        jedis.publish(channel, payload);
    }
}
