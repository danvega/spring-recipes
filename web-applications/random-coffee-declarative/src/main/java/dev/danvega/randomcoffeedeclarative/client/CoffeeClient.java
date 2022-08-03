package dev.danvega.randomcoffeedeclarative.client;

import dev.danvega.randomcoffeedeclarative.model.Coffee;
import org.springframework.web.service.annotation.GetExchange;

public interface CoffeeClient {

    @GetExchange("/random.json")
    Coffee random();

}
