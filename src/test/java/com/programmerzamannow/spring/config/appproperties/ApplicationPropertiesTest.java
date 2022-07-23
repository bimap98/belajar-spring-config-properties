package com.programmerzamannow.spring.config.appproperties;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ApplicationPropertiesTest.TestApplication.class)
public class ApplicationPropertiesTest {

  @Autowired
  private TestApplication.SampleProperties sampleProperties;

  @Autowired
  private Environment environment;

  @Test
  void testProperties() {
    String applicationName = environment.getProperty("application.name");
    Assertions.assertEquals("Belajar Spring Boot", applicationName);
    Assertions.assertEquals("Belajar Spring Boot", sampleProperties.getProperties());
  }

  @SpringBootApplication
  public static class TestApplication {

    @Component
    public static class SampleProperties implements EnvironmentAware {

      @Setter
      private Environment environment;

      public String getProperties(){
        return environment.getProperty("application.name");
      }

    }

  }

}
