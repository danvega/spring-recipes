package dev.danvega.javabucks.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "javabucks")
@ConstructorBinding
public record JavaBucksProperties(String title, String subtitle) {

}
