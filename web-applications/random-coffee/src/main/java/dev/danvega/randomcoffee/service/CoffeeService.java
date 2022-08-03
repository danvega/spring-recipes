package dev.danvega.randomcoffee.service;

import dev.danvega.randomcoffee.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CoffeeService {

    private List<Coffee> coffees = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);

    public List<Coffee> findAll() {
        return coffees;
    }

    public Optional<Coffee> findOne(Integer id) {
        return coffees.stream().filter(coffee -> coffee.id() == id).findFirst();
    }

    public Coffee create(Coffee randomCoffee) {
        Coffee coffee = new Coffee(id.incrementAndGet(),randomCoffee.file());
        coffees.add(coffee);
        return coffee;
    }
}
