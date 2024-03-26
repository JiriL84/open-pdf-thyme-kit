package jl.reports;

import java.util.Locale;
import java.util.Map;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.thymeleaf.context.Context;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafProcessor {

  private final SpringTemplateEngine thymeleafEngine = createTemplateEngine();

  private static SpringTemplateEngine createTemplateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();

    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
    templateResolver.setPrefix("/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setCharacterEncoding("UTF-8");
    templateEngine.setTemplateResolver(templateResolver);
    templateEngine.addDialect(new Java8TimeDialect());

    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames("messages/language");
    messageSource.setUseCodeAsDefaultMessage(true);

    templateEngine.setTemplateEngineMessageSource(messageSource);

    return templateEngine;
  }

  public String processTemplate(String template, Map<String, Object> args, Locale locale) {
    return thymeleafEngine.process(template, new Context(locale, args));
  }
}
