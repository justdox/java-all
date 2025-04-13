package xlab.java.middlewares.nosql.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.RegistrationPolicy;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPooled;

@Configuration
public class AppConfig {
  private final String redisHost;

  private final int redisPort;

  private final String redisUser;

  private final String redisPassword;

  public AppConfig(@Value("${spring.data.redis.host:localhost}") final String host,
                   @Value("${spring.data.redis.port:6379}") final int port,
                   @Value("${spring.data.redis.username:dbadmin}") final String user,
                   @Value("${spring.data.redis.password:123test!}") final String password) {
    redisHost = host;
    redisPort = port;
    redisUser = user;
    redisPassword = password;
  }

  @Autowired(required = false)
  public void mBeanConfiguration(final MBeanExporter exporter) {
    exporter.setRegistrationPolicy(RegistrationPolicy.IGNORE_EXISTING);
  }

  @Lazy
  @Bean
  public JedisPool jedisPool() {
    return new JedisPool(redisHost, redisPort, redisUser, redisPassword);
  }

  @Lazy
  @Bean
  public JedisPooled jedisPooled() {
    return new JedisPooled(redisHost, redisPort, redisUser, redisPassword);
  }
}
