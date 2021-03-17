package com.arhohuttunen.junit5;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Product {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;

    public Product() {

    }

    public Product(@NotNull Long id, @NotBlank String name, @NotNull BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
