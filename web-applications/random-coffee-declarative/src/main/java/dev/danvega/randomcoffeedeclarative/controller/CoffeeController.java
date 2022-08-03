package dev.danvega.randomcoffeedeclarative.controller;

import dev.danvega.randomcoffeedeclarative.client.CoffeeClient;
import dev.danvega.randomcoffeedeclarative.model.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    private final CoffeeClient coffeeClient;

    public CoffeeController(CoffeeClient coffeeClient) {
        this.coffeeClient = coffeeClient;
    }

    @GetMapping("/random")
    public Coffee random() {
        return coffeeClient.random();
    }
}
