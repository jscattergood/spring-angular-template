package com.example.springangular;

import de.infinit.spring.boot.autoconfigure.wro4j.GroovyWroManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.isdc.wro.manager.factory.WroManagerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

@SpringBootApplication
@RestController
public class Application {

    private static final String WRO_CONFIG = "wro.groovy";

    @Bean
    WroManagerFactory wroManagerFactory() {
        return new GroovyWroManagerFactory(WRO_CONFIG, new Properties());
    }

    @RequestMapping("/home")
    public Map<String, Object> home() {
        Map<String,Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
