package fr.bab.keycloak.provider;

import org.jboss.logging.Logger;
import redis.clients.jedis.Jedis;

public class RedisPublisher {
    private static Jedis jedis;

    public RedisPublisher(String host, int port) {
        this.jedis = new Jedis(host, port);
    }

    public void publish(String channel, String payload) {
        System.out.println("PUBLIISH " + channel);
        this.jedis.publish(channel, payload);
    }
}
