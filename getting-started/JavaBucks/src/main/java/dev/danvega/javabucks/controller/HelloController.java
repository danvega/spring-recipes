package dev.danvega.javabucks.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${mysecret: NOT_FOUND}")
    private String secret;

    @GetMapping()
    private String hello() {
        return secret;
    }

}
