package xlab.java.middlewares.messagequeues.kafka.examples;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.Random;

/**
 * @author CodeKing
 */
public abstract class KafkaTester {
  protected final Properties config;

  protected final Random random = SecureRandom.getInstanceStrong();

  protected KafkaTester(final String configFileName)
  throws NoSuchAlgorithmException {
    config = new Properties();
    loadConfig(configFileName);
  }

  private void loadConfig(final String configFileName) {
    try (final InputStream inputStream = ClassLoader.getSystemResourceAsStream(configFileName)) {
      config.load(inputStream);

      printConfig(config);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  private void printConfig(final Properties config) {
    config.forEach((k, v) -> System.out.printf("Key: %s, Value: %s.%n", k, v));
  }

  /**
   * 执行测试。
   *
   * @param topic
   */
  public abstract void test(final String topic);
}
