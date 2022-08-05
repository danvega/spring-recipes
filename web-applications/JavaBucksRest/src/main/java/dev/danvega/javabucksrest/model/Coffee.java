package dev.danvega.javabucksrest.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public record Coffee(
        Integer id,
        @NotEmpty
        String name,
        Size size,
        @Max(10)
        BigDecimal price,
        BigDecimal cost) {
}