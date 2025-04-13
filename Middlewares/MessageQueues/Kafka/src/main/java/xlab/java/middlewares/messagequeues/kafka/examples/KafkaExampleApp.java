package xlab.java.middlewares.messagequeues.kafka.examples;

import java.security.NoSuchAlgorithmException;

/**
 * @author CodeKing
 */
public class KafkaExampleApp {
  public static void main(String[] args)
  throws NoSuchAlgorithmException {
    final String topic = "test";
    // new KafkaAdminTester().test(topic);
    new KafkaConsumerTester<String,String>().test(topic);
    new KafkaProducerTester<String,String>().test(topic);
  }
}
