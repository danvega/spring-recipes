package dev.danvega.javabucksreactive.service;

import dev.danvega.javabucksreactive.model.Coffee;
import dev.danvega.javabucksreactive.model.Size;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CoffeeService {

    private Flux<Coffee> coffees;
    AtomicInteger id = new AtomicInteger(0);

    public Flux<Coffee> findAll() {
        return coffees;
    }

    public Mono<Coffee> findOne(int id) {
        return coffees.filter(coffee -> coffee.id() == id).next();
    }

    @PostConstruct
    private void init() {
        coffees = Flux.just(
                new Coffee(id.incrementAndGet(), "Caffè Americano", Size.GRANDE),
                new Coffee(id.incrementAndGet(), "Caffè Latte", Size.VENTI),
                new Coffee(id.incrementAndGet(), "Caffè Caramel Macchiato", Size.TALL)
        );
    }
}