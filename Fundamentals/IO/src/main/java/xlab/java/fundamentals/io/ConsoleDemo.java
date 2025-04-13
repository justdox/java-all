package xlab.java.fundamentals.io;

import java.io.Console;

public class ConsoleDemo {
  public static void main(String[] args) {
    final Console console = System.console();
    console.writer().write("Java console test demo.");
  }
}
