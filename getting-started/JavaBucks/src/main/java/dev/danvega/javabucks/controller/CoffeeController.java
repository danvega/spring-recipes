package dev.danvega.javabucks.controller;

import dev.danvega.javabucks.service.CoffeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class CoffeeController {

    private final CoffeeService coffeeService;

    private static final Logger log = LoggerFactory.getLogger(CoffeeController.class);

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
        log.info("All Coffees: {}",coffeeService.findAll());
    }

    @GetMapping("/")
    public String random() {
        return "Hello, KCDC!";
    }

}
