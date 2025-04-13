package xlab.java.spring.clound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 * @author CodeKing
 */
// @EnableEurekaServer
@SpringBootApplication
public class RegisterCenterApp {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    SpringApplication.run(RegisterCenterApp.class, args);
  }
}
