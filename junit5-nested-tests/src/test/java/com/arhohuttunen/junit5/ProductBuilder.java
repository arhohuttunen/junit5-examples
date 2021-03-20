package com.arhohuttunen.junit5;

import java.math.BigDecimal;

public class ProductBuilder {
    private Long id = 1L;
    private String name = "Some product";
    private BigDecimal price = BigDecimal.valueOf(5.0);

    public static ProductBuilder aProduct() {
        return new ProductBuilder();
    }

    public static ProductBuilder anInvalidProduct() {
        ProductBuilder builder = new ProductBuilder();
        builder.id = null;
        builder.name = null;
        builder.price = null;
        return builder;
    }

    public ProductBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withPrice(Double price) {
        this.price = BigDecimal.valueOf(price);
        return this;
    }

    public Product build() {
        return new Product(id, name, price);
    }
}
