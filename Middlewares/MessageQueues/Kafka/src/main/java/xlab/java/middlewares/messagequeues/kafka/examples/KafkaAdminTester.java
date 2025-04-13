package xlab.java.middlewares.messagequeues.kafka.examples;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

/**
 * @author CodeKing
 */
public class KafkaAdminTester extends KafkaTester {
  protected final AdminClient adminClient;

  protected KafkaAdminTester(final String configFileName)
  throws NoSuchAlgorithmException {
    super(configFileName);

    adminClient = AdminClient.create(config);
  }

  KafkaAdminTester()
  throws NoSuchAlgorithmException {
    this("client.admin.properties");
  }

  public static void main(String[] args)
  throws NoSuchAlgorithmException {
    final KafkaAdminTester admin = new KafkaAdminTester();
    admin.listTopics();
  }

  /**
   * 执行测试。
   */
  @Override
  public void test(final String topic) {
    // createTopic(topic);
    listTopics();
  }

  private void createTopic(final String topic) {
    final Collection<NewTopic> newTopics =
      Collections.singletonList(new NewTopic(topic, 1,
        (short) 1));
    try {
      System.out.println(adminClient.createTopics(newTopics).all().get());
    } catch (ExecutionException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  private void listTopics() {
    try {
      adminClient.listTopics().names().get().forEach(topic -> {
        System.out.printf("topic name: %s.%n", topic);
      });
    } catch (ExecutionException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
