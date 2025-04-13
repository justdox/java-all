package xlab.java.middlewares.nosql.redis.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class GlobalErrorController extends AbstractErrorController {

  public GlobalErrorController(final ErrorAttributes errorAttributes) {
    super(errorAttributes);
  }

  @Autowired
  public GlobalErrorController(final ErrorAttributes errorAttributes,
                               final List<ErrorViewResolver> errorViewResolvers) {
    super(errorAttributes, errorViewResolvers);
  }

  @RequestMapping(produces = "text/html")
  public ModelAndView errorHtml(final HttpServletRequest request,
                                final HttpServletResponse response,
                                final Model model1) {
    final HttpStatus status = getStatus(request);
    final Map<String, Object> model = Collections.unmodifiableMap((getErrorAttributes(request,
      isIncludeStackTrace(request, MediaType.TEXT_HTML))));

    final ModelAndView modelAndView = resolveErrorView(request, response, status, model);

    return (modelAndView == null ? new ModelAndView("error", "error", model) :
      modelAndView);
  }

  private ErrorAttributeOptions isIncludeStackTrace(HttpServletRequest request, MediaType textHtml) {
    return null;
  }
}
