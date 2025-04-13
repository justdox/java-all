package xlab.java.middlewares.nosql.redis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/jedis/api/string")
public class JedisStringApiController extends JedisApiControllerBase {

  @GetMapping("/get/{key}")
  public ResponseEntity<String> get(@PathVariable final String key) {
    try (final Jedis jedis = jedisPool.getResource()) {
      final String value = jedis.get(key);
      if (value == null) {
        return ResponseEntity.notFound().build();
      }

      return ResponseEntity.ok(value);
    }
  }
}
