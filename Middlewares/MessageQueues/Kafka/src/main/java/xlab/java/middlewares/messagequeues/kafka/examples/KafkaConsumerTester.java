package xlab.java.middlewares.messagequeues.kafka.examples;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Collections;

/**
 * @author CodeKing
 */
public class KafkaConsumerTester<K, V> extends KafkaTester {
  protected final KafkaConsumer<K, V> consumer;

  protected KafkaConsumerTester(final String configFileName)
  throws NoSuchAlgorithmException {
    super(configFileName);
    consumer = new KafkaConsumer<>(config);
  }

  protected KafkaConsumerTester()
  throws NoSuchAlgorithmException {
    this("client.consumer.properties");
  }

  protected void getMessage() {
    while (true) {
      final ConsumerRecords<K, V> records =
        consumer.poll(Duration.ofMillis(1000));
      records.forEach(record -> {
        System.out.printf("Received message: {topic=%s, message=%s, " +
            "partition=%d, offset=%d}.%n", record.topic(), record.value(),
          record.partition(), record.offset());
      });
    }
  }

  /**
   * 执行测试。
   */
  @Override
  public void test(final String topic) {
    consumer.subscribe(Collections.singletonList(topic));
    this.getMessage();
  }
}
