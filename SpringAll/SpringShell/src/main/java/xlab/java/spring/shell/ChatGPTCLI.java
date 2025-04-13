package xlab.java.spring.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author CodeKing
 */
@ShellComponent
public class ChatGPTCLI {

  @ShellMethod(key = "hello", value = "Greet by saying Hello.")
  public String hello() {
    return "Hello!";
  }
}
