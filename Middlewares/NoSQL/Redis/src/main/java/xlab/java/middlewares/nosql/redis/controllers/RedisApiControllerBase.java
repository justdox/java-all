package xlab.java.middlewares.nosql.redis.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;

public abstract class RedisApiControllerBase {

  @Autowired
  protected HttpServletRequest request;

  @Autowired
  protected HttpServletResponse response;

  @Autowired
  protected HttpSession session;

  /**
   * Get byte sequences of a given string using {@link StandardCharsets}
   * .UTF_8 as charset.
   *
   * @param input
   * @return
   */
  public static byte[] getBytes(final String input) {
    return input.getBytes(StandardCharsets.UTF_8);
  }
}
