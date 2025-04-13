package xlab.java.middlewares.nosql.redis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

public abstract class JedisApiControllerBase extends RedisApiControllerBase {
  @Autowired
  protected JedisPool jedisPool;
}
