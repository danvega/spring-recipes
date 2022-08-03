package dev.danvega.javabucksreactive.controller;

import dev.danvega.javabucksreactive.model.Coffee;
import dev.danvega.javabucksreactive.service.CoffeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {


    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public Flux<Coffee> findAll() {
        return coffeeService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Coffee> findOne(@PathVariable Integer id) {
        return coffeeService.findOne(id);
    }

}
