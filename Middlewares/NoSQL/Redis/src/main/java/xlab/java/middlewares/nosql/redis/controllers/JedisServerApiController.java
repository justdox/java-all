package xlab.java.middlewares.nosql.redis.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/jedis/api/server")
public class JedisServerApiController extends JedisApiControllerBase {

  @GetMapping({"/info", "/info/{section}"})
  public Object getInfo(@PathVariable(required = false) final String section) {
    try (final Jedis jedis = jedisPool.getResource()) {
      if (section == null) {
        final String info = jedis.info();
        return ResponseEntity.ok(info);
      }

      // return ResponseEntity.ok(jedis.info(section));

      final String accept = request.getHeader("accept");

      final Cookie[] cookies = request.getCookies();

      final HttpSession session = request.getSession(false);

      return new ModelAndView("jedis/api/server/info", "info",
        jedis.info(section));
    }
  }
}
