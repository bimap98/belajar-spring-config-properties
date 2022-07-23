package com.programmerzamannow.spring.config.springbootmessagesource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringBootMessageSourceTest.TestApplication.class)
public class SpringBootMessageSourceTest {

  @Autowired
  private TestApplication.SampleSource sampleSource;

  @Test
  void testLocale() {
    Assertions.assertEquals("Hello Bima", sampleSource.getMessage(Locale.ENGLISH));
    Assertions.assertEquals("Halo Bima", sampleSource.getMessage(new Locale("id", "ID")));
  }

  @SpringBootApplication
  public static class TestApplication {

    @Component
    public static class SampleSource implements MessageSourceAware {

      @Setter
      private MessageSource messageSource;

      public String getMessage(Locale locale){
        return messageSource.getMessage("hello", new Object[]{"Bima"}, locale);
      }

    }

  }

}
