package xlab.java.middlewares.messagequeues.kafka.examples;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.security.NoSuchAlgorithmException;
import java.util.function.Function;

/**
 * @author CodeKing
 */
public class KafkaProducerTester<K, V> extends KafkaTester {
  protected final KafkaProducer<K, V> producer;

  protected Function<V, K> keyGenerator = null;

  protected KafkaProducerTester(final String configFileName)
  throws NoSuchAlgorithmException {
    super(configFileName);
    producer = new KafkaProducer<>(config);
  }

  protected KafkaProducerTester(final Function<V, K> keyGenerator)
  throws NoSuchAlgorithmException {
    this("client.producer.properties");
    this.keyGenerator = keyGenerator;
  }

  protected KafkaProducerTester()
  throws NoSuchAlgorithmException {
    this("client.producer.properties");
  }

  public static void main(String[] args)
  throws NoSuchAlgorithmException {
    final KafkaProducerTester<String, String> producer = new KafkaProducerTester<>();
    producer.test("purchases");
  }

  /**
   * 执行测试。
   */
  @Override
  public void test(final String topic) {
    sendMessage(topic);
  }

  private void sendMessage(final String topic) {
    int index = 1;
    while (true) {
      final String message = String.format("这是第 %d 条消息。", index++);
      final ProducerRecord<K, V> record = new ProducerRecord<K, V>(topic, (K) "",
        (V) message);

      producer.send(record, (metadata, exception) -> {
        System.out.println(metadata);
      });
    }
  }
}
