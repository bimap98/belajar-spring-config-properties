package com.programmerzamannow.spring.config.messagesource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageSourceTest {

  public ApplicationContext applicationContext;

  public MessageSource messageSource;

  @BeforeEach
  void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
    messageSource = applicationContext.getBean(MessageSource.class);
  }

  @Test
  void testDefaultLocale() {
    String message = messageSource.getMessage("hello", new Object[]{"Bima"}, Locale.ENGLISH);
    Assertions.assertEquals("Hello Bima", message);
  }

  @Test
  void testIndonesianLocale() {
    String message = messageSource.getMessage("hello", new Object[]{"Bima"}, new Locale("id", "ID"));
    Assertions.assertEquals("Halo Bima", message);
  }

  @SpringBootApplication
  public static class TestApplication {

    @Bean
    public MessageSource messageSource() {
      ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
      messageSource.setBasenames("my");
      return messageSource;
    }

  }

}
