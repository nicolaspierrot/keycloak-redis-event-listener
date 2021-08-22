package fr.bab.keycloak.provider;

import redis.clients.jedis.Jedis;

public class RedisPublisher {
    private static Jedis jedis;

    public RedisPublisher(String host, int port) {
        jedis = new Jedis(host, port);
    }

    public void publish(String channel, String payload) {
        jedis.publish(channel, payload);
    }
}
