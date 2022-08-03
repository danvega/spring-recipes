package dev.danvega.javabucks;

import dev.danvega.javabucks.config.JavaBucksProperties;
import dev.danvega.javabucks.service.CoffeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class JavaBucksApplication {

    private static final Logger log = LoggerFactory.getLogger(JavaBucksApplication.class);

    public static void main(String[] args) {
        var context = SpringApplication.run(JavaBucksApplication.class, args);
        log.info("There are {} beans in the application context", context.getBeanDefinitionNames().length);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

}
