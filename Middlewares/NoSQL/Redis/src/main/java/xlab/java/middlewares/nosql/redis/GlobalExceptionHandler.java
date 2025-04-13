package xlab.java.middlewares.nosql.redis;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
  /**
   * @param request
   * @param response
   * @param handler
   * @param ex
   * @return
   */
  @Override
  public ModelAndView resolveException(final HttpServletRequest request,
                                       final HttpServletResponse response,
                                       final Object handler, final Exception ex) {
    return null;
  }
}
