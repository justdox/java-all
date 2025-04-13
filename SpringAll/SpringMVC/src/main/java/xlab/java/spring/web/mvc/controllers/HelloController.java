package xlab.java.spring.web.mvc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CodeKing
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

  @GetMapping("/world")
  public String world() {
    return "Hello world!";
  }
}
