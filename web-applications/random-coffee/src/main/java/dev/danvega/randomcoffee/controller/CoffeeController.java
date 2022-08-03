package dev.danvega.randomcoffee.controller;

import dev.danvega.randomcoffee.model.Coffee;
import dev.danvega.randomcoffee.service.CoffeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    private final CoffeeService coffeeService;
    private final RestTemplate restTemplate;

    public CoffeeController(CoffeeService coffeeService, RestTemplate restTemplate) {
        this.coffeeService = coffeeService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Coffee> findAll() {
        return coffeeService.findAll();
    }

    @GetMapping("/random")
    public Coffee random() {
        return coffeeService.create(
                restTemplate.getForObject("https://coffee.alexflipnote.dev/random.json", Coffee.class)
        );
    }
}
